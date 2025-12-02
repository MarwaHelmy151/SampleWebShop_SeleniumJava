package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestBase {

	public static WebDriver driver;

	public WebDriver initalizeDriver() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\resources\\GlobalData.properties");
		prop.load(file);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"\\Users\\mahelmy\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// Firefox
		}

		else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to("https://demowebshop.tricentis.com/");
		return driver;
	}

	@BeforeClass(alwaysRun = true)
	public void launchApplication() throws IOException {
		driver = initalizeDriver();
	}

	@AfterClass(alwaysRun = true)
	public void closeApplication() {
		driver.quit();

	}

	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		// read json to String
		String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);

		// String to HashMap Jackson Datbind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

	// screenshot
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testcaseName + ".png";

	}

	// method to check if the pdf is downloaded
	public static File getLatestDownloadedPDF(String downloadDir, String filePrefix) {
		File dir = new File(downloadDir);
		File[] files = dir.listFiles((d, name) -> name.startsWith(filePrefix) && name.endsWith(".pdf"));
		if (files == null || files.length == 0) {
			return null; // No file found
		}
		// Return the most recently modified file
		return Arrays.stream(files).max(Comparator.comparingLong(File::lastModified)).orElse(null);
	}
}
