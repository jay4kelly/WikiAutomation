package org.wikipedia.webpages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.wikipedia.tests.ValidateHomePage;

public class HomePage extends BasePage{

	private WebDriver driver;

	private static Logger log = LogManager.getLogger(ValidateHomePage.class.getName());

	// Page WebElements are arranged by location on page starting from the top 
	// and moving left to right. Please keep this order to add in maintaining this page.
	
	@FindBy(className = "navbar-brand")
	private WebElement wikipediaStore;
	
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//input[@placeholder='Search the store']")
	private WebElement searchInput;
	
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//a[contains(text(),'Women')]")
	private WebElement womensDepartment;
	
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//a[contains(text(),'Men')]")
	private WebElement mensDepartment;
	
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//a[contains(text(),'Wiki15')]")
	private WebElement wiki15Department;
	
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//a[contains(text(),'Accessories')]")
	private WebElement accessoriesDepartment;
	
	@FindBy(xpath="//div[@id='bs-example-navbar-collapse-1']//a[contains(text(),'Kids')]")
	private WebElement kidsDepartment;
	
	
	public HomePage(WebDriver driver) throws IOException {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openHomePage() {
		log.info("Open HomePage: " + prop.getBaseURL());
		driver.get(prop.getBaseURL());
		log.info("Validate Home Page is opened.");
		Assert.assertTrue(isPageOpened(), "Home Page did not open."); 
		log.info("Homepage opened.");		
	}
	
	public boolean isPageOpened() {
		return wikipediaStore.isDisplayed();
	}

	//Basic Element validations section
	
	public boolean isSearchDisplayed() {
		return searchInput.isDisplayed();
	}
	
	public boolean isWomensDepartmentDisplayed() {
		return womensDepartment.isDisplayed();
	}
	
	public boolean isMensDepartmentDisplayed() {
		return mensDepartment.isDisplayed();
	}
	
	public boolean isAccessoriesDepartmentDisplayed() {
		return accessoriesDepartment.isDisplayed();
	}
	
	public boolean isWiki15DepartmentDisplayed() {
		return wiki15Department.isDisplayed();
	}
	
	public boolean isKidsDepartmentDisplayed() {
		return kidsDepartment.isDisplayed();
	}
	
	
	// Navigation Operations sections
	
	public void clickWikipediaStore() {
		wikipediaStore.click();
	}
	

	public void enterSearchStringAndEnter(String value) {
		searchInput.sendKeys(value);
		searchInput.submit();
	}

	public void clickWomensDepartment() {
		womensDepartment.click();
	}
	
	public void clickMensDepartment() {
		mensDepartment.click();
	}	
	
	public void clickAccessoriesDepartment() {
		accessoriesDepartment.click();
	}
	
	public void clickWiki15Department() {
		wiki15Department.click();
	}
	
	public void clickKidsDepartment() {
		kidsDepartment.click();
	}
}
