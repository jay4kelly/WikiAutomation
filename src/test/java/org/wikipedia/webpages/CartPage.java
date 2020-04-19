package org.wikipedia.webpages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseProductPage{

	private static String CART = "Cart";
	private static Logger log = LogManager.getLogger(CartPage.class.getName());
	
	
	public CartPage(WebDriver driver) throws IOException {
		super(driver, CART);
		PageFactory.initElements(driver, this);
	}
	
	

}
