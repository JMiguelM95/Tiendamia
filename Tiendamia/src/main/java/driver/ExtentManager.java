package driver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import static driver.DriverManager.DRIVER;
import configuration.ProjectProperties;

public enum ExtentManager {
	
	EXTENT;
	
	public static ExtentTest logger;
	public static ExtentReports extent;
	
	
	@BeforeTest
	public static void startTest() {
		extent = new ExtentReports(ProjectProperties.USER_DIR+"/test-output/STMExtentReport.html",true);
		extent.addSystemInfo("Host Name", "Automation Software Testing")
		.addSystemInfo("Enviroment", "Test")
		.addSystemInfo("User Name", "Miguel Miranda");
		extent.loadConfig(new File(System.getProperty(ProjectProperties.USER_DIR)+"\\extent-config.xml"));
	}
	
	public static String getScreenhot(String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) DRIVER.getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	
	
	@AfterTest
	public void endReport() {
		extent.flush();
	}
}

