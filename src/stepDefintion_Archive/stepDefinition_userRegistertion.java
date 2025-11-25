package stepDefintion_Archive;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.RegisterPage;
import tests.TestBaseCucumberArchive;

public class stepDefinition_userRegistertion extends TestBaseCucumberArchive {

	String firstname = "Maria";
	String lastname = "Test";
	String email = "MariaTest81@gmail.com";
	String password = "123456";
	HomePage homeobject;
	RegisterPage registerobject;

	@Given("User open Register page")
	public void User_open_Register_page() {
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
	}

	@When("User can resgister successfully")
	public void User_can_resgister_successfully() {
		registerobject = new RegisterPage(driver);
		registerobject.usercanRegister(firstname, lastname, email, password);
	}

	@Then("message is displayed")
	public void message_is_displayed() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(registerobject.message.getText(), "Your registration completed");
	}
}
