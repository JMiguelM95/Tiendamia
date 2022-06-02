package driver;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class IlistenerManager implements ITestListener {
	
	String screenshotPath;
	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart method started");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
		ExtentManager.extent.endTest(ExtentManager.logger);
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("New Test Started: " + result.getName());
		ExtentManager.logger = ExtentManager.extent.startTest(result.getName());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			screenshotPath = ExtentManager.getScreenhot(result.getName());
			System.out.println("onTestSuccess Method: " + result.getName());
			ExtentManager.logger.log(LogStatus.INFO, "Se finalizo la prueba "+ result.getName() + " con exito");
			ExtentManager.logger.log(LogStatus.PASS, result.getName() + ExtentManager.logger.addScreenCapture(screenshotPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			screenshotPath = ExtentManager.getScreenhot(result.getName());
		System.out.println("onTestFailure Method: " + result.getName());
		ExtentManager.logger.log(LogStatus.INFO, "La prueba "+ result.getName() + " ha sido fallida");
		ExtentManager.logger.log(LogStatus.FAIL, result.getThrowable() + ExtentManager.logger.addScreenCapture(screenshotPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			screenshotPath = ExtentManager.getScreenhot(result.getName());
		System.out.println("onTestSkipped Method: " + result.getName());
		ExtentManager.logger.log(LogStatus.SKIP, "Se salto la prueba "+result.getName()  + ExtentManager.logger.addScreenCapture(screenshotPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		try {
			screenshotPath = ExtentManager.getScreenhot(result.getName());
			System.out.println("onTestFailure Method: " + result.getName());
			ExtentManager.logger.log(LogStatus.INFO, "La prueba "+ result.getName() + " ha sido finalizada pero con algunos errores");
			ExtentManager.logger.log(LogStatus.PASS, result.getName()  + ExtentManager.logger.addScreenCapture(screenshotPath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
