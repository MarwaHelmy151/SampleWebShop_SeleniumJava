package cucumberRahul;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@CucumberOptions(features = "src/cucumberRahul", glue = "stepDefinitionRahul", monochrome = true, tags = "@Regression", plugin = {
//		"html:target/cucumber.html" })
//public class TestNGTestRunner extends AbstractTestNGCucumberTests {
//
//}

@CucumberOptions(plugin = { "pretty",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }, features = "src/cucumberRahul", glue = "stepDefinitionRahul")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
