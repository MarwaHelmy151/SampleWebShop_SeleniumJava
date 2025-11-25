package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.SendEmailPage;

public class Testcase4_SendEmailTest extends TestBase {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String productcategory = "Apparel & Shoes";
	String productName = "Blue Jeans";
	String friendsmail = "Test10@gmail.com";
	HomePage homeobject;
	LoginPage loginobject;
	SendEmailPage sendemailobject;

	@Test(priority = 1, groups = { "Regression" })
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2, groups = { "Regression" })
	public void UserCanSendEmailSuccessfully() throws InterruptedException {
		homeobject.selectfromtopMenu(productcategory);
		sendemailobject = new SendEmailPage(driver);
		// sendemailobject.selectApparelAndShoesMenu();
		sendemailobject.selectProduct(productName);
		sendemailobject.sendEmailToFriend(friendsmail);
		System.out.println(sendemailobject.message.getText());
		Assert.assertTrue(sendemailobject.message.getText().contains("Your message has been sent."));
	}
}
