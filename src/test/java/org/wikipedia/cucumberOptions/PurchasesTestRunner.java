package org.wikipedia.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/org/wikipedia/features/Purchases.feature",
		glue = "org.wikipedia.stepDefinitions")
public class PurchasesTestRunner extends AbstractTestNGCucumberTests {
}
