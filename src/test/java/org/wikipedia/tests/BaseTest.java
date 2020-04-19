package org.wikipedia.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class BaseTest {

	private static Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	protected static WebDriver driver = null; // Static for now to support getting screen shot
	public TestProperties prop = null;
	private String SCREEN_SHOT_FOLDER = "screen-shots";
	private String PNG = ".png";
	private int fileIncrement = 1;


	
	public void initializeDriver() throws Exception {

		prop = new TestProperties();
		//TODO add option to get parameters from CI parameters that override property file
		
		if (prop.useChromeBrowser()) {
			System.setProperty("webdriver.chrome.driver", prop.getChromeDriverLocation());
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(prop.useHeadless());
			driver = new ChromeDriver(options);
		} else if (prop.useSafariBrowser()) {
			//TODO add headless for Safari driver
			SafariOptions options = new SafariOptions();
			driver = new SafariDriver(options);
		} else if (prop.useFirefoxBrowser()) {
			System.setProperty("webdriver.gecko.driver", prop.getFirefoxDriverLocation());
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(prop.useHeadless());
			driver = new FirefoxDriver();
		} else
		{
			log.error("No driver matching browser type");
			throw new Exception("Invalid browser type passed in by property file.");	
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.info("Initialized Driver");

	}

	public void closeDriver() {
		log.info("Close driver");
		driver.close();
	}
	
	public void getScreenShot(String testName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		int increment = fileIncrement++;
		String filePath = System.getProperty("user.dir") + File.separator + SCREEN_SHOT_FOLDER + File.separator
				+ testName + increment + PNG;
		log.info("Generated screen shot: " + filePath);
		FileUtils.copyFile(src, new File(filePath));
	}

}
