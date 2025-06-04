package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.Flib;
import pomPackage.CartPage;
import pomPackage.LaptopPage;
import pomPackage.WelcomePage;
@Listeners(genericPackage.CustomListener.class)
public class TC_RemoveProductFromCart_005_Test extends BaseTest {
  
  @Test
	public void removeProductTestCase() throws EncryptedDocumentException, IOException 
  {
	  Flib flib = new Flib();
		String laptop = flib.readExcelData(EXCEL_TEST_PATH, "products", 1, 0);

		WelcomePage wp = new WelcomePage(driver);
		// To Search for Laptop(product)
		wp.getSearchTextBox().sendKeys(laptop, Keys.ENTER);

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
		Assert.assertEquals(cp.getLaptopCartProduct().isDisplayed(), true, "Product is not added to cart");
		
		cp.getRemoveProductButton().click();
		Assert.assertEquals(cp.getLaptopCartProduct().isDisplayed(), false, "Product is not removed from cart");
		

  }
}
