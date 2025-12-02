package stepDefinitionRahul;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.CustomerInfoPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import tests.TestBase;

public class ChangePasswordTest extends TestBase {

	HomePage homeobject;
	LoginPage loginobject;
	CustomerInfoPage customerinfobject;

	@And("^User can navigate to customer info page and change password (.+) and (.+)$")
	public void User_can_navigate_to_customer_info_page_and_change_password(String oldpassword, String newpassword) {
		loginobject = new LoginPage(driver);
		loginobject.openCustomerInfoPage();
		customerinfobject = new CustomerInfoPage(driver);
		customerinfobject.changePassword(oldpassword, newpassword);
	}

	@Then("{string} message appears")
	public void message_appears_successfully(String string) {
		Assert.assertTrue(customerinfobject.message.getText().contains(string));
	}

	@And("^User can log in with (.+) and (.+)$")
	public void User_can_login_with_email_and_newpassword(String email, String newpassword) {
		homeobject = new HomePage(driver);
		homeobject.logout();
		homeobject.openLoginPage();
		loginobject.usercanLogin(email, newpassword);
		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}
}
