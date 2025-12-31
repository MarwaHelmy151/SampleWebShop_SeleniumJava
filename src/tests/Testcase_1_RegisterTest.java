package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegisterPage;

public class Testcase_1_RegisterTest extends TestBase {

	String firstname = "Maria";
	String lastname = "Test";
	String email = "MariaTest88@gmail.com";
	String password = "123456";

	HomePage homeobject;
	RegisterPage registerobject;

	@Test
	public void UserCanRegisterSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();

		registerobject = new RegisterPage(driver);
		registerobject.usercanRegister(firstname, lastname, email, password);

		Assert.assertEquals(registerobject.message.getText(), "Your registration completed");

	}
}
