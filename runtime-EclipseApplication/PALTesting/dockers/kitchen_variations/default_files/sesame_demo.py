#! /usr/bin/python3

import json
import rospy
import os
import actionlib
import numpy

from std_msgs.msg import String, Bool, Float64, UInt8
from move_base_msgs.msg import MoveBaseAction, MoveBaseGoal
from geometry_msgs.msg import PoseWithCovarianceStamped
from std_srvs.srv import Empty
from dock_charge_sm_msgs.msg import GoAndDockAction, GoAndDockGoal

class SesameMissionController:
    def __init__(self) -> None:

        rospy.loginfo("[APPLICATION opendr_receptionist] initialising...")
        self.node_coordinates = {1: [POI1_X, POI1_Y, 0],
                            2: [POI2_X, POI2_Y, 0],
                            3: [POI3_X, POI3_Y, 0],
                            4: [0.5590212345123291, 3.5162105560302734, 0],
                            5: [-1.696423053741455, 2.3178114891052246, 0],
                            6: [-2.004892349243164, 4.027853012084961, 0],
                            7: [POI7_X, POI7_Y, 0],
                            8: [POI8_X, POI8_Y, -1.36],
                            9: [POI9_X, POI9_Y, 1.75],
                            10: [-3.3382983207702637, 5.832207679748535, 0],
                            11: [-3.9589688777923584, 3.889329433441162, 0],
                            12: [-5.162928104400635, 4.899382591247559, 0],
                            13: [-6.0311994552612305, 3.656623125076294, 0],            
                            14: [-7.580757141113281, 3.1329941749572754, 0],
                            15: [-8.986037254333496, 3.7755208015441895, 0],
                            16: [-8.459959983825684, 2.31423020362854, 0],
                            17: [-8.72947883605957, 1.5446338653564453, 0],
                            18: [-8.611783981323242, -0.8975491523742676, 0],
                            19: [-7.263755798339844, -0.7644484043121338, 0],
                            20: [-5.31575870513916, -0.5309460163116455, 0],
                            21: [0,0,0] }
        self.grasping_robot_failure = ""
        self.failing_robot_failure = ""
        self.spare_robot_failure = ""
        self.failing_robot_failed = False
        self.failing_robot_nav_impaired = False
        self.failing_robot_localization_status = True
        self.delivery_robot = "pmb2_1"
        self.failing_robot = "pmb2_1"
        self.spare_robot = "omni_base_1"
        self.grasping_robot = "tiago_1"
        self.last_delivery_poi = 0
        self.has_object_failing_robot = False
        self.has_object_spare_robot = False
        self.has_object_grasping_robot = False
        self.timeout = rospy.Duration(30)
        rospy.Subscriber("/"+self.grasping_robot+"/performance", String, self.grasping_robot_performance_cb)
        rospy.Subscriber("/"+self.failing_robot+"/performance", String, self.failing_robot_performance_cb)
        rospy.Subscriber("/"+self.spare_robot+"/performance", String, self.spare_robot_performance_cb)
        rospy.Subscriber("/"+self.failing_robot+"/robot_pose", PoseWithCovarianceStamped, self.failing_robot_get_pose_cb)
        rospy.Subscriber("/"+self.spare_robot+"/robot_pose", PoseWithCovarianceStamped, self.spare_robot_get_pose_cb)
        rospy.Subscriber("/mislocalization_detector_node/state", UInt8, self.mislocalization_detector_cb)
        self.failing_robot_impaired_pub = rospy.Publisher("/"+self.failing_robot+"/conserts/pal/nav_impaired", Bool, queue_size=10)
        self.failing_robot_loaded_pub = rospy.Publisher("/"+self.failing_robot+"/conserts/pal/loaded", Bool, queue_size=10)
        self.failing_robot_localization_pub = rospy.Publisher("/"+self.failing_robot+"/conserts/pal/localization_status", Bool, queue_size=10)
        self.ring_alarm_pub = rospy.Publisher("/"+self.failing_robot+"/ring_alarm", Bool, queue_size=10)
        self.spare_robot_impaired_pub = rospy.Publisher("/"+self.spare_robot+"/conserts/pal/nav_impaired", Bool, queue_size=10)
        self.spare_robot_loaded_pub = rospy.Publisher("/"+self.spare_robot+"/conserts/pal/loaded", Bool, queue_size=10)
        self.spare_robot_localization_pub = rospy.Publisher("/"+self.spare_robot+"/conserts/pal/localization_status", Bool, queue_size=10)
        self.grasping_robot_impaired_pub = rospy.Publisher("/"+self.grasping_robot+"/conserts/pal/nav_impaired", Bool, queue_size=10)
        self.grasping_robot_loaded_pub = rospy.Publisher("/"+self.grasping_robot+"/conserts/pal/loaded", Bool, queue_size=10)
        self.grasping_robot_localization_pub = rospy.Publisher("/"+self.grasping_robot+"/conserts/pal/localization_status", Bool, queue_size=10)  
        self.move_base_action_grasping_robot = actionlib.SimpleActionClient(self.grasping_robot+'/move_base', MoveBaseAction)
        self.move_base_action_spare_robot = actionlib.SimpleActionClient(self.spare_robot+'/move_base', MoveBaseAction)
        self.move_base_action_failing_robot = actionlib.SimpleActionClient(self.failing_robot+'/move_base', MoveBaseAction)
        self.go_and_dock_action_failing_robot = actionlib.SimpleActionClient(self.failing_robot+'/move_base', GoAndDockAction)
        self.clear_grasping_robot_costmap = rospy.ServiceProxy(self.grasping_robot+'/move_base/clear_costmaps', Empty)
        rospy.Timer(rospy.Duration(0.1), self.conserts_cb, oneshot=False)
        rospy.loginfo("Initialization complete")

    def conserts_cb(self, event):
        # impaired topic
        self.grasping_robot_impaired_pub.publish(False)
        self.spare_robot_impaired_pub.publish(False)
        self.failing_robot_impaired_pub.publish(self.failing_robot_nav_impaired)
        # loaded topic
        self.failing_robot_loaded_pub.publish(self.has_object_failing_robot)
        self.spare_robot_loaded_pub.publish(self.has_object_spare_robot)
        self.grasping_robot_loaded_pub.publish(self.has_object_grasping_robot)
        # localization topic
        self.failing_robot_localization_pub.publish(self.failing_robot_localization_status)
        self.spare_robot_localization_pub.publish(True)
        self.grasping_robot_localization_pub.publish(True)
        
    def mislocalization_detector_cb(self, data):
        if data.data == 0:
            self.failing_robot_localization_status = True
        elif data.data in [1,2]:
            self.failing_robot_localization_status = False

    def grasping_robot_performance_cb(self, data):
        self.grasping_robot_failure = data.data

    def failing_robot_performance_cb(self, data):
        self.failing_robot_failure = data.data
        if self.failing_robot_failure in ['help','alarm','rtd']:
            rospy.loginfo("failing_robot failure")
            self.failing_robot_failed = True
            self.delivery_robot = self.spare_robot
            self.move_base_action_spare_robot.cancel_all_goals()
            self.move_base_action_failing_robot.cancel_all_goals()
            self.move_base_action_grasping_robot.cancel_all_goals()
            rospy.sleep(5)
            if self.failing_robot_failure == 'help':
                self.recovery_behavior()
            if self.failing_robot_failure == 'alarm':
                self.ring_alarm_pub.publish(True)
            if self.failing_robot_failure == 'rtd':
                self.send_robot_to_pose(self.failing_robot,21)
            self.failing_robot_failure = ""

    def spare_robot_performance_cb(self, data):
        self.spare_robot_failure = data.data

    def spare_robot_get_pose_cb(self, data):
        self.spare_robot_pose = data.pose

    def failing_robot_get_pose_cb(self, data):
        self.failing_robot_pose = data.pose

    def send_robot_to_pose(self,robot,poi, wait=False):
        if self.failing_robot_failure not in ['help','alarm']:
            pose_goal = MoveBaseGoal()
            pose_goal.target_pose.header.frame_id="map"
            for k,v in self.node_coordinates.items():
                if poi == k:
                    rospy.loginfo(str(k)+str(v))
                    pose_goal.target_pose.pose.position.x = v[0]
                    pose_goal.target_pose.pose.position.y = v[1]
                    pose_goal.target_pose.pose.orientation.z = numpy.cos(v[2]/2)
                    pose_goal.target_pose.pose.orientation.w = numpy.sin(v[2]/2)
            if robot == self.spare_robot and self.failing_robot_failure not in ['rtd']:
                rospy.loginfo("Sending spare_robot to" + str(poi))
                if wait is True:
                    self.move_base_action_spare_robot.send_goal_and_wait(pose_goal, self.timeout)
                else:
                    self.move_base_action_spare_robot.send_goal(pose_goal)
            elif robot == self.failing_robot:
                rospy.loginfo("Sending failing_robot to" + str(poi))
                if wait is True:
                    yolo = self.move_base_action_failing_robot.send_goal_and_wait(pose_goal, self.timeout)
                    if not yolo:
                        self.failing_robot_nav_impaired = True
                else:
                    self.move_base_action_failing_robot.send_goal(pose_goal)
            elif robot == self.grasping_robot and self.failing_robot_failure not in ['rtd']:
                rospy.loginfo("Sending grasping_robot to" + str(poi))
                if wait is True:
                    self.move_base_action_grasping_robot.send_goal_and_wait(pose_goal, self.timeout)
                else:
                    self.move_base_action_grasping_robot.send_goal(pose_goal)

    def base_pickup(self,robot):
        if self.failing_robot_failure not in ['help','alarm','rtd']:
            if self.has_object_grasping_robot is True:
                self.send_robot_to_pose(self.grasping_robot,8, True)
                self.send_robot_to_pose(self.spare_robot, 7 , True)
                self.has_object_grasping_robot = False
                self.has_object_spare_robot = True
                rospy.loginfo("Placing on spare_robot robot after failing")
                self.send_robot_to_pose(self.spare_robot, self.last_delivery_poi , True)
            else:
                if self.failing_robot_failure not in ['help','alarm','rtd']:
                    if robot == self.failing_robot:
                        if self.failing_robot_failed is True:
                            self.has_object_spare_robot = False
                        else:
                            self.has_object_failing_robot = False
                    else:
                        self.has_object_spare_robot = False
                self.send_robot_to_pose(robot,7)
                self.send_robot_to_pose(self.grasping_robot,9, True)
                # Grasping pipeline
                if self.failing_robot_failure not in ['help','alarm','rtd']:
                    rospy.loginfo("Grasping")
                    self.has_object_grasping_robot = True
                self.send_robot_to_pose(self.grasping_robot,8, True)

                if robot == self.failing_robot:
                    yolo = self.move_base_action_failing_robot.wait_for_result(self.timeout)
                    if not yolo:
                        self.failing_robot_nav_impaired = True
                if robot == self.spare_robot:
                    self.move_base_action_spare_robot.wait_for_result(self.timeout)
                if self.failing_robot_failure not in ['help','alarm','rtd']:
                    # Placing pipeline
                    rospy.loginfo("Placing")
                    self.has_object_grasping_robot = False
                    if robot == self.failing_robot:
                        if self.failing_robot_failed is True:
                            self.has_object_spare_robot = True
                        else:
                            self.has_object_failing_robot = True
                    else:
                        self.has_object_spare_robot = True

    def recovery_behavior(self):
        if self.has_object_failing_robot is True:
            if self.failing_robot_failure not in ['alarm']:
                rospy.loginfo("Sending location to other robots for assistance")
                self.clear_grasping_robot_costmap()
                pose_goal = MoveBaseGoal()
                pose_goal.target_pose.header.frame_id="map"
                pose_goal.target_pose.pose.position.x = self.failing_robot_pose.pose.position.x - 0.60
                pose_goal.target_pose.pose.orientation.z = 0.0
                pose_goal.target_pose.pose.orientation.w = 1.0
                pose_goal.target_pose.pose.position.y = self.failing_robot_pose.pose.position.y - 0.50
                rospy.loginfo("Sendingspare_robot to failing robot for object retrival")
                self.move_base_action_spare_robot.send_goal_and_wait(pose_goal, self.timeout)
            if self.has_object_grasping_robot is True and self.failing_robot_failure not in ['alarm']:
                pose_goal.target_pose.pose.position.y = self.failing_robot_pose.pose.position.y
                pose_goal.target_pose.pose.orientation.z = numpy.cos(-1.57/2)
                pose_goal.target_pose.pose.orientation.w = numpy.sin(-1.57/2)
                rospy.loginfo("Sending grasping_robot to spare_robot to place object")
                self.move_base_action_grasping_robot.send_goal_and_wait(pose_goal, self.timeout)
                rospy.loginfo("Placing on spare robot")
                pose_goal.target_pose.pose.orientation.z = 0.0
                pose_goal.target_pose.pose.orientation.w = 1.0
                rospy.sleep(1)
                self.has_object_grasping_robot = False
            if self.failing_robot_failure not in ['alarm']:
                rospy.loginfo("Sending grasping_robot to faling_robot to take object")
                self.move_base_action_grasping_robot.send_goal_and_wait(pose_goal, self.timeout)
                rospy.loginfo("Grasping on failed robot")
                rospy.sleep(1)
                self.has_object_grasping_robot = True
                self.has_object_failing_robot = False
            if self.failing_robot_failure not in ['alarm']:
                pose_goal.target_pose.pose.position.y = self.failing_robot_pose.pose.position.y
                pose_goal.target_pose.pose.orientation.z = numpy.cos(-1.57/2)
                pose_goal.target_pose.pose.orientation.w = numpy.sin(-1.57/2)
                self.move_base_action_grasping_robot.send_goal_and_wait(pose_goal, self.timeout)
                rospy.loginfo("Placing on spare_robot robot")
                rospy.sleep(1)
                self.has_object_grasping_robot = False
                self.has_object_spare_robot = True

    def sesame_demo(self):
        rospy.sleep(2)
        self.send_robot_to_pose(self.spare_robot,2)
        self.ring_alarm_pub.publish(False)
        i = 0
        while not rospy.is_shutdown():
            if self.failing_robot_failure not in ['help','alarm','rtd']:
                self.base_pickup(self.delivery_robot)
                self.last_delivery_poi = i%3 + 1
                rospy.loginfo("self.last_delivery_poi: "+ str(self.last_delivery_poi))
                self.send_robot_to_pose(self.delivery_robot, self.last_delivery_poi , self.failing_robot_failed)
                self.base_pickup(self.spare_robot)
            if self.failing_robot_failure not in ['help','alarm','rtd']:
                i = i + 1
                self.last_delivery_poi = i%3 + 1
                rospy.loginfo("self.last_delivery_poi: "+ str(self.last_delivery_poi))
                self.send_robot_to_pose(self.spare_robot,self.last_delivery_poi , self.failing_robot_failed)


if __name__ == '__main__':
    rospy.init_node("sesame_mission_controller")
    spinner_py_node = SesameMissionController()
    spinner_py_node.sesame_demo()
    rospy.spin()
