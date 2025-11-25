package cucumber_Archive;

import io.cucumber.testng.CucumberOptions;
import tests.TestBaseCucumberArchive;

@CucumberOptions(features = "src/cucumber_Archive", glue = "stepDefintion_Archive", tags = "@Regression", plugin = {
		"html:target/cucumber.html" })

public class TestNGTestRunner extends TestBaseCucumberArchive {
}
