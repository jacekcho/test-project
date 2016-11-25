package com.demoqa.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private static final String FRAMEWORK_PROPERTIES = "framework.properties";

    private static PropertiesManager propertiesManager;

    private final Properties properties;


    private PropertiesManager() {
        System.out.println("FRAMEWORK_PROPERTIES: " + FRAMEWORK_PROPERTIES);
        try {
            this.properties = loadProperties();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static PropertiesManager getInstance() {
        if (null == propertiesManager) {
            propertiesManager = new PropertiesManager();
        }
        return propertiesManager;
    }

    private Properties loadProperties() throws IOException {
        Properties localProperties = new Properties();
        localProperties.load(PropertiesManager.class.getClassLoader().getResourceAsStream(FRAMEWORK_PROPERTIES));
        overwritePropertiesIfSystemDefined(localProperties);
        return localProperties;
    }

    private void overwritePropertiesIfSystemDefined(Properties localProperties) {
        System.out.println("\nChecking if some properties are overwritten...\n");
        for (String key : localProperties.stringPropertyNames()) {
            String systemProperty = System.getProperties().getProperty(key);
            if (systemProperty != null) {
                String oldValue = (String) localProperties.setProperty(key, systemProperty);
                System.out.println(String.format("Property %s overwritten from %s to %s\n", key, oldValue, systemProperty));
            }
        }
    }

    public String getDemoqaUrl() {
        return properties.getProperty("demoqa.url");
    }

    public String getDemoqapass() {
        return properties.getProperty("demoqa.pass");
    }


}
