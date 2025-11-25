package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase {

	public WishlistPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = "h2 a[href='/black-white-diamond-heart']")
	WebElement BlackWhiteDiamond;

	@FindBy(tagName = "h2")
	List<WebElement> itemsJewelry;

	@FindBy(id = "add-to-wishlist-button-14")
	WebElement WishlistBtn;

	@FindBy(css = ".content")
	public WebElement result;

	@FindBy(css = ".product a")
	WebElement wishListdisplay;

	public void selectItemJewelry(String desireditem) {
		for (WebElement itemJewely : itemsJewelry) {
			String text = itemJewely.getText().trim();
			if (text.equalsIgnoreCase(desireditem)) {
				itemJewely.click();
				break;
			}
		}
	}

	public void addToWishlist() {
		WishlistBtn.click();
	}
}
