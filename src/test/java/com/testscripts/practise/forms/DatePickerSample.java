package com.testscripts.practise.forms;

import org.testng.annotations.Test;

import com.practice.forms.pages.DatePickerPage;
import com.practice.framework.utils.DriverUtils;

public class DatePickerSample extends DriverUtils{
	
	@Test
	public void sampleDatePickerTest() {
		DatePickerPage DatePg = new DatePickerPage();
		DatePg.loadPage();
		DatePg.clickDatepickerMenu();
		DatePg.clickOnDatePickerBox();
		DatePg.clickOnMonth();
		DatePg.selectMonth();
		DatePg.selectYear();
		DatePg.selectDate(19);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DatePg.getDateAfterSelection();
	}

}
