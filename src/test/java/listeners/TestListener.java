package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    
    @Override 
    public void onTestSuccess(ITestResult result) {

        System.out.println("----------------------------------------");
        System.out.println("TEST PASSED");
        System.out.println("Class  : " + result.getTestClass().getName());
        System.out.println("Method : " + result.getName());
        System.out.println("----------------------------------------");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("----------------------------------------");
        System.out.println("TEST FAILED");
        System.out.println("Class  : " + result.getTestClass().getName());
        System.out.println("Method : " + result.getName());

        if(result.getThrowable() != null){
            System.out.println("REASON: " + result.getThrowable().getMessage());
        }

        System.out.println("----------------------------------------");
    }
}
