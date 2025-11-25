package stepDefintion_Archive;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.LoginPage;
import tests.TestBaseCucumberArchive;

public class stepDefinition_userLogin extends TestBaseCucumberArchive {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	HomePage homeobject;
	LoginPage loginobject;

	@Given("User open login page")
	public void User_open_login_page() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();
	}

	@When("User enter valid email and password")
	public void User_enter_valid_email_and_password() {
		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);
	}

	@Then("User can login successfully")
	public void user_can_login_successfully() {
		Assert.assertEquals(loginobject.customerinfo.getText(), email);

	}
}
