package configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.jetbrains.annotations.NotNull;

import lombok.extern.log4j.Log4j2;

@Log4j2
public enum Config {
	 CONFIG;
	
	 private final ThreadLocal<Configuration> TEST_ENVIRONMENT = new ThreadLocal<Configuration>();
	    private static Logger LOGGER = Logger.getLogger("InfoLogging");
	
    private void setSystemPropertyIfNotExist(String systemProperty, String defaultValue) {
        if (System.getProperty(systemProperty) == null)
            System.setProperty(systemProperty, defaultValue);
    }

    @NotNull
    private String getConfigFilePath() {
        String configPath = ProjectProperties.USER_DIR
                .concat("/resources/env/")
                .concat(ProjectProperties.BUILD_ENVIRONMENT)
                .concat(".properties");

        LOGGER.info("config path: " + configPath);
        return configPath;
    }

    private void setSystemPropertiesFromFile(Configuration configuration) {
        List<String> configKeys = new ArrayList<>();
        configuration.getKeys().forEachRemaining(configKeys::add);
        for (String key : configKeys) {
            System.setProperty(key, configuration.getString(key));
        
        }
    }

    public void setTestEnvironment() {
        setSystemPropertyIfNotExist("build_env", ProjectProperties.BUILD_ENVIRONMENT);
        if (TEST_ENVIRONMENT.get() == null) {
            try {
           
                TEST_ENVIRONMENT.set(new PropertiesConfiguration(getConfigFilePath()));

            
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
        }

        setSystemPropertiesFromFile(TEST_ENVIRONMENT.get());
    }

    public String getProperty(String propertyFilePath, String key) {
        Configuration configuration = null;
        try {
            configuration = new PropertiesConfiguration(propertyFilePath);
            ((AbstractConfiguration) configuration).setDelimiterParsingDisabled(true);
            ((AbstractConfiguration) configuration).setListDelimiter(',');
            
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return Objects.requireNonNull(configuration).getString(key);
    }

}
