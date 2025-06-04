package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	//Declaration
	@FindBy(xpath = "//img[@class='sc-product-image']")private WebElement laptopCartProduct;
	@FindBy(xpath = "//div[contains(@class,'sc-badge-price-')]")private WebElement priceOfOneProduct;
	@FindBy(xpath="//div[@data-a-selector='spinbutton']")private WebElement quantity;
	@FindBy(xpath = "//button[@aria-label='Increase quantity by one']")private WebElement increaseQuantityByOne;
	@FindBy(xpath = "//span[@id='sc-subtotal-amount-activecart']")private WebElement subTotalPrice;
    @FindBy(xpath = "//span[@data-a-selector='decrement-icon']") private WebElement removeProductButton;
	
	

	//Initialization
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	
	// Utilization
	public WebElement getPriceOfOneProduct() {
		return priceOfOneProduct;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getIncreaseQuantityByOne() {
		return increaseQuantityByOne;
	}

	public WebElement getSubTotalPrice() {
		return subTotalPrice;
	}
	
	public WebElement getRemoveProductButton() {
		return removeProductButton;
	}


	public WebElement getLaptopCartProduct() {
		return laptopCartProduct;
	}

}
