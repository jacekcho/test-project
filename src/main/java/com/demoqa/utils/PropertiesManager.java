package com.demoqa.utils;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private static final String FRAMEWORK_PROPERTIES = "framework.properties";

    private static PropertiesManager PROPERTIES_MANAGER;

    private final Properties properties;

    private final static Logger LOGGER = Logger.getLogger(PropertiesManager.class);

    private PropertiesManager() {
        LOGGER.info("FRAMEWORK_PROPERTIES: " + FRAMEWORK_PROPERTIES);
        try {
            this.properties = loadProperties();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PropertiesManager getInstance() {
        if (null == PROPERTIES_MANAGER) {
            PROPERTIES_MANAGER = new PropertiesManager();
        }
        return PROPERTIES_MANAGER;
    }

    private Properties loadProperties() throws IOException {
        Properties localProperties = new Properties();
        localProperties.load(PropertiesManager.class.getClassLoader().getResourceAsStream(FRAMEWORK_PROPERTIES));
        overwritePropertiesIfSystemDefined(localProperties);
        return localProperties;
    }

    private void overwritePropertiesIfSystemDefined(Properties localProperties) {
        LOGGER.info("Checking if some properties are overwritten...\n");
        for (String key : localProperties.stringPropertyNames()) {
            String systemProperty = System.getProperties().getProperty(key);
            if (systemProperty != null) {
                String oldValue = (String) localProperties.setProperty(key, systemProperty);
                LOGGER.info(String.format("Property %s overwritten from %s to %s\n", key, oldValue, systemProperty));
            }
        }
    }

    public String getDemoqaUrl() {
        return properties.getProperty("demoqa.url");
    }

    public String getDemoqapass() {
        return properties.getProperty("demoqa.pass");
    }

    public String getBrowserTypeForTest() {
        return properties.getProperty("browser");
    }

    public String getAutomationPracticeUrl() {
        return properties.getProperty("automationpractice.url");
    }

    public String getPathToDescription() {
        return properties.getProperty("description.path");
    }

    public String getPathToAvatar() {
        return properties.getProperty("avatar.path");
    }
}
