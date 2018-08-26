package sample;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverBase {
	protected static WebDriver driver;
	String browser = EnvParams.BROWSER_NAME;
	public static ExtentReports extent;
	public static ExtentTest test;
	String ReportsPath;
	String ExtentConfigPath;
	
	@BeforeSuite
	public void setExtentReport() {
		ReportsPath = System.getProperty("user.dir")+File.separator+"test-output"
				+File.separator+"TestReport"+System.currentTimeMillis()+".html";
		ExtentConfigPath = System.getProperty("user.dir")+File.separator+
				"src"+File.separator+"test"+File.separator+"resources"+File.separator+
				"ExtentConfig"+File.separator+"extentConfig.xml";
				
		extent= new ExtentReports(ReportsPath);
		extent.loadConfig(new File(ExtentConfigPath));
	}
	
	@BeforeMethod
	public void startDriver(Method method) {
		test = extent.startTest(this.getClass().getSimpleName()+"::"+method.getName());
		if(browser.equalsIgnoreCase("chrome")) {
			String chromeExePath = System.getProperty("user.dir")+File.separator+
					"src"+File.separator+"test"+File.separator+"resources"+File.separator+
					"drivers"+File.separator+"chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromeExePath);
			driver = new ChromeDriver();
		}
		test.log(LogStatus.PASS, "Browser Launched Successfully");
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		test.log(LogStatus.PASS, "Browser Closed Successfully");
		extent.endTest(test);
	}
	
	@AfterSuite
	public void flush() {
		extent.flush();
	}
	
	

}
