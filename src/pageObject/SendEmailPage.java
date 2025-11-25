package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendEmailPage extends PageBase {

	public SendEmailPage(WebDriver driver) {
		super(driver);
	}

//	@FindBy(css = "ul[class='top-menu'] a[href='/apparel-shoes']")
//	WebElement ApparelAndShoes;

	@FindBy(css = ".product-title a")
	List<WebElement> productTitles;

	@FindBy(className = "email-a-friend-button")
	WebElement emailFriendBtn;

	@FindBy(css = "#FriendEmail")
	WebElement friendEmailTxt;

	@FindBy(css = "form div input[type='submit']")
	WebElement sendEmailBtn;

	@FindBy(css = ".result")
	public WebElement message;

//	public void selectApparelAndShoesMenu() {
//		ApparelAndShoes.click();
//	}

	public void selectProduct(String productName) {

		for (WebElement productTitle : productTitles)
			if (productTitle.getText().equals(productName)) {
				productTitle.click();
				break;
			}
	}

	public void sendEmailToFriend(String friendsmail) {
		emailFriendBtn.click();
		friendEmailTxt.sendKeys(friendsmail);
		sendEmailBtn.click();
	}
}
