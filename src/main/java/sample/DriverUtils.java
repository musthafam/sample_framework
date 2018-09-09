package sample;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;


/**
 * 
 * @author Musthafa
 * This class will all have all common methods for Handling elements
 *
 */
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
	

	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param elementname - Name of the element which is for reporting purpose
	 */
	public void click(String locator,String elementName) {
		driver.findElement(By.xpath(locator)).click();
		test.log(LogStatus.INFO, "Clicking on Element -->"+elementName);
	}
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param selectionValue - Value to be selected in drop down
	 */
	public void selectByVisibleName(String locator,String selectionValue) {
		Select oSelect = new Select(driver.findElement(By.xpath(locator)));
		oSelect.selectByVisibleText(selectionValue);
		test.log(LogStatus.INFO, "Selecting "+selectionValue+" from Drop down:");
		
	}
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param elementName - Name of the element which is for reporting purpose
	 * @return No of elements found for the given locator
	 */
	public int noOfElements(String locator , String elementName) {
		int noOfElements = 0;
		noOfElements = driver.findElements(By.xpath(locator)).size();
		test.log(LogStatus.INFO, "no of elements for "+elementName+ "is -->"+noOfElements);
		return noOfElements;
	}
	
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param elementName - Name of the element which is for reporting purpose
	 * @return returns the text from the given locator
	 */
	public String getText(String locator , String elementName) {
		String text = "";
		text = driver.findElement(By.xpath(locator)).getText();
		return text;
	}
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param elementName  - Name of the element which is for reporting purpose
	 * @return list of webElements
	 */
	public List<WebElement> getListOfElements(String locator , String elementName) {
		test.log(LogStatus.INFO, "Getting the list of "+elementName);
		return driver.findElements(By.xpath(locator));
		
	}
	
	/**
	 * 
	 * @param index - Index of the iframe to which we intend to switch
	 */
	public void switchToiFrameByIndex(int index) {
		test.log(LogStatus.INFO, "Switching to iframe via Index -->"+index);
		driver.switchTo().frame(index);
	}
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param frameName - Name of the frame which is for reporting purpose
	 */
	public void switchToiFrameByLocator(String locator, String frameName) {
		test.log(LogStatus.INFO, "Switching to iframe via frame locator -->"+frameName);
		driver.switchTo().frame(locator);
	}
	
	public void switchToDefaultContent() {
		test.log(LogStatus.INFO, "Switching to default contnet");
		driver.switchTo().defaultContent();
	}
	
	/**
	 * 
	 * @param locator - id or the xpath of the element
	 * @param elementName  - Name of the element which is for reporting purpose
	 */
	public void moveToElement(String locator, String elementName) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
		test.log(LogStatus.INFO, "Moving to the element-->"+elementName);
	}
	
	/**
	 * 
	 * @param fromElement - id or the xpath of the element
	 * @param toElement - id or the xpath of the element
	 * @param fromElementName - Name of the element which is for reporting purpose
	 * @param toElementName - Name of the element which is for reporting purpose
	 */
	public void dragAndDrop(String fromElement, String toElement,String fromElementName, String toElementName) {
		Actions act = new Actions(driver);
		act.dragAndDrop(driver.findElement(By.xpath(fromElement)), driver.findElement(By.xpath(toElement))).build().perform();
		test.log(LogStatus.INFO, "Drag and drop from-->"+fromElementName+" to the element-->"+toElementName);
	}

}
