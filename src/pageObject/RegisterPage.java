package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {

	public RegisterPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "gender-female")
	WebElement femaleRadioBtn;

	@FindBy(id = "FirstName")
	WebElement firstName;

	@FindBy(id = "LastName")
	WebElement lastName;

	@FindBy(id = "Email")
	WebElement Email;

	@FindBy(id = "Password")
	WebElement passwordfield;

	@FindBy(id = "ConfirmPassword")
	WebElement confirmpassword;

	@FindBy(id = "register-button")
	WebElement registerBtn;

	@FindBy(css = ".result")
	public WebElement message;

	public void usercanRegister(String firstname, String lastname, String email, String password) {
		femaleRadioBtn.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		Email.sendKeys(email);
		passwordfield.sendKeys(password);
		confirmpassword.sendKeys(password);
		registerBtn.click();
	}
}
