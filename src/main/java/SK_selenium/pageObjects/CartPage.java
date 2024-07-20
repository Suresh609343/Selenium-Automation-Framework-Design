package SK_selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	public PaymentPage paymentpage;
	String productName = "IPHONE 13 PRO";
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartWrap")
	private List<WebElement> cartProducts;
	
	public boolean productVerification(String productName) {
		
		boolean verf = cartProducts.stream().anyMatch(product->
		product.findElement(By.cssSelector(".cartWrap h3")).getText().equalsIgnoreCase(productName));
		return verf;
	}
	
	@FindBy(css="li.totalRow button.btn-primary")
	private WebElement checkoutButton;
	
	public PaymentPage checkout() {
		
		checkoutButton.click();
		
		return new PaymentPage(driver);
	}

}
