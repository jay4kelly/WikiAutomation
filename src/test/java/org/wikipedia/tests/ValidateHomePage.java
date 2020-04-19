package org.wikipedia.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.wikipedia.webpages.HomePage;
import org.wikipedia.webpages.SearchPage;
import org.wikipedia.webpages.WomenPage;


public class ValidateHomePage extends BaseTest{
	
	private static Logger log = LogManager.getLogger(ValidateHomePage.class.getName());

	private HomePage hp;
	
	@BeforeTest
	public void initialize() throws Exception {
		initializeDriver();
	}
	
	@Test
	public void openHomePage() throws IOException {
		hp = new HomePage(driver);
		hp.openHomePage();
	}

	@Test(dependsOnMethods =  "openHomePage")
	public void validateElementsAreDisplayed() {
		log.info("Validate all elements exist on home page.");
		//Place elements in order starting at the top and left to right
		Assert.assertTrue(hp.isSearchDisplayed(),"search is not displayed");
		Assert.assertTrue(hp.isWomensDepartmentDisplayed(),"womens dept is not displayed");
		Assert.assertTrue(hp.isMensDepartmentDisplayed(),"mens is not displayed");
		//TBD add rest of home page elements to check
		log.info("All elements exist on home page.");

	}
	
	@Test(dependsOnMethods = "validateElementsAreDisplayed")
	public void validateLinks() throws IOException {
		log.info("Validate all links work on home page.");
		//Place elements in order starting at the top and left to right
		hp.enterSearchStringAndEnter("hoodie");
		SearchPage sp = new SearchPage(driver);
		Assert.assertTrue(sp.isPageOpened(),"search page bread crumb not displayed");
		driver.get(prop.getBaseURL());
		hp.clickWomensDepartment();
		WomenPage wp = new WomenPage(driver);
		Assert.assertTrue(wp.isPageOpened(),"Women page bread crumb not displayed");

		//TBD add rest of home page links to click
		log.info("All links work on home page.");
	}
	
	@AfterTest
	public void cleanUp()  {
		driver.close();
		log.info("Closed Browser");
		driver = null;	}
	
}
