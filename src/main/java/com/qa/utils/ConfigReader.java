package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    
    private Properties prop;

    /**
     * This method loads the properties from the appropriate config file based on the environment.
     * @return Properties object containing the loaded properties.
     */
    public Properties init_prop() {
//        String env = System.getProperty("ENV");        
//        if (env == null) {
//            throw new IllegalArgumentException("Environment variable 'ENV' is not set.");
//        }
    	String env = "QA";

        System.out.println("Environment: " + env);
        prop = new Properties();
        
        // Determine the config file path based on the environment
        String configFilePath = getConfigFilePath(env);
        
        // Load properties from the specified config file
        try (FileInputStream ip = new FileInputStream(configFilePath)) {
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties from " + configFilePath, e);
        }

        return prop;
    }

    /**
     * This method returns the path of the configuration file based on the environment.
     * @param env The environment for which to get the config file path.
     * @return The path to the configuration file.
     */
    private String getConfigFilePath(String env) {
        switch (env.toUpperCase()) { // Use upper case to avoid case sensitivity issues
            case "QA":
                return "./src/test/resources/configFile/configQA.properties";
            case "DEV":
                return "./src/test/resources/configFile/configDEV.properties";
            default:
                return "./src/test/resources/configFile/configQA.properties"; // Default to QA
        }
    }
}
