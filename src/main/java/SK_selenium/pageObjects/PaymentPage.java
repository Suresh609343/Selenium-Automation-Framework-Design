package SK_selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SK_selenium.AbstractComponents.AbstractComponents;

public class PaymentPage extends AbstractComponents {
	
	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[placeholder*='Select Country']")
	private WebElement countryName;
	
	public void enterCountry(String country) {
		
		countryName.sendKeys(country);
	}
	
	@FindBy(css=".list-group button.ta-item:nth-of-type(2)")
	private WebElement enterCountryName;
	
	public void selectCountry() {
		
		enterCountryName.click();
	}
	
	@FindBy(css="a.action__submit")
	private WebElement placeorderButton;
	
	@FindBy(css=".hero-primary")
	public WebElement textMessage;
	
	public WebElement placeTheOrder() {
		
		placeorderButton.click();
		return textMessage;
	}

}
