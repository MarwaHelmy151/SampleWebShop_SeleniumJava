package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

	@FindBy(css = ".list li a")
	List<WebElement> lists;

	@FindBy(tagName = "h1")
	WebElement pageBlockName;

	@FindBy(css = ".result")
	public WebElement message;

	public void changePassword(String oldPassword, String newPassword) {
		changePasswordLink.click();
		oldPasswordTxt.sendKeys(oldPassword);
		newPasswordTxt.sendKeys(newPassword);
		confirmNewPasswordTxt.sendKeys(newPassword);
		changePasswordBtn.click();

	}

	public void selecLists() {
		for (int i = 0; i < lists.size(); i++) {
			lists.get(i).click();
			String blockname = pageBlockName.getText().split("-")[1].strip();
			System.out.println(blockname);
			Assert.assertTrue(lists.get(i).getText().equals(blockname));
		}
	}
}
