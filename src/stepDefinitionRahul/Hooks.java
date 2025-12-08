package stepDefinitionRahul;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import tests.TestBase;

public class Hooks extends TestBase {

	@Before
	public void beforeScenario() throws IOException {
		driver = initalizeDriver();
	}

	@After
	public void afterScenario() {
		driver.quit();
	}

//	@Attachment(value = "Screenshot", type = "image/png")
//	public byte[] saveScreenshotPNG() {
//		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//	}
}
