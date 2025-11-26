package stepDefinitionRahul;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.SearchProductPage;
import tests.TestBase;

public class SearchProductTest extends TestBase {
	SearchProductPage searchproductobject;

	@And("^User can search for a product (.+) and enter (.+) and (.+)$")
	public void userCansearchforProduct(String desiredProduct, String recipientName, String recipientemail)
			throws InterruptedException {
		searchproductobject = new SearchProductPage(driver);
		searchproductobject.enterProduct("Card");
		searchproductobject.searchforProduct(desiredProduct);

		System.out.println(searchproductobject.ProductName.getText());
		Assert.assertTrue(searchproductobject.ProductName.getText().equals(desiredProduct));
		searchproductobject.addTocart();
		searchproductobject.addReview(recipientName, recipientemail);
		Thread.sleep(3000);

	}

	@Then("{string} successMessage product added to cart")
	public void successMessage_product_added_to_cart(String string) throws InterruptedException {

		System.out.println(searchproductobject.successMessages.getText());
		Assert.assertTrue(searchproductobject.successMessages.getText().equals(string));
	}
}
