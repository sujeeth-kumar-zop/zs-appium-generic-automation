package com.zs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        if (extent == null) {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
            sparkReporter.config().setDocumentTitle("Android Automation Report");
            sparkReporter.config().setReportName("Functionality Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester Name", "SDET");
            extent.setSystemInfo("OS", "MacOS");
            extent.setSystemInfo("Device", "Android");
            extent.setSystemInfo("Device Name", "emulator-5554");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Case Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Case Failed: " + result.getName());
        test.log(Status.FAIL, "Failure Reason: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
}
