package stepDefinitionRahul;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.WishlistPage;
import tests.TestBase;

public class WishlistTest extends TestBase {
	WishlistPage wishlistobject;

	@And("^User can select desired product (.+) and add it to wishlist$")
	public void User_can_select_desired_product_and_add_it_to_wishlist(String desireditem) {
		wishlistobject = new WishlistPage(driver);
		wishlistobject.selectItemJewelry(desireditem);
		wishlistobject.addToWishlist();
	}

	@Then("{string} product is successfully added")
	public void product_is_successfully_added(String string) {
		System.out.println(wishlistobject.result.getText());
		Assert.assertEquals(wishlistobject.result.getText(), string);
	}
}
