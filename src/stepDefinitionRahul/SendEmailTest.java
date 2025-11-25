package stepDefinitionRahul;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.HomePage;
import pageObject.SendEmailPage;
import tests.TestBase;

public class SendEmailTest extends TestBase {
	HomePage homeobject;
	SendEmailPage sendemailobject;

	String friendsmail = "Test10@gmail.com";

	@And("^User can select productcategory (.+) from topmenu$")
	public void user_can_select_productcategory_from_topmenu(String productcategory) {
		homeobject = new HomePage(driver);
		homeobject.selectfromtopMenu(productcategory);
	}

	@And("^User can select desired product (.+) and send Email to friend$")
	public void user_can_select_desiredProduct_and_send_email(String desiredproduct) {
		sendemailobject = new SendEmailPage(driver);
		sendemailobject.selectProduct(desiredproduct);
		sendemailobject.sendEmailToFriend(friendsmail);
	}

	@Then("{string} mail is successfully sent")
	public void mail_is_successfully_sent(String string) {
		System.out.println(sendemailobject.message.getText());
		Assert.assertTrue(sendemailobject.message.getText().contains(string));
	}

}
