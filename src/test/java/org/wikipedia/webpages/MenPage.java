package org.wikipedia.webpages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MenPage extends BaseProductPage{
	
	private static String MEN = "Men";
	private static Logger log = LogManager.getLogger(MenPage.class.getName());

	// Page WebElements are arranged by location on page starting from the top 
	// and moving left to right. Please keep this order to add in maintaining this page.

	
	public MenPage(WebDriver driver) throws IOException {
		super(driver, MEN);
		PageFactory.initElements(driver, this);
	}

}
