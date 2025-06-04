package pomPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	
	//Declaration
	@FindBy(id = "twotabsearchtextbox") private WebElement searchTextBox;
	@FindBy(id = "nav-search-submit-button") private WebElement searchButtonIcon;
	@FindBy(id = "nav-cart") private WebElement cartLink;
	@FindBy(xpath = "//span[contains(@class,'a-color-base a-text-normal')]/..")private WebElement errorMessage;
	
	

	// Initialization
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}


	// Utilization
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}


	public WebElement getSearchButtonIcon() {
		return searchButtonIcon;
	}


	public WebElement getCartLink() {
		return cartLink;
	}


	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	
}
