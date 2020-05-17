package org.wikipedia.webpages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Wiki15Page extends BaseProductPage {

	private static String WIKI15 = "Wikipedia15"; // website dosent follow its naming scheme
	private static Logger log = LogManager.getLogger(Wiki15Page.class.getName());

	// Page WebElements are arranged by location on page starting from the top
	// and moving left to right. Please keep this order to add in maintaining this
	// page.

	public Wiki15Page(WebDriver driver) throws IOException {
		super(driver, WIKI15);
		PageFactory.initElements(driver, this);
	}
}
