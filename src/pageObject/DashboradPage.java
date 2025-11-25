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

	@FindBy(css = "ul[class='top-menu'] a[href='/electronics']")
	WebElement computersMenu;

//	@FindBy(css = "a[href='/cell-phones']")
//	WebElement cellPhones;

	@FindBy(xpath = "//ul[@class='top-menu']//a[@href='/electronics']/following-sibling::ul/li")
	List<WebElement> products;

	@FindBy(css = "[value='Add to cart']")
	WebElement addtocardBtn;

	@FindBy(css = ".content")
	public WebElement message;

	public void hoverelement() {
		Actions a = new Actions(driver);
		a.moveToElement(computersMenu).build().perform();
	}

	public void selectProduct(String productName) {
		for (WebElement product : products)
			if (product.getText().equals(productName)) {
				product.click();
			}
	}

	public void addtocard() {
		addtocardBtn.click();
	}

}
