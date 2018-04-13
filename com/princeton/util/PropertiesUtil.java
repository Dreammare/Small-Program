package com.princeton.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	static Properties property = new Properties();
	
	
	public static boolean loadFile(String fileName) {
		try {
			//The first type of reading properties
			//property.load(new FileInputStream(fileName));
			
			//The second type of reading properties
			InputStream inStream = new BufferedInputStream(new FileInputStream(fileName));
			property.load(inStream);
			
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static String getPropertyValue(String key) {
		return property.getProperty(key);
	}

}
