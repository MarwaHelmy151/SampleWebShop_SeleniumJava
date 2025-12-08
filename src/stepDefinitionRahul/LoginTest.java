package stepDefinitionRahul;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.LoginPage;
import tests.TestBase;

public class LoginTest extends TestBase {

	public HomePage homeobject;
	public LoginPage loginobject;

	@When("User open login page")
	public void User_open_login_page() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();
	}

	@And("^User enter valid email (.+) and password (.+)$")
	public void User_enter_valid_email_and_password(String email, String password) {
		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);
	}

	@And("^user enters incorrect email (.+) and password (.+)$")
	public void User_enter_invalid_password(String email, String password) {
		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);
	}

	@And("user leaves the username and password fields empty")
	public void User_leaves_fields_empty() {
		loginobject = new LoginPage(driver);
		loginobject.loginBtn.click();
	}

	@Then("^User can login successfully and customerinfo (.+) is found$")
	public void user_can_login_successfully(String email) {
		Assert.assertTrue(loginobject.customerinfo.getText().equalsIgnoreCase(email));
	}

	@Then("user should see an error message {string}")
	public void errorMessage_is_displayed(String string) {
		System.out.println(loginobject.errorMessage.getText());
		Assert.assertTrue(loginobject.errorMessage.getText().contains(string));
	}

	@Then("user should see a validation message {string}")
	public void errorMessage_appears(String string) {
		System.out.println(loginobject.errorMessage.getText());
		Assert.assertTrue(loginobject.errorMessage.getText().contains(string));
	}
}
