package org.wikipedia.stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.wikipedia.tests.BaseTest;
import org.wikipedia.webpages.AccessoriesPage;
import org.wikipedia.webpages.BasePage;
import org.wikipedia.webpages.CartPage;
import org.wikipedia.webpages.HomePage;
import org.wikipedia.webpages.MenPage;
import org.wikipedia.webpages.ProductDetailsPage;
import org.wikipedia.webpages.Wiki15Page;
import org.wikipedia.webpages.WomenPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinitions extends BaseTest {

	private static Logger log = LogManager.getLogger(StepDefinitions.class.getName());

	HomePage homePage = null;
	WomenPage womenPage = null;
	MenPage menPage = null;
	AccessoriesPage accessoriesPage = null;
	Wiki15Page wiki15Page = null;
	ProductDetailsPage productPage = null;
	CartPage cartPage = null;
	
	@Before
	public void setup() throws Exception {
		log.info("Initialize driver");
		initializeDriver();
	}

	@Given("^User is on \"([^\"]*)\" site$")  // Write out
	public void user_is_on_something_site(String strArg1) throws IOException {
		log.info("Go to Home Page");
		//For Home Page, navigate to page, for others, just check that it is displayed
		if (BasePage.HOME_PAGE.equalsIgnoreCase(strArg1)) {
			homePage = new HomePage(driver);
			homePage.openHomePage();
		} else if (BasePage.CART_PAGE.equalsIgnoreCase(strArg1)) {
			cartPage = new CartPage(driver);
			Assert.assertTrue("Cart page not displayed", cartPage.isPageOpened());
		}
		else {
			Assert.assertTrue("Unknown web page: " + strArg1, false);
		}
	}

	@Given("^User has added (.+) of (.+) and (.+) to cart$")
	public void user_has_added_of_and_to_cart(String product, String size, String quanity) throws IOException {
		log.info("Go to Womens Page");
		homePage.clickWomensDepartment();
		womenPage = new WomenPage(driver);
		Assert.assertTrue("Womens page not displayed", womenPage.isPageOpened());
		log.info("Add product: " + product + " of size: " + "size" + " and quanity: " + quanity + " to cart.");
		WebElement productLink = womenPage.getSelectedProduct(product);
		Assert.assertNotNull("The product " + product + " was not found.",productLink);
		//Go to project details page
		productLink.click();
		productPage = new ProductDetailsPage(driver,product);
		Assert.assertTrue("Product page for " + product + " not displayed", productPage.isPageOpened());
		productPage.selectSize(size);
		//TBD add quantity update
		productPage.addItemToCart();
		productPage.clickOnCartLink();
		cartPage = new CartPage(driver);
		Assert.assertTrue("Cart page not displayed", cartPage.isPageOpened());
	}

	@Then("^User selects currency (.+) value$")
	public void user_selects_currency_value(String currency) throws Throwable {
		log.info("Select currency: " + currency);
		homePage.selectCurrency(currency);
		Assert.assertTrue("Currency does not show up as selected. Currency: " + currency, homePage.isCurrencyDefault(currency));
	}

	@And("^Completes Check out$")
	public void completes_check_out() throws Throwable {
		//TODO add checkout process but do not complete final step that submits purchase to WikiStore
	}

	
	@Given("Cart is empty")
	public void cart_is_empty() {
	    // Write code here that turns the phrase above into concrete actions
		//TODO implement
	}

	@Given("User performs the following purchases and cart actions")
	public void user_performs_the_following_purchases_and_cart_actions(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		//TODO implement
	}

	@Then("User should have the following left in cart")
	public void user_should_have_the_following_left_in_cart(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
		//TODO implement
	}
	
	@After
	public void cleanUp() throws Exception {
		closeDriver();
	}
	
}