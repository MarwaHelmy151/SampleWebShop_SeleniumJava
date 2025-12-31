package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DashboradPage extends PageBase {

	public DashboradPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = ".product-title a")
	List<WebElement> productTitles;

	@FindBy(css = "ul[class='top-menu'] a[href='/electronics']")
	WebElement computersMenu;

//	@FindBy(css = "a[href='/cell-phones']")
//	WebElement cellPhones;

	@FindBy(xpath = "//ul[@class='top-menu']//a[@href='/electronics']/following-sibling::ul/li")
	List<WebElement> products;

	@FindBy(css = ".add-to-cart-button")
	WebElement addtocardBtn;

	@FindBy(css = ".add-to-cart-button")
	List<WebElement> addtocardButton;

	@FindBy(name = "continueshopping")
	WebElement continueshoppingBtn;

	@FindBy(css = ".content")
	public WebElement message;

	public void hoverelement() {
		Actions a = new Actions(driver);
		a.moveToElement(computersMenu).build().perform();
	}

	/*
	 * public void selectProduct(String productName) { for (WebElement product :
	 * products) if (product.getText().equals(productName)) { product.click(); } }
	 */

	// generic
	public void selectProduct(String productName) {

		for (WebElement productTitle : productTitles)
			if (productTitle.getText().equals(productName)) {
				productTitle.click();
				break;
			}
	}

	// select many products
	public void addProducts() throws InterruptedException {
		for (int i = 0; i < productTitles.size(); i++) {
			productTitles.get(i).click();
			Thread.sleep(3000);
			if (!addtocardButton.isEmpty() && addtocardButton.get(0).isDisplayed()) {
				addtocardButton.get(0).click();
			}
			driver.navigate().back();
		}
	}

	public void addtocard() {
		addtocardBtn.click();
	}

	public void continueshopping() {
		continueshoppingBtn.click();
	}
}
