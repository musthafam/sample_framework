package sample;

import org.openqa.selenium.By;

public class DriverUtils extends DriverBase{
	
	/**
	 * 
	 * @param url - The Url of the app to be laoded
	 */
	public void startPage(String url) {
		driver.get(url);
	
	}
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param text -  the input text to be entered in the element
	 */
	public void type(String locator,String text) {
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(text);
		
	}

}
