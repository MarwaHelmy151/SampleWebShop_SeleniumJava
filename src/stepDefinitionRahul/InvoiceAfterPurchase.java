package stepDefinitionRahul;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObject.Checkoutpage;
import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingcartPage;
import tests.TestBase;

public class InvoiceAfterPurchase extends TestBase {

	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;
	ShoppingcartPage shoppingcartobject;
	Checkoutpage checkoutobject;

	@And("^User can select another category (.+) and add item (.+)$")
	public void user_can_select_another_product(String productcategory2, String desiredproduct2)
			throws InterruptedException {
		homeobject = new HomePage(driver);
		homeobject.selectfromtopMenu(productcategory2);
		dashboardobject = new DashboradPage(driver);
		dashboardobject.selectProduct(desiredproduct2);
		dashboardobject.addtocard();
		shoppingcartobject = new ShoppingcartPage(driver);
		System.out.println(shoppingcartobject.productscart.getText());
		Assert.assertEquals(dashboardobject.message.getText(), "The product has been added to your shopping cart");
		homeobject.shoppingcartPage();

		shoppingcartobject.navigatetocheckoutPage();
		checkoutobject = new Checkoutpage(driver);
		Thread.sleep(3000);
		checkoutobject.billingaddress("Egypt", "Cairo", "New Cairo", "12345", "12345");
		Thread.sleep(3000);
		System.out.println(checkoutobject.successfullmsg.getText());
		Assert.assertTrue(
				checkoutobject.successfullmsg.getText().equals("Your order has been successfully processed!"));
		checkoutobject.navigateToinvoice();
	}

	@Then("User can download invoice after purchase")
	public void user_can_download_invoice_after_purchase() {
		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("plugins.always_open_pdf_externally", true);
		prefs.put("download.default_directory", "C:\\Downloads");
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.directory_upgrade", true);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);

		String downloadDir = "C:\\Users\\mahelmy\\Downloads";
		String filePrefix = "order_";
		File latestPDF = getLatestDownloadedPDF(downloadDir, filePrefix);
		if (latestPDF != null) {
			System.out.println("PDF is downloaded successfully, Latest downloaded PDF: " + latestPDF.getName());
		} else {
			System.out.println("No PDF found with prefix: " + filePrefix);
		}
	}
}
