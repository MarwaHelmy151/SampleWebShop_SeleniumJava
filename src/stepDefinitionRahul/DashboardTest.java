package stepDefinitionRahul;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.Checkoutpage;
import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingcartPage;
import tests.TestBase;

public class DashboardTest extends TestBase {

	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;
	ShoppingcartPage shoppingcartobject;
	Checkoutpage checkoutobject;

	@And("^User can select product (.+)$")
	public void User_can_select_product(String productcategory) throws InterruptedException, IOException {

		dashboardobject = new DashboradPage(driver);
		dashboardobject.hoverelement();
		dashboardobject.selectProduct(productcategory);
		dashboardobject.addtocard();
		Thread.sleep(3000);
		Assert.assertEquals(dashboardobject.message.getText(), "The product has been added to your shopping cart");
	}

	@And("^User can add desired product (.+) to cart$")
	public void User_can_add_product_to_cart(String desiredproduct) throws InterruptedException {
		homeobject = new HomePage(driver);
		homeobject.shoppingcartPage();
		shoppingcartobject = new ShoppingcartPage(driver);
		Thread.sleep(3000);
		System.out.println(shoppingcartobject.productscart.getText());
		Assert.assertTrue(shoppingcartobject.productscart.getText().contains(desiredproduct));
		shoppingcartobject.navigatetocheckoutPage();
	}

	@And("User can checkout")
	public void User_can_checkout() throws InterruptedException {
		checkoutobject = new Checkoutpage(driver);
		Thread.sleep(3000);
		checkoutobject.billingaddress("Egypt", "Cairo", "New Cairo", "12345", "12345");
		Thread.sleep(3000);
	}

	@Then("{string} order is processed")
	public void Order_is_successfully_processed(String string) {
		System.out.println(checkoutobject.successfullmsg.getText());
		Assert.assertTrue(checkoutobject.successfullmsg.getText().equals(string));
	}
}
