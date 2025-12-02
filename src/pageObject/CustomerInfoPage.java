package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerInfoPage extends PageBase {

	public CustomerInfoPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a[href='/customer/changepassword']")
	WebElement changePasswordLink;

	@FindBy(id = "OldPassword")
	WebElement oldPasswordTxt;

	@FindBy(id = "NewPassword")
	WebElement newPasswordTxt;

	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPasswordTxt;

	@FindBy(css = ".change-password-button")
	WebElement changePasswordBtn;

	@FindBy(css = ".result")
	public WebElement message;

	public void changePassword(String oldPassword, String newPassword) {
		changePasswordLink.click();
		oldPasswordTxt.sendKeys(oldPassword);
		newPasswordTxt.sendKeys(newPassword);
		confirmNewPasswordTxt.sendKeys(newPassword);
		changePasswordBtn.click();

	}

}
