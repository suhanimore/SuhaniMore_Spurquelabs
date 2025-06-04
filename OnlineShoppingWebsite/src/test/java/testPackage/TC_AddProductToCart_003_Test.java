package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericPackage.BaseTest;
import genericPackage.Flib;
import pomPackage.CartPage;
import pomPackage.LaptopPage;
import pomPackage.WelcomePage;
@Listeners(genericPackage.CustomListener.class)
public class TC_AddProductToCart_003_Test extends BaseTest {
	@Test
	public void addToCartTestCase() throws EncryptedDocumentException, IOException, InterruptedException {
		Flib flib = new Flib();
		String laptop = flib.readExcelData(EXCEL_TEST_PATH, "products", 1, 0);

		WelcomePage wp = new WelcomePage(driver);
		// To Search for Laptop(product)
		wp.getSearchTextBox().sendKeys(laptop, Keys.ENTER);

//		String expectedTitleOfLaptopsPage="Amazon.in : laptop";
//      Assert.assertEquals(driver.getTitle(), expectedTitleOfLaptopsPage, "Laptop Page Is Not Displayed!!");

		LaptopPage lp = new LaptopPage(driver);

		// To verify whether Laptop is displayed
		for (WebElement we : lp.getLaptopImages()) {
			if (we.isDisplayed()) {
				Reporter.log("Laptops are Displayed", true);
				break;
			}
		}

		// To add 4th product to the cart
		lp.getAddToCartButton4().click();
		
		wp.getCartLink().click();
		
		CartPage cp = new CartPage(driver);
		String priceOfOneProduct = cp.getPriceOfOneProduct().getText();
		String quantityOfLaptops = cp.getQuantity().getText();
		String subTotalOfOneProduct = cp.getSubTotalPrice().getText();
		
		Reporter.log("No. of laptops added to cart :"+quantityOfLaptops+" "+"Price of the laptop added to cart :"+subTotalOfOneProduct, true);
        
		
	}
}
