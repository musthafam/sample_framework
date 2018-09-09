package com.practice.forms.pages;

import com.practice.framework.utils.DriverUtils;
import com.relevantcodes.extentreports.LogStatus;

public class PracticeForm extends DriverUtils{
	
	private static String url = "http://toolsqa.com/automation-practice-form/";
	private static String firstName = "//*[@name='firstname']";
	private static String lastName = "//*[@name='lastname']";
	
	public void loadPage() {
		startPage(url);
	}
	
	public void verifyFirstNamePresent() {
		if(isElementPresent(firstName))
			test.log(LogStatus.PASS, "First Name field is present in the page");
		else
			test.log(LogStatus.FAIL, "First Name field is not present in the page");
		highlightAnElement(firstName,"FirstName field");
		
	}
	
	public void verifyLastNamePresent() {
		if(isElementPresent(lastName))
			test.log(LogStatus.PASS, "Last Name field is present in the page");
		else
			test.log(LogStatus.FAIL, "Last Name field is not present in the page");
		highlightAnElement(lastName,"lastName field");
		
	}

}
