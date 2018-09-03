package com.practice.forms.pages;

import com.relevantcodes.extentreports.LogStatus;

import sample.DriverUtils;

/**
 * 
 * @author Musthafa
 * Datepicker sample page class
 *
 */
public class DatePickerPage extends DriverUtils {
	
	private static String siteUrl = "http://demoqa.com/datepicker/";
	private static String monthAndYearXpath = "//*[contains(text(),'Display month & year')]";
	private static String datePickerXpath = "//*[@id='datepicker3']";
	private static String monthPickerXpath = "//*[@class='ui-datepicker-month']";
	private static String yearPicketXpath = "//*[@class='ui-datepicker-year']";
	private static String datefromTableXpath = "//*[@class='ui-datepicker-calendar']/tbody/tr";
	private static String dateforaWeek = "//*[@class='ui-datepicker-calendar']/tbody/tr[weekNumber]/td[dayNumber]/a";
	
	public void loadPage() {
		startPage(siteUrl);
	}
	
	public void clickDatepickerMenu() {
		if(isElementPresent(monthAndYearXpath)) {
			click(monthAndYearXpath,"Month and Year option in Side Menu");
		}
	}
	
	public void clickOnDatePickerBox() {
		if(isElementPresent(datePickerXpath)) {
			click(datePickerXpath,"Click on DatePicker Text Box");
		}
	}
	
	public void clickOnMonth() {
		if(isElementPresent(monthPickerXpath)) {
			click(monthPickerXpath,"Click on month Picker");
		}
	}
	
	public void selectMonth() {
		selectByVisibleName(monthPickerXpath, "Mar");
	}
	
	public void clickOnYear() {
		if(isElementPresent(yearPicketXpath)) {
			click(yearPicketXpath,"Click on Year Picker");
		}
	}
	
	public void selectYear() {
		selectByVisibleName(yearPicketXpath, "2020");
	}
	
	public void selectDate(int date) {
		int noOfWeeks = noOfElements(datefromTableXpath, "No of weeks from Datepicket table");
		for(int week=1;week<noOfWeeks;week++) {
			for(int day = 1;day<=7;day++) {
				if(isElementPresent(dateforaWeek.replace("weekNumber", String.valueOf(week)).replace("dayNumber", String.valueOf(day)))) {
					if(getText(dateforaWeek.replace("weekNumber", String.valueOf(week)).replace("dayNumber", String.valueOf(day)), "Date from Table").
							equals(String.valueOf(date))) {
						click(dateforaWeek.replace("weekNumber", String.valueOf(week)).replace("dayNumber", String.valueOf(day)), "Date from Table");
						
					}
					
				}
			}
		}
	}
	
	public void getDateAfterSelection() {
		System.out.println("Loggers-->"+getText(datePickerXpath, "Date Text box"));
	}
	

}
