package com.CRM.vTiger1.genericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getrandom() {
		Random r = new Random();
		int value = r.nextInt(1000);
		return value;
	}
	
	public String sysDateTime()
	{
		Date d=new Date();
		String date = d.toString();
		return date;
	}
	public String modifiedDateTime()
	{
		Date d=new Date();
		String[] date=d.toString().split(" ");
		//String day=date[0];
		String month=date[1];
		String daTe=date[2];
		String time=date[3].replace(':', '-');
		String year=date[5];
		String value=daTe+" "+time+" "+month+" "+year;
		return value;
	}
}
