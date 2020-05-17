package org.wikipedia.webpages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.wikipedia.tests.TestProperties;

public class BasePage {

	protected TestProperties prop;

	public static String HOME_PAGE = "home_page";
	public static String CART_PAGE = "cart_page";

	@FindBy(how = How.CSS, using = "a.product_details")
	protected List<WebElement> productsOnPage;

	@FindBy(xpath = "//div[@id='bs-example-navbar-collapse-1']//a[@class='cart_link']")
	protected WebElement cartLink;

	@FindBy(xpath = "//div[@id='bs-example-navbar-collapse-1']//button[@class='btn dropdown-toggle btn-default']")
	protected WebElement currencyDropDown;

	@FindBy(xpath = "//div[@id='bs-example-navbar-collapse-1']//span[@class='filter-option pull-left']")
	protected WebElement selectedCurrency;

	public BasePage() throws IOException {
		prop = new TestProperties();
	}

	public WebElement getSelectedProduct(String name) {
		WebElement match = null;
		for (WebElement webElement : productsOnPage) {
			if (webElement.getText().contains(name)) {
				match = webElement;
				break;
			}
		}
		return match;
	}

	public void clickOnCartLink() {
		cartLink.click();
		// TODO add a check to see that cart is displayed
	}

	public void selectCurrency(String currency) {
		currencyDropDown.click();
		// WebElement ddLi = driver.findElement(By.xpath("//li[a[@id='drop4']]"));
		List<WebElement> curItems = currencyDropDown.findElements(
				By.xpath("//div[@class='btn-group bootstrap-select open']//a[contains(@style,'background-image')]"));
		WebElement match = null;
		for (WebElement curItem : curItems) {
			if (currency.equalsIgnoreCase(curItem.getText())) {
				match = curItem;
				curItem.click();
				break;
			}
		}
		Assert.assertNotNull("Currency value not found: " + currency, match);
	}

	public boolean isCurrencyDefault(String currency) {
		return selectedCurrency.getText().equalsIgnoreCase(currency);
	}
}
