package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends PageBase {

	public SearchProductPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "small-searchterms")
	WebElement searchtxt;

	@FindBy(css = ".search-box-button")
	WebElement searchBtn;

	@FindBy(css = ".ui-menu-item")
	List<WebElement> products;

	@FindBy(css = ".add-to-cart-button")
	WebElement addTocartBtn;

	@FindBy(tagName = "h1")
	public WebElement ProductName;

	@FindBy(css = "p[class='content']")
	public List<WebElement> validationMessages;

	public void enterProduct(String value) throws InterruptedException {
		searchtxt.sendKeys(value);
		Thread.sleep(3000);
	}

	@FindBy(id = "giftcard_2_RecipientName")
	WebElement recipientName;

	@FindBy(id = "giftcard_2_RecipientEmail")
	WebElement recipientMail;

	@FindBy(id = "giftcard_2_SenderName")
	WebElement senderName;

	@FindBy(id = "giftcard_2_SenderEmail")
	WebElement sendermail;

	@FindBy(css = "p[class='content']")
	public WebElement successMessages;

	public void searchforProduct(String desiredItem) {
		for (int i = 0; i < products.size(); i++) {
			String options = products.get(i).getText();
			if (desiredItem.contains(options)) {
				products.get(i).click();
				break;
			}
		}
	}

	public void addTocart() {
		addTocartBtn.click();
		for (WebElement message : validationMessages) {
			System.out.println(message.getText());
		}
	}

	public void addReview(String recpName, String recpmail) {
		recipientName.sendKeys(recpName);
		recipientMail.sendKeys(recpmail);
		addTocartBtn.click();
	}
}
