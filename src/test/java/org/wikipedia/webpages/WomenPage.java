package org.wikipedia.webpages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.wikipedia.tests.BaseTest;

public class WomenPage extends BaseProductPage {
	

	private static String WOMEN = "Women";
	private static Logger log = LogManager.getLogger(WomenPage.class.getName());

	// Page WebElements are arranged by location on page starting from the top 
	// and moving left to right. Please keep this order to add in maintaining this page.

	
	public WomenPage(WebDriver driver) throws IOException {
		super(driver, WOMEN);
		PageFactory.initElements(driver, this);
	}

	

}
