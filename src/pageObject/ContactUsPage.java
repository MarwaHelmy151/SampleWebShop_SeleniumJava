package pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(id = "FullName")
	WebElement fullName;

	@FindBy(id = "Email")
	WebElement emailtxt;

	@FindBy(id = "Enquiry")
	WebElement enquiryTxt;

	@FindBy(css = "form div input[type='submit']")
	WebElement submitBtn;

	@FindBy(css = ".result")
	public WebElement message;

	public void contactUs(String fullname, String email, String enquiry) {
		fullName.sendKeys(fullname);
		emailtxt.sendKeys(email);
		enquiryTxt.sendKeys(enquiry);
		submitBtn.click();
	}
}
