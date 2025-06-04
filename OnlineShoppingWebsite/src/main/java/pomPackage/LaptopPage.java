package pomPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage {

	//Declaration
	
	@FindBy(xpath = "(//button[text()='Add to cart'])[4]") private WebElement addToCartButton4;
	@FindBy(xpath = "//img[@class='s-image']") private List<WebElement> laptopImages;
	
	//Initialization
	public LaptopPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	// Utilization
	public WebElement getAddToCartButton4() {
		return addToCartButton4;
	}


	public List<WebElement> getLaptopImages() {
		return laptopImages;
	}
	
	
}
