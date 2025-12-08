package tests;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Checkoutpage;
import pageObject.DashboradPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ShoppingcartPage;

public class Testcase9_InvoiceAfterPurchase extends TestBase {
	String email = "MariaTest20@gmail.com";
	String password = "12345678";
	String productcategory = "Computers";
	String item = "Notebooks";
	String desiredproduct = "14.1-inch Laptop";

	String productcategory2 = "Apparel & Shoes";
	String desiredproduct2 = "Casual Golf Belt";

	HomePage homeobject;
	LoginPage loginobject;
	DashboradPage dashboardobject;
	ShoppingcartPage shoppingcartobject;
	Checkoutpage checkoutobject;

	@Test(priority = 1, groups = { "Regression" })
	public void UserCanLoginSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();

		loginobject = new LoginPage(driver);
		loginobject.usercanLogin(email, password);

		Assert.assertEquals(loginobject.customerinfo.getText(), email);
	}

	@Test(priority = 2, groups = { "Regression" })
	public void AddProductTocard() throws InterruptedException {
		// add first item
		homeobject.hovergenericElement(productcategory);
		homeobject.selectItemfromList(item);
		dashboardobject = new DashboradPage(driver);
		dashboardobject.selectProduct(desiredproduct);
		dashboardobject.addtocard();
		Thread.sleep(3000);
		Assert.assertEquals(dashboardobject.message.getText(), "The product has been added to your shopping cart");
	}

	@Test(priority = 3, groups = { "Regression" })
	public void verifyItemisaddedtoProductscart() throws InterruptedException {
		homeobject.shoppingcartPage();
		shoppingcartobject = new ShoppingcartPage(driver);
		Thread.sleep(3000);
		System.out.println(shoppingcartobject.productscart.getText());
		Assert.assertTrue(shoppingcartobject.productscart.getText().contains(desiredproduct));
	}

	@Test(priority = 4, groups = { "Regression" })
	public void selectotherItem() throws InterruptedException {
		// add second item
		homeobject.selectfromtopMenu(productcategory2);
		dashboardobject.selectProduct(desiredproduct2);
		dashboardobject.addtocard();
		Thread.sleep(3000);
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

	// verify that PDF is downloaded
	@Test(priority = 5, groups = { "Regression" })
	public void verifyPDFisDowloadedSuccessfully() {
		// to turn .tmp to .pdf format after downloading file
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
