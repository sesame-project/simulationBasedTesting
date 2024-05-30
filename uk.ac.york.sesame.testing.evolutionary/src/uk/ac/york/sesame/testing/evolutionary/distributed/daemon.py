from netifaces import interfaces, ifaddresses, AF_INET
import subprocess
import Pyro5.api
import threading
import time
import uuid
import sys

from enum import IntEnum

#https://stackoverflow.com/questions/36932/how-can-i-represent-an-enum-in-python

# Circus: https://circus.readthedocs.io/en/latest/for-devs/library/#library
# Circus library can test e.g. the process status

# Worker daemon should also support STOP method... to e.g. terminate a test early
# Pre-test 

VERSION_ID = 0.27

#EXPT_RUNNER_CMD = "./execute_testrunner_stub.sh"

# TODO: replace these with script references into the project directory
EXPT_RUNNER_CMD = "/home/jharbin/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/execute_testrunner_soprano.sh"

COMPILE_RUNNER_CMD = "/home/jharbin/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/compile_project_soprano.sh"

RESYNC_RUNNER_CMD = "/home/jharbin/academic/sesame/WP6/simulationBasedTesting/uk.ac.york.sesame.testing.evolutionary/scripts/execute_testrunner_soprano.sh"

#BIND_ADDRESS = "192.168.1.239"
# TODO: need to lookup the bind address from the parameters on the command line
BIND_ADDRESS = "192.168.1.19"
NS_ADDRESS = "192.168.1.19"

NS_PORT = 9523
DAEMON_PORT = 9600

def get_en_ip_as_underscores():
    for ifaceName in interfaces():
        if "en" in ifaceName:
            addresses = [i['addr'] for i in ifaddresses(ifaceName).setdefault(AF_INET, [{'addr':'No IP addr'}] )]
            for a in addresses:
                return a.replace(".", "_")

# Uses the passed in node name as first arg; if nothing given, use the IP address
if len(sys.argv) > 1:
    node_name = sys.argv[1]
else:
    node_name = get_en_ip_as_underscores()
    
pyro_daemon_full_name = "SOPRANOWorkerDaemon_" + node_name
print("SOPRANO Worker Daemon node name: ", pyro_daemon_full_name)

# TODO: rename 'job' to 'test' throughout

# TODO: this needs to be supplied in the experiment config
#RUN_PATH = "/home/jharbin/eclipse-workspace/PALTesting"
RUN_PATH = "/mnt/shared-soprano-code/"

class DepCheckCodes(IntEnum):
    DEPS_OK = 0
    MISSING_DEP = 1

class TestStatusCodes(IntEnum):
    RUNNING = 0
    PENDING = 1
    COMPLETED = 2
    FAILED = 3

class MetricRegisterCode(IntEnum):
    OK = 0
    FAILED_INVALID_TEST = 1

# TODO: experiment is also a test campaign
class ExptConfig:
    def __init__(self,expt_name, dependency_spec):
        # TODO: how to get the class ID included here
        # TODO: how to setup the metrics
        self.expt_name = expt_name
        self.unique_run_id = str(uuid.uuid4())
        self.dependency_spec = dependency_spec

    def preinit(self):
        print("Preinitialising experiment: " + str(self))
        # TODO: Need to ensure all the dependencies are ready here!
        # e.g. docker, java/maven packages - from dependency_spec

    def get_unique_run_id(self):
        return self.unique_run_id

class TestRunJob:
    def __init__(self,test_id):
        # TODO: how to get the class ID included here
        self.test_id = test_id
        self.unique_run_id = str(uuid.uuid4())

    def prepare(self):
        # TODO: do the resync of the directory here
        resync_output = 0
        if (resync_output == 0):
        # Do the compilation
            print("Performing compilation for " + self.test_id)
            script_output = subprocess.call([COMPILE_RUNNER_CMD, RUN_PATH])
            return script_output
        else:
            return resync_output

    def execute(self):
        #Need to find named class file and generate the relevant run command!
        # The classname for the testrunner can be pro
        classname = self.test_id + "_TestRunner"
        print("Executing job for", self.test_id, ": classname is", classname)
        script_output = subprocess.call([EXPT_RUNNER_CMD, classname, RUN_PATH, pyro_daemon_full_name])
        return script_output

    def handle_logs():
        return OK
    
    def handle():
        self.prepare()
        self.execute()
        self.copy_logs()

    def get_unique_run_id(self):
        return self.unique_run_id

    def get_test_id(self):
        return self.test_id

daemon = Pyro5.api.Daemon(host=BIND_ADDRESS, port=DAEMON_PORT)
    
class WorkManager:
    def __init__(self, name):
        self.pending_jobs = []
        self.watcher = threading.Thread(target=self.watch_job_queue, name="WorkManagerWatcher", daemon=True)
        self.current_expt = {}

        # This maps the job unqiue run ID to a hash of info
        self.job_run_info = {}

        # The ID of the currently running test. We assume each node is only running one test simultaneously
        self.current_test_id = ""

        self.watcher.start()

        # Need to ensure we cannot start an experiment before another is completed!

    def set_job_status(self, job, status):
        urun_id = job.get_unique_run_id()
        self.job_run_info[urun_id]['status'] = status
        
    def watch_job_queue(self):
        while True:
            print("Polling incoming work queue - " + str(len(self.pending_jobs)) + " jobs registered")
            while len(self.pending_jobs) > 0:
                job = self.pending_jobs.pop()
                # Job is now running here
                self.current_test_id = job.get_test_id()
                self.set_job_status(job, TestStatusCodes.RUNNING)
                # Need to check nothing else is running now!
                job.prepare()
                job.execute()
                time.sleep(100)
		# block for a moment before testing again
            time.sleep(1)

    def get_current_test_id(self):
        return self.current_test_id

    def status_of_job(self, urun_id):
        # Need to verify if the process is still running!
        if urun_id in self.job_run_info:
            return self.job_run_info[urun_id]['status']
        else:
            return None
        
    def submit_test(self, j):
        self.pending_jobs.append(j)
        urun_id = j.get_unique_run_id()
        self.job_run_info[urun_id] = { 'status' : TestStatusCodes.PENDING }
        print("Job Manager: added job "+ str(j) + "- queue length is now " + str(len(self.pending_jobs)))

    def submit_experiment(self, expt):
        self.current_expt = expt
        print("Set experiment to " + exptconfig)

jobmanager = WorkManager("SOPRANO")

@Pyro5.api.expose
@Pyro5.server.behavior(instance_mode="single")
class SopranoWorkerDaemon(object):
    def __init__(self):
        # TODO: how to get the class ID included here
        self.metric_values = {}
    
    def get_version_id(self):
        return VERSION_ID

    def init_experiment(self, expt_name_dsl, dependencies):
        expt= ExptConfig(expt_name_dsl, dependencies)
        urun_id = exptj.get_unique_run_id()
        print("Checking the configuration for experiment campaign name in DSL - " + str(expt_name_dsl))
        depstatus = jobmanager.check_dependencies(expt)
        if (depstatus == DepCheckCodes.DEPS_OK):
              print("Dependencies OK... submitting experiment to expt manager")
              submit_experiment(expt)
        else:
              print("Dependency error")
              # TODO: details about the missing dependency

    def submit_test(self, test_id):
        # Need to verify preconditions - e.g. are the classes/etc availble in the filesystem?
        testj = TestRunJob(test_id)
        urun_id = testj.get_unique_run_id()
        print("Submitted job to run test ID " + str(test_id))
        jobmanager.submit_test(testj)
        return urun_id

    def poll_for_status(self, urun_id):
        status = jobmanager.status_of_job(urun_id)
        print("poll_for_status for " + str(urun_id) + " = " + str(status))
        return int(status)

    def update_metric(self, update_test_id, metric_name, metric_value, timestamp):
        # Verify that the test ID matches here
        jobmanager_test_id = jobmanager.get_current_test_id()
        if (jobmanager_test_id == update_test_id):
            self.metric_values[metric_name] = metric_value
            print(str(self) + " - update_metric " + metric_name + "=" + str(metric_value) + " (timestamp " + str(timestamp) + ")")
            return int(MetricRegisterCode.OK)
        else:
            print(str(self) + "METRIC rejected due to invalid test id - should be", jobmanager_test_id, " - received", update_test_id)
            return int(MetricRegisterCode.FAILED_INVALID_TEST)
    
    def get_all_metrics(self, target_test_id):
        # TODO: Receive the pending metrics for this
        jobmanager_test_id = jobmanager.get_current_test_id()
        if (jobmanager_test_id == target_test_id):
            return self.metric_values
        else:
            return []
    
wd_uri = daemon.register(SopranoWorkerDaemon)
ns = Pyro5.core.locate_ns(host = NS_ADDRESS, port = NS_PORT)
print("SOPRANO Worker Daemon Ready: Object uri =", wd_uri)       # print the uri so we can use it in the client later

# TODO: put in the IP address here!
ns.register(pyro_daemon_full_name, wd_uri)

print("Worker daemon registered with nameserver")

daemon.requestLoop()                    # start the event loop of the server to wait for calls
