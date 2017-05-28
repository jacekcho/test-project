package com.demoqa.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private static final String FRAMEWORK_PROPERTIES = "framework.properties";

    private static PropertiesManager PROPERTIES_MANAGER;

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

    public String getBrowserTypeForTest() {
        return properties.getProperty("browser");
    }

    public String getChromeDriverWinPath() {
        return properties.getProperty("chromedriver.win.path");
    }

    public String getChromeDriverOxPath() {
        return properties.getProperty("chromedriver.ox.path");
    }

    public String getChromeDriverUnixPath() {
        return properties.getProperty("chromedriver.unix.path");
    }

    public String getGeckoDriverWinPath() {
        return properties.getProperty("geckodriver.win.path");
    }

    public String getGeckoDriverOxPath() {
        return properties.getProperty("geckodriver.ox.path");
    }

    public String getGeckoDriverUnixPath() {
        return properties.getProperty("geckodriver.unix.path");
    }

    public String getAutomationPracticeUrl() {
        return properties.getProperty("automationpractice.url");
    }

}
