package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Checkoutpage extends PageBase {

	public Checkoutpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countryList;

	@FindBy(id = "BillingNewAddress_City")
	WebElement cityfield;

	@FindBy(id = "BillingNewAddress_Address1")
	WebElement addressfield;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipcode;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phonenumberfield;

	@FindBy(id = "billing-buttons-container")
	WebElement billingcontinueBtn;

	@FindBy(className = "new-address-next-step-button")
	WebElement shippingcontinueBtn;

	@FindBy(className = "shipping-method-next-step-button")
	WebElement shippingmethodcontinueBtn;

	@FindBy(className = "payment-method-next-step-button")
	WebElement paymentcontinueBtn;

	@FindBy(className = "payment-info-next-step-button")
	WebElement paymentinfocontinueBtn;

	@FindBy(className = "confirm-order-next-step-button")
	WebElement confirmBtn;

	@FindBy(css = "ul[class='details'] a")
	WebElement clickhereOrder;

	@FindBy(css = ".pdf-order-button")
	WebElement pdfBtn;

	@FindBy(tagName = "strong")
	public WebElement successfullmsg;

	public void billingaddress(String country, String city, String address, String zip, String phone) {
		Select dropdown = new Select(countryList);
		dropdown.selectByVisibleText(country);
		cityfield.sendKeys(city);
		addressfield.sendKeys(address);
		zipcode.sendKeys(zip);
		phonenumberfield.sendKeys(phone);
		billingcontinueBtn.click();

		waitForWebElement(shippingcontinueBtn);
		shippingcontinueBtn.click();

		waitForWebElement(shippingmethodcontinueBtn);
		shippingmethodcontinueBtn.click();
		paymentcontinueBtn.click();
		paymentinfocontinueBtn.click();
		confirmBtn.click();
	}

	public void navigateToinvoice() throws InterruptedException {
		clickhereOrder.click();
		Thread.sleep(3000);
		pdfBtn.click();
	}

}
