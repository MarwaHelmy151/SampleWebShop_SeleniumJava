package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement Email;

	@FindBy(id = "Password")
	WebElement passwordfield;

	@FindBy(css = ".login-button")
	WebElement loginBtn;

	@FindBy(css = "div[class='header-links'] a[href='/customer/info']")
	public WebElement customerinfo;

	public void usercanLogin(String email, String password) {
		Email.sendKeys(email);
		passwordfield.sendKeys(password);
		loginBtn.click();
	}
}
