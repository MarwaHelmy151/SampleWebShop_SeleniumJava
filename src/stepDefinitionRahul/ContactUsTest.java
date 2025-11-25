package stepDefinitionRahul;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ContactUsPage;
import pageObject.HomePage;
import tests.TestBase;

public class ContactUsTest extends TestBase {
	ContactUsPage contactusobject;
	HomePage homeobject;

	@When("^User can send enquiry in contact us page (.+) and (.+) and (.+)$")
	public void user_can_send_enquiry(String fullname, String email, String enquiry) {
		homeobject = new HomePage(driver);
		homeobject.opencontactUsPage();
		contactusobject = new ContactUsPage(driver);
		contactusobject.contactUs(fullname, email, enquiry);
	}

	@Then("{string} enquiry is successfully sent")
	public void enquiry_is_successfully_sent(String string) {
		System.out.println(contactusobject.message.getText());
		Assert.assertTrue(contactusobject.message.getText().equals(string));
	}
}
