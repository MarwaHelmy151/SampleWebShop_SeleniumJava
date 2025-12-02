package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "ul[class='top-menu'] li a")
	List<WebElement> topMenuCategories;

	@FindBy(css = "ul[class='top-menu'] ul li")
	List<WebElement> itemsList;

	@FindBy(linkText = "Register")
	WebElement registerLink;

	@FindBy(className = "ico-login")
	WebElement loginLink;

	@FindBy(className = "ico-logout")
	WebElement logoutLink;

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

	// generic -- click on top menu
	public void selectfromtopMenu(String productcategory) {
		for (WebElement topMenucategory : topMenuCategories) {
			String text = topMenucategory.getText().trim();
			if (text.equalsIgnoreCase(productcategory)) {
				topMenucategory.click();
				break;
			}
		}
	}

	// generic -- hover to top menu to open List
	public void hovergenericElement(String productcategory) {
		Actions a = new Actions(driver);
		for (WebElement topMenucategory : topMenuCategories) {
			String text = topMenucategory.getText().trim();
			if (text.equalsIgnoreCase(productcategory)) {
				a.moveToElement(topMenucategory).build().perform();
				break;
			}
		}
	}

	// generic -- select from list
	public void selectItemfromList(String prodouctname) {
		for (WebElement item : itemsList) {
			String text = item.getText().trim();
			if (text.equalsIgnoreCase(prodouctname)) {
				item.click();
				break;
			}
		}
	}

	public void opencontactUsPage() {
		contactusLink.click();
	}

	public void logout() {
		logoutLink.click();
	}
}
