package configuration;

public enum Platform {
	
	FIREFOX("firefox"),
    CHROME("chrome"),
	SAFARI("safari");
	public final String driver;

    Platform(String platformType) {
        this.driver = platformType;
    }

}
