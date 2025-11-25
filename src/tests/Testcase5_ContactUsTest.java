package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.ContactUsPage;
import pageObject.HomePage;

public class Testcase5_ContactUsTest extends TestBase {
	ContactUsPage contactusobject;
	HomePage homeobject;
	String fullname = "Maria Test";
	String email = "MariaTest3@gmail.com";
	String enquiry = "This is for test";

	@Test
	public void User_can_contactUs() {
		homeobject = new HomePage(driver);
		homeobject.opencontactUsPage();
		contactusobject = new ContactUsPage(driver);
		contactusobject.contactUs(fullname, email, enquiry);
		System.out.println(contactusobject.message.getText());
		Assert.assertTrue(contactusobject.message.getText()
				.equals("Your enquiry has been successfully sent to the store owner."));
	}

}
