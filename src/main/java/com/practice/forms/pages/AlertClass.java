package com.practice.forms.pages;

import com.practice.framework.utils.DriverUtils;

/**
 * 
 * @author Musthafa
 * Page class for Alert scenario
 *
 */
public class AlertClass extends DriverUtils{
	
	private static String siteUrl = "http://toolsqa.com/handling-alerts-using-selenium-webdriver/";
	private static String simpleAlertXpath = "//*[@id='content']/p[4]/button";
	private static String confirmXpath = "//*[@id='content']/p[8]/button";
	private static String promptXpath = "//*[@id='content']/p[11]/button";
	
	public void loadPage() {
		startPage(siteUrl);
	}
	
	public void acceptAlertMethod() {
		click(simpleAlertXpath, "Simple Alert");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acceptAlert();
	}
	
	public void dismissAlertMethod() {
		click(confirmXpath, "Confirmation alert button");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dismissAlert();
	}
	
	public void promptAlert() {
		click(promptXpath, "Promt Alert");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendTextToAlert("Test");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acceptAlert();
		
	}
	
	public void getTextFromAlertMethod() {
		click(promptXpath, "Confirmation alert button");
		System.out.println(getTextFromAlert());
		acceptAlert();
	}
	

}
