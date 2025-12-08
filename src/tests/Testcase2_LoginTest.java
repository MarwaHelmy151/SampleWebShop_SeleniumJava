package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;

public class Testcase2_LoginTest extends TestBase {

	// String email = "MariaTest3@gmail.com";
	// String password = "123456";
	HomePage homeobject;
	LoginPage loginobject;

	@BeforeMethod
	public void resetBeforeEachTest() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

	@Test(dataProvider = "getData")
	public void UserCanloginuccessfully(HashMap<String, String> input) throws IOException {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(input.get("email"), input.get("password"));

		System.out.println(loginobject.customerinfo.getText());
		Assert.assertEquals(loginobject.customerinfo.getText(), input.get("email"));
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\data\\Logindata.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}
}
