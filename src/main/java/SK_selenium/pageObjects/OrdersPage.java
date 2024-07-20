package SK_selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SK_selenium.AbstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents{
	
	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr//td[2]")
	private List<WebElement> ordersNames;
	
	public boolean findtheProduct(String productName) {
		
		boolean match = ordersNames.stream().anyMatch(order->order.getText().equalsIgnoreCase(productName));
		return match;
	}

}
