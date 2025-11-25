package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "ul[class='top-menu'] li a")
	List<WebElement> topMenuCategories;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(className = "ico-login")
	WebElement loginLink;

	@FindBy(linkText = "Shopping cart")
	WebElement shoppingcartLink;

	@FindBy(className = "ico-wishlist")
	WebElement wishlistLink;

	@FindBy(css = "div[class='footer-menu-wrapper'] a[href='/contactus']")
	WebElement contactusLink;

	public void openRegistrationPage() {
		registerLink.click();
	}

	public void openLoginPage() {
		loginLink.click();
	}

	public void shoppingcartPage() {
		shoppingcartLink.click();
	}

	public void wishlistPage() {
		wishlistLink.click();
	}

	public void selectfromtopMenu(String productcategory) {
		for (WebElement topMenucategory : topMenuCategories) {
			String text = topMenucategory.getText().trim();
			if (text.equalsIgnoreCase(productcategory)) {
				topMenucategory.click();
				break;
			}
		}
	}

	public void opencontactUsPage() {
		contactusLink.click();
	}
}
