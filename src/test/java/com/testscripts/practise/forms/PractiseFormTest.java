package com.testscripts.practise.forms;

import org.testng.annotations.Test;

import com.practice.forms.pages.PracticeForm;
import com.practice.framework.utils.DriverBase;

public class PractiseFormTest extends DriverBase{
	
	@Test
	public void verifyUI() {
		PracticeForm practisePg = new PracticeForm();
		practisePg.loadPage();
		practisePg.verifyFirstNamePresent();
		practisePg.verifyLastNamePresent();
	}
	

}
