package com.CRM.vTiger1.genericUtility;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Properties;
/**
 * @author Soumyajit
 */
public class FileUtility {
	
	/**
	 * This is used to fetch data from properties file
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String toGetDataFromPropertyFile(String Key) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.propertyFilePath);
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;
	}
	
	public void toStoreDataToPropertyFile(String value) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.propertyFilePath);
		Properties property=new Properties();
		property.load(fis);
		@SuppressWarnings("resource")
		FileWriter writer=new FileWriter(IpathConstant.propertyFilePath);
		writer.write(value);
		writer.flush();
	}
}
