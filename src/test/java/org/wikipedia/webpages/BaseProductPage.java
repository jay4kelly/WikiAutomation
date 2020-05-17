package org.wikipedia.webpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BaseProductPage extends BasePage {

	protected WebDriver driver;

	private String breadCrumb;
	
	// Home Page WebElements are arranged by location on page starting from the top 
	// and moving left to right. Please keep this order to add in maintaining this page.

	@FindBy(how = How.XPATH, using ="//ol[@class='breadcrumb']")
	protected WebElement activeBreadCrumb;
	
	public BaseProductPage(WebDriver driver, String activeBreadCrumb) throws IOException {
		super();
		this.driver = driver;
		this.breadCrumb = activeBreadCrumb;
		PageFactory.initElements(driver, this);
	}

	public boolean isPageOpened() { 
		WebElement element = activeBreadCrumb;
		String value = element.getText();			
		boolean result = value.contains(breadCrumb); 
		return result;
	}
}
