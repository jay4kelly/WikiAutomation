package org.wikipedia.webpages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesPage extends BaseProductPage{
	
		private static String ACCESSORIES = "Accessories";
		private static Logger Log = LogManager.getLogger(AccessoriesPage.class.getName());
	
		// Page WebElements are arranged by location on page starting from the top 
		// and moving left to right. Please keep this order to add in maintaining this page.
	public AccessoriesPage(WebDriver driver, String activeBreadCrumb) throws IOException {
		super(driver, ACCESSORIES);
		PageFactory.initElements(driver, this);
		
	}


}
