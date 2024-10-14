package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	/**
	 * this method is used to load the properties from config.properties file
	 * @return it return properties prop object
	 */
	public Properties init_prop() {
		String env = System.getProperty("ENV").toString();
//		String env = "QA";
		System.out.println("env is a ------ "+env);
		prop = new Properties();
		switch (env) {
		case "QA":
			System.out.println("Inside loop");
			try {
				FileInputStream ip = new FileInputStream("./src/test/resources/configFile/configQA.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "DEV":
			try {
				FileInputStream ip = new FileInputStream("./src/test/resources/configFile/configDEV.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			try {
				FileInputStream ip = new FileInputStream("./src/test/resources/configFile/configQA.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		return prop;
		
	}

}
