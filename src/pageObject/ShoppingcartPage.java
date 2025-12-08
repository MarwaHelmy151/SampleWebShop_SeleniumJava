package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingcartPage extends PageBase {

	public ShoppingcartPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(css = ".product-name")
	public WebElement productscart;

	@FindBy(css = ".product a")
	List<WebElement> products;

	@FindBy(id = "termsofservice")
	WebElement terms;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	// @FindBy(css =
	// "//a[contains(@class,'product-name')]/ancestor::td[1]/preceding-sibling::td[@class='remove-from-cart']/input")
	@FindBy(name = "removefromcart")
	WebElement removeBtn;

	@FindBy(name = "updatecart")
	WebElement updateShoppingCartBtn;

	public void navigatetocheckoutPage() {
		terms.click();
		checkoutBtn.click();
	}

	public void removefromShoppingCart(String item) {
		for (int i = 0; i < products.size(); i++) {
			String options = products.get(i).getText();
			if (item.equalsIgnoreCase(options)) {
				products.get(i)
						.findElement(By.xpath("ancestor::td[1]/preceding-sibling::td[@class='remove-from-cart']/input"))
						.click();
				updateShoppingCartBtn.click();
				break;
			}
		}
	}
}
