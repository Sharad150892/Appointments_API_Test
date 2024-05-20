package utils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

@SuppressWarnings("deprecation")
public class ExtentReportListner implements ITestListener {

	protected static ExtentReports reports;
	protected static ExtentTest test;
	public static ExtentHtmlReporter htmlReporter;

	private static String resultpath = getResultPath();

	public static void deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					System.out.println(files[i].getName());
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {

		resultpath = "test";// new SimpleDateFormat("yyyy-MM-dd hh-mm.ss").format(new Date());
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	
	
	public void onTestStart(ITestResult result) {

		test = reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName());
		System.out.println(result.getTestClass().getTestName());
		System.out.println(result.getMethod().getMethodName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test is pass");

	}
	
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test is fail");

	}
	
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Test is skipped");

	}
	
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
	
	
	@SuppressWarnings("deprecation")
	public void onStart(ITestContext context) {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Reports/ExtentReportsResult.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
	}
	
	
	public void onFinish(ITestContext context) {
//		reports.log(test);
		reports.flush();

	}

}
