package stepDefinitionRahul;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.HomePage;
import pageObject.RegisterPage;
import tests.TestBase;

public class RegisterTest extends TestBase {

	HomePage homeobject;
	RegisterPage registerobject;

	@When("User open Register page")
	public void User_open_Register_page() {
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
	}

	@And("^User can resgister with firstname (.+)and lastname (.+) and email (.+) and password (.+)$")
	public void user_can_register_with_valid_data(String firstname, String lastname, String email, String password) {
		registerobject = new RegisterPage(driver);
		registerobject.usercanRegister(firstname, lastname, email, password);
	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String string) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(registerobject.message.getText().equalsIgnoreCase(string));
		driver.quit();
	}

}
