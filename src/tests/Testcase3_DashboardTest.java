package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Checkoutpage;
import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingcartPage;

public class Testcase3_DashboardTest extends TestBase {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String productcategory = "Cell phones";
	String desiredproduct = "Smartphone";
	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;
	ShoppingcartPage shoppingcartobject;
	Checkoutpage checkoutobject;

	@Test(priority = 1, groups = { "Regression" })
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2, groups = { "Regression" })
	public void AddProductTocard() throws InterruptedException {
		dashboardobject = new DashboradPage(driver);
		dashboardobject.hoverelement();
		dashboardobject.selectProduct(productcategory);
		dashboardobject.addtocard();
		Thread.sleep(3000);

		Assert.assertEquals(dashboardobject.message.getText(), "The product has been added to your shopping cart");

	}

	@Test(priority = 3, groups = { "Regression" })
	public void shoppingCartPage() throws InterruptedException {
		homeobject.shoppingcartPage();
		shoppingcartobject = new ShoppingcartPage(driver);
		Thread.sleep(3000);
		System.out.println(shoppingcartobject.productscart.getText());

		Assert.assertTrue(shoppingcartobject.productscart.getText().contains(desiredproduct));
		shoppingcartobject.navigatetocheckoutPage();
		checkoutobject = new Checkoutpage(driver);
		Thread.sleep(3000);
		checkoutobject.billingaddress("Egypt", "Cairo", "New Cairo", "12345", "12345");
		Thread.sleep(3000);
		System.out.println(checkoutobject.successfullmsg.getText());
		Assert.assertTrue(
				checkoutobject.successfullmsg.getText().equals("Your order has been successfully processed!"));

	}

}