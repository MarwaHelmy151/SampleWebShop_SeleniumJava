package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingcartPage extends PageBase {

	public ShoppingcartPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".product-name")
	public WebElement productscart;

	@FindBy(id = "termsofservice")
	WebElement terms;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	public void navigatetocheckoutPage() {
		terms.click();
		checkoutBtn.click();
	}
}
