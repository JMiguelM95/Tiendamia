package configuration;

public interface ProjectProperties {
	
	String USER_DIR = System.getProperty("user.dir");
    String BUILD_ENVIRONMENT = System.getProperty("build_env", Environment.TEST.env);
    String DRIVER_PLATFORM = System.getProperty("platform", Platform.FIREFOX.driver);
    String DRIVER_PLATFORM2 = System.getProperty("platform", Platform.CHROME.driver);
    String DRIVER_PLATFORM3 = System.getProperty("platform", Platform.SAFARI.driver);
    String HUB = System.getProperty("hub", Hub.LOCAL.runType);

}
