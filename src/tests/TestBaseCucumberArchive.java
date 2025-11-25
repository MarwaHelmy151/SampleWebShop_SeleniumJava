package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBaseCucumberArchive extends AbstractTestNGCucumberTests {
	public static WebDriver driver;

	@BeforeSuite
	public void startDriver() {

		System.setProperty("webdriver.chrome.driver",
				"\\Users\\mahelmy\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.navigate().to("https://demowebshop.tricentis.com/");
	}

	@AfterSuite
	public void stopDriver() {
		driver.quit();

	}
}
