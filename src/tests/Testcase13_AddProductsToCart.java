package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingcartPage;

public class Testcase13_AddProductsToCart extends TestBase {

	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;
	ShoppingcartPage shoppingcartobject;

	@Test(dataProvider = "getData")
	public void UserCanloginuccessfully(HashMap<String, String> input) {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(input.get("email"), input.get("password"));

		Assert.assertEquals(loginobject.customerinfo.getText(), input.get("email"));
	}

	@Test(dataProvider = "getData")
	public void userCanselectProductsToCart(HashMap<String, String> input) throws InterruptedException {
		homeobject.selectfromtopMenu(input.get("topMenucategory"));
		dashboardobject = new DashboradPage(driver);
		dashboardobject.addProducts();
		homeobject.shoppingcartPage();
		shoppingcartobject = new ShoppingcartPage(driver);
		// check if the all products are added to cart
		int actualCount = shoppingcartobject.productsCart.size();
		System.out.println(actualCount);
		Assert.assertEquals(actualCount, 4);

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\data\\Logindata.json");

		return new Object[][] { { data.get(0) } };
	}
}
