package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.CustomerInfoPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class Testcase8_CustomerInfo extends TestBase {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String newpassword = "12345678";
	HomePage homeobject;
	LoginPage loginobject;
	CustomerInfoPage customerinfobject;

	@Test(priority = 1)
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2)
	public void userCanchangepassword() {
		loginobject.openCustomerInfoPage();
		customerinfobject = new CustomerInfoPage(driver);
		customerinfobject.changePassword(password, newpassword);
		Assert.assertTrue(customerinfobject.message.getText().contains("Password was changed"));
		homeobject.logout();
		homeobject.openLoginPage();
		loginobject.usercanLogin(email, newpassword);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);

	}
}
