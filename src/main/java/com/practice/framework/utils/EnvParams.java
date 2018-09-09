package com.practice.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Musthafa
 * This class will load all the Environment related parameters
 *
 */
public class EnvParams {
	public static final String PROP_FILE = "config.properties";
	public static final String BROWSER_NAME;
	public static final String ROOT_FOLDER;
	
	private static Properties properties = new Properties();
	
	static {
		ROOT_FOLDER = System.getProperty("user.dir");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(PROP_FILE);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			properties.load(fis);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BROWSER_NAME=properties.getProperty("Browser");
	}

}
