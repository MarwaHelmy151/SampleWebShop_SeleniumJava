package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.WishlistPage;

public class Testcase6_WishlistTest extends TestBase {

	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String productcategory = "Jewelry";
	String desireditem = "Black & White Diamond Heart";

	HomePage homeobject;
	LoginPage loginobject;
	WishlistPage wishlistobject;

	@Test(priority = 1, groups = { "Regression" })
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2, groups = { "Regression" })
	public void selectItem() {
		homeobject = new HomePage(driver);
		homeobject.selectfromtopMenu(productcategory);
		wishlistobject = new WishlistPage(driver);
		wishlistobject.selectItemJewelry(desireditem);
		wishlistobject.addToWishlist();
		System.out.println(wishlistobject.result.getText());
		Assert.assertEquals(wishlistobject.result.getText(), ("The product has been added to your wishlist"));
	}
}
