package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.CustomerInfoPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class Testcase12_MyAccount extends TestBase {

	HomePage homeobject;
	LoginPage loginobject;
	CustomerInfoPage customerinfobject;

	@Test(dataProvider = "getData")
	public void UserCanloginuccessfully(HashMap<String, String> input) {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(input.get("email"), input.get("password"));

		Assert.assertEquals(loginobject.customerinfo.getText(), input.get("email"));
	}

	@Test(priority = 2)
	public void userCheckListsInMyAccount() {
		loginobject.openCustomerInfoPage();
		customerinfobject = new CustomerInfoPage(driver);
		customerinfobject.selecLists();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\data\\Logindata.json");

		return new Object[][] { { data.get(0) } };
	}
}
