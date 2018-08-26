package sample;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class DriverBase {
	protected static WebDriver driver;
	String browser = EnvParams.BROWSER_NAME;
	
	@BeforeMethod
	public void startDriver() {
		if(browser.equalsIgnoreCase("chrome")) {
			String chromeExePath = System.getProperty("user.dir")+File.separator+
					"src"+File.separator+"test"+File.separator+"resources"+File.separator+
					"drivers"+File.separator+"chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeExePath);
			driver = new ChromeDriver();
		}
		
	}
	
	

}
