package SK_selenium.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SK_selenium.pageObjects.CartPage;
import SK_selenium.pageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void waitforElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	private WebElement ordersButton;
	
	public OrdersPage goToordersPage() {
		
		ordersButton.click();
		return new OrdersPage(driver);
	}
	
	@FindBy(css="button[routerlink*='/dashboard/cart']")
	private WebElement gocartButton;
	
	public CartPage goToCartPage() {
		
		gocartButton.click();
		
		return new CartPage(driver);
	}

	

}
