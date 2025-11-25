package stepDefintion_Archive;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.Checkoutpage;
import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingcartPage;
import tests.TestBaseCucumberArchive;

public class stepDefinition_userDashboard extends TestBaseCucumberArchive {
	String email = "MariaTest3@gmail.com";
	String password = "123456";
	String productcategory = "Cell phones";
	String desiredproduct = "Smartphone";
	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;
	ShoppingcartPage shoppingcartobject;
	Checkoutpage checkoutobject;

	@And("User can add product to cart")
	public void User_can_add_product_to_cart() throws InterruptedException {
		dashboardobject = new DashboradPage(driver);
		dashboardobject.hoverelement();
		dashboardobject.selectProduct(productcategory);
		dashboardobject.addtocard();
		Thread.sleep(3000);
		Assert.assertEquals(dashboardobject.message.getText(), "The product has been added to your shopping cart");
	}

	@And("User can checkout")
	public void User_can_checkout() throws InterruptedException {
		homeobject = new HomePage(driver);
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
	}

	@Then("Order is successfully processed")
	public void Order_is_successfully_processed() {
		System.out.println(checkoutobject.successfullmsg.getText());
		Assert.assertTrue(
				checkoutobject.successfullmsg.getText().equals("Your order has been successfully processed!"));
	}
}
