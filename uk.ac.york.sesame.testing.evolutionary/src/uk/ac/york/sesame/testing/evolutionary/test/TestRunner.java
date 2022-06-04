package uk.ac.york.sesame.testing.evolutionary.test;

import java.io.IOException;

import uk.ac.york.sesame.testing.evolutionary.utilities.TestRunnerUtils;

public class TestRunner {
    public static void main(String [] args) {

            try {
                    TestRunnerUtils.exec("Test_29_05_2022_02_02_43TestingTestSuiteRunner");
            } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

//          try {
//                  int status = JavaProcess.exec(Test_29_05_2022_02_02_43TestingTestSuiteRunner.class, new ArrayList<String>());
//                  System.out.println("Test status = " + status);
//          } catch (IOException e) {
//                  // TODO Auto-generated catch block
//                  e.printStackTrace();
//          } catch (InterruptedException e) {
//                  // TODO Auto-generated catch block
//                  e.printStackTrace();
//          }
    }
}
