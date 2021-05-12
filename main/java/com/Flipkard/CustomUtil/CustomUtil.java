package com.Flipkard.CustomUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomUtil {
	
	public static Properties prop = new Properties();

	public static String getLocator(String locatorName) {
		String locator = "";
		
		
		try {
			
			FileInputStream fis = new FileInputStream("/KDDFlipkard10/src/main/resources/FlipkardObjectRepositry.properties");
			prop.load(fis);
			locator = prop.getProperty(locatorName);

		} catch (FileNotFoundException e) {
			System.out.println("Object repository not Found");
			e.printStackTrace();

		} catch (IOException e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
		return locator;

	}
public static String[] getLocatorValue(String locatorName) {
	return getLocator(locatorName).split("##");

}
}
	
