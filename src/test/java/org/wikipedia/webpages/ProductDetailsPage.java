package org.wikipedia.webpages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductDetailsPage extends BaseProductPage {

	private static Logger log = LogManager.getLogger(ProductDetailsPage.class.getName());

	// Page WebElements are arranged by location on page starting from the top
	// and moving left to right. Please keep this order to add in maintaining this
	// page.

	@FindBy(how = How.CSS, using = "select.single-option-selector")
	protected WebElement sizeOptions;
	
	@FindBy(how = How.CSS, using = "input[name='add']")
	protected WebElement addToCartButton;
	

	public ProductDetailsPage(WebDriver driver, String productName) throws IOException {
		super(driver, productName);
		PageFactory.initElements(driver, this);
	}

	public void selectSize(String size) {
		Select s = new Select(sizeOptions);
		s.selectByVisibleText(size);
		Assert.assertTrue(s.getFirstSelectedOption().getText().contentEquals(size),
				"Selected option does not match size: " + size);
	}
	
	public void addItemToCart() {
		addToCartButton.click();
	}
	
}
