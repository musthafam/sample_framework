package com.testscripts.practise.forms;

import org.testng.annotations.Test;

import com.practice.forms.pages.AlertClass;
import com.practice.framework.utils.DriverUtils;

public class AlertTest extends DriverUtils{
	@Test
	public void alertTest() {
		AlertClass alertPage = new AlertClass();
		alertPage.loadPage();
		alertPage.acceptAlertMethod();
		alertPage.dismissAlertMethod();
		alertPage.promptAlert();
		alertPage.getTextFromAlertMethod();
	}

}
