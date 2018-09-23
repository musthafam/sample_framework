package com.practice.framework.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
		if(System.getenv("BUILD_NUMBER")!=null){
			ReportsPath = System.getProperty("user.dir")+File.separator+"test-output"
					+File.separator+System.getenv("BUILD_NUMBER")+File.separator+"TestReport.html";
		} else {
			ReportsPath = System.getProperty("user.dir")+File.separator+"test-output"
					+File.separator+"TestReport"+System.currentTimeMillis()+".html";
		}
		
		ExtentConfigPath = System.getProperty("user.dir")+File.separator+
				"src"+File.separator+"test"+File.separator+"resources"+File.separator+
				"ExtentConfig"+File.separator+"extentConfig.xml";
				
		extent= new ExtentReports(ReportsPath);
		extent.loadConfig(new File(ExtentConfigPath));
	}
	
	@Parameters("browserName")
	@BeforeMethod
	public void startDriver(@Optional("chrome") String browserName, Method method) {
		test = extent.startTest(this.getClass().getSimpleName()+"::"+method.getName());
		if(!browser.isEmpty()) {
			test.log(LogStatus.INFO, "Launching "+ browser +" Browser");
		} else {
			test.log(LogStatus.INFO, "Launching "+browserName+" Browser");
		}
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String screenShotPath = getScreenShot(this.getClass().getSimpleName());
			test.log(LogStatus.INFO, "Screenshot below"+test.addScreenCapture(screenShotPath));
		}
		extent.endTest(test);
	}
	
	@Parameters("browserName")
	@BeforeTest
	public void startDriverBeforeTest(@Optional("chrome") String browserName){
		if(!browser.isEmpty()) {
			if(browser.equalsIgnoreCase("chrome")) {
				String chromeExePath = System.getProperty("user.dir")+File.separator+
						"src"+File.separator+"test"+File.separator+"resources"+File.separator+
						"drivers"+File.separator+"chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeExePath);
				driver = new ChromeDriver();
			} else if(browser.equalsIgnoreCase("firefox")) {
				String geckoExePath = System.getProperty("user.dir")+File.separator+
						"src"+File.separator+"test"+File.separator+"resources"+File.separator+
						"drivers"+File.separator+"geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", geckoExePath);
				driver = new FirefoxDriver();
			} else if(browser.equalsIgnoreCase("ie")) {
				String geckoExePath = System.getProperty("user.dir")+File.separator+
						"src"+File.separator+"test"+File.separator+"resources"+File.separator+
						"drivers"+File.separator+"IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", geckoExePath);
				driver = new InternetExplorerDriver();
			} 
		} else {
			if(browserName.equalsIgnoreCase("chrome")) {
				String chromeExePath = System.getProperty("user.dir")+File.separator+
						"src"+File.separator+"test"+File.separator+"resources"+File.separator+
						"drivers"+File.separator+"chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", chromeExePath);
				driver = new ChromeDriver();
			} else if(browserName.equalsIgnoreCase("firefox")) {
				String geckoExePath = System.getProperty("user.dir")+File.separator+
						"src"+File.separator+"test"+File.separator+"resources"+File.separator+
						"drivers"+File.separator+"geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", geckoExePath);
				driver = new FirefoxDriver();
			} else if(browserName.equalsIgnoreCase("ie")) {
				String geckoExePath = System.getProperty("user.dir")+File.separator+
						"src"+File.separator+"test"+File.separator+"resources"+File.separator+
						"drivers"+File.separator+"IEDriverServer.exe";
				System.setProperty("webdriver.ie.driver", geckoExePath);
				driver = new InternetExplorerDriver();
			}
		}
		
	}
	
	@AfterTest
	public void quitAllBrowserSession() {
		driver.quit();
	}
	
	@AfterSuite
	public void flush() {
		extent.flush();
	}
	
	public static String getScreenShot(String ScreenshotName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String ScreenshotPath = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+ScreenshotName+System.currentTimeMillis()+".png";
		FileHandler.copy(Source, new File(ScreenshotPath));
		return ScreenshotPath;
		
	}
	

}
