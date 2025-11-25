package stepDefintion_Archive;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tests.TestBaseCucumberArchive;

public class Hooks extends TestBaseCucumberArchive {

	@Before
	public void beforeScenario() throws IOException {
		startDriver();
	}

	@After
	public void afterScenario() {
		driver.quit();
	}
}
