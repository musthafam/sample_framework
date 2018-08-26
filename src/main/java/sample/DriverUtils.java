package sample;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.LogStatus;

public class DriverUtils extends DriverBase{
	
	/**
	 * 
	 * @param url - The Url of the app to be laoded
	 */
	public void startPage(String url) {
		driver.get(url);
		test.log(LogStatus.INFO, "Starting the driver");
	
	}
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param text -  the input text to be entered in the element
	 */
	public void type(String locator,String text) {
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(text);
		test.log(LogStatus.INFO, "Entering the text:"+text);
		
	}
	
	public boolean isElementPresent(String locator) {
		boolean isElementPresent = false;
		test.log(LogStatus.INFO, "Verifying the element present");
		try {
			if(driver.findElement(By.xpath(locator)).isDisplayed())
				isElementPresent=true;
			else
				isElementPresent=false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return isElementPresent;
	}

}
