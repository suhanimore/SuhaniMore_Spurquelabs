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
import pomPackage.LaptopPage;
import pomPackage.WelcomePage;
@Listeners(genericPackage.CustomListener.class)
public class TC_SearchLaptop_002_Test extends BaseTest{
  
	@Test
  public void searchLaptopTestCase() throws EncryptedDocumentException, IOException 
  {
		Flib flib = new Flib();
		String laptop = flib.readExcelData(EXCEL_TEST_PATH, "products", 1,0);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getSearchTextBox().sendKeys(laptop,Keys.ENTER);
		
		LaptopPage lp = new LaptopPage(driver);
		
		for(WebElement we : lp.getLaptopImages())
		{
			if(we.isDisplayed())
			{
				Reporter.log("Laptops are Displayed",true);
				break;
			}
		}
		
		
  }
}
