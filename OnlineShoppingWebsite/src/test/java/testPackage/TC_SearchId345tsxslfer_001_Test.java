package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.Flib;
import pomPackage.WelcomePage;
@Listeners(genericPackage.CustomListener.class)
public class TC_SearchId345tsxslfer_001_Test extends BaseTest {
  @Test
  public void searchId345tsxslferTestCase() throws EncryptedDocumentException, IOException 
  {
	  Flib flib = new Flib();
		String invalidData = flib.readExcelData(EXCEL_TEST_PATH, "invaliddata", 1,0);
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getSearchTextBox().sendKeys(invalidData,Keys.ENTER);
		
		String expectedResult="No results for "+invalidData+".";
		
		String actualResult = wp.getErrorMessage().getText();
		Assert.assertEquals(actualResult, expectedResult,"Error message is notdisplayed");
        
  }
}
