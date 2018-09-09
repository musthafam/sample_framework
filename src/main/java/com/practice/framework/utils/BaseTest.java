package com.practice.framework.utils;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class BaseTest extends DriverUtils{
	
	public void assertEquals(String actual , String expected) {
		if(actual.equalsIgnoreCase(expected)) {
			test.log(LogStatus.PASS, "Assertion Passed, i.e <b>"+actual+"</b> is matching the <b>"+expected+"</b>");
		} else {
			test.log(LogStatus.FAIL, "Assertion failed, i.e <b>Expected</b>"+expected+ "  But <b>Actual</b> is "+actual );
			Assert.assertEquals(actual, expected);
		}
		
	}

}
