package org.wikipedia.cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/org/wikipedia/features/Cart.feature",
		glue = "org.wikipedia.stepDefinitions")
public class CartTestRunner extends AbstractTestNGCucumberTests {
}
