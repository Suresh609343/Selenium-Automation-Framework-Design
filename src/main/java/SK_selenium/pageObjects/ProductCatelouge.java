package SK_selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SK_selenium.AbstractComponents.AbstractComponents;

public class ProductCatelouge extends AbstractComponents{
	
	WebDriver driver;
	public CartPage cartpage;
//	String productName = "IPHONE 13 PRO";
	
	public ProductCatelouge(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	private List<WebElement> products;
	
	By productsBy = By.cssSelector(".mb-3");
	By toastMessage = By.cssSelector("#toast-container");
	By reqproduct = By.cssSelector(".w-10");
	
	public void productSelection(String productName) throws InterruptedException {
		
		waitforElementToAppear(productsBy);
		
		WebElement reqProduct = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().contains(productName)).findFirst().orElse(null);
		
		reqProduct.findElement(reqproduct).click();
		
		waitforElementToAppear(toastMessage);
		Thread.sleep(3000);
	}
	

}
