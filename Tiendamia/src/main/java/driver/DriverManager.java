package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import configuration.ProjectProperties;

public enum DriverManager {
	
	DRIVER;
	
	public WebDriver driver;
	
	final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

	public WebDriver getDriver() {
		return webDriver.get();
    }

	 public WebDriver chromeDriverConnection() {
		 System.out.println(ProjectProperties.USER_DIR);
		 String configPath = ProjectProperties.USER_DIR
	                .concat("/resources/driver/");
		 System.setProperty("webdriver.chrome.driver", configPath +"chromedriver.exe");
		 driver = new ChromeDriver();
		 webDriver.set(driver);
		 return driver;	 
	 }
	 

	 public WebDriver firefoxDriverConnection() {
		 String configPath = ProjectProperties.USER_DIR
	                .concat("/resources/driver/");
		 System.setProperty("webdriver.gecko.driver", configPath +"geckodriver.exe");
		 driver = new FirefoxDriver();
		 webDriver.set(driver);
		return driver;	 
	 }
	 
	 public WebDriver edgeDriverConnection() {
		 String configPath = ProjectProperties.USER_DIR
	                .concat("/resources/driver/");
		 System.setProperty("webdriver.edge.driver", configPath +"msedgedriver.exe");
		 driver = new EdgeDriver();
		 webDriver.set(driver);
		return driver;	 
	 }
	 
	 public void maximizeBrowser() {
		 driver.manage().window().maximize();
	 }
	 
	 public WebDriver getURL(String url) {
		 driver.get(url);
		return driver;
	
	 }
	 
	 public void closeDriver() {
	        driver.quit();
	    }
	 
	
}
