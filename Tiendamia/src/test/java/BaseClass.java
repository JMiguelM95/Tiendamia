

import static driver.DriverManager.DRIVER;
import static driver.ExtentManager.EXTENT;

import static configuration.Config.CONFIG;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.codeborne.selenide.WebDriverRunner;

import driver.ExtentManager;


public class BaseClass {

	 //private static Logger LOGGER = Logger.getLogger("InfoLogging");
	
	static WebDriverWait wait;
	
	public static String Product;
	public static String Quantity;
	public static Integer TotalProducts;
	public static String OtherProduct;
	
	
	 @BeforeClass(alwaysRun = true)
	 @Parameters(value = {"url", "platform"} )
	    public void beforeTest(ITestContext context, String url, String platform) {

		 	ExtentManager.startTest();
		 	CONFIG.setTestEnvironment();
			
		 	switch (platform)
	        {
	        case "Chrome":
	        	DRIVER.chromeDriverConnection();
	        	break;
	        case "Firefox":
	        	DRIVER.firefoxDriverConnection();
	        	break;
	        case "Edge":
	        	DRIVER.edgeDriverConnection();
	        	break;
	        default:
	        	DRIVER.chromeDriverConnection();
	        	break;
	        }
	        
	        DRIVER.maximizeBrowser();
	        WebDriverRunner.setWebDriver(DRIVER.getURL(url));
	        Product = System.getProperty("Product");
	        Quantity = System.getProperty("Quantity");
	        TotalProducts =  Integer.parseInt(System.getProperty("TotalProducts"));
	        OtherProduct =System.getProperty("OtherProduct");
	 }
	 
	 @AfterClass(alwaysRun = true)
	    public void afterTest(final ITestContext testContext) {
		EXTENT.endReport();
	    DRIVER.closeDriver();
	
	 }
}
