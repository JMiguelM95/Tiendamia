package configuration;

public enum Hub {
	
		LOCAL("local"),
	    SAUCE_LABS("sauceLabs"),
		BROWSERSTACK("browsertack");
	    public final String runType;

	    Hub(String hub) {
	        this.runType = hub;
	    }

}
