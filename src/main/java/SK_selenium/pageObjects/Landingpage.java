package SK_selenium.pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Landingpage{
	
	WebDriver driver;
	public ProductCatelouge productcatelougue;
	
	public Landingpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	WebElement usermail = driver.findElement(By.id("userEmail"));
	
	@FindBy(id="userEmail")
	private WebElement usermail;
	
	@FindBy(id="userPassword")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement loginButton;
	
	public ProductCatelouge LoginApplication(String email, String Password) {
		
		usermail.sendKeys(email);
		password.sendKeys(Password);
		loginButton.click();
		
		return new ProductCatelouge(driver);
	}
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	private WebElement toastError;
	
	public String geterrorMessage() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println(toastError.getText());
		return toastError.getText();
	}

}
