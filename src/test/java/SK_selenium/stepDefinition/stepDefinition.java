package SK_selenium.stepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SK_selenium.TestComponents.WebBaseTest;
import SK_selenium.pageObjects.CartPage;
import SK_selenium.pageObjects.Landingpage;
import SK_selenium.pageObjects.PaymentPage;
import SK_selenium.pageObjects.ProductCatelouge;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends WebBaseTest{
	
	public Landingpage landingPage;
	public ProductCatelouge productcatelougue;
	public CartPage cartpage; 
	public PaymentPage paymentpage;
	WebElement textMessage;
	
	@Given("I Landed on Ecommerce Page")
	public void I_Landed_on_Ecommerce_Page() throws IOException {
		
		landingPage = launchApplication();
	}
	
	@Given("^Login with username (.+) and password (.+)$")
	public void Login_with_username_and_password(String name, String password) {
		
		productcatelougue = landingPage.LoginApplication(name, password);
		
	}
	
	@When("^Add Product (.+) to cart$")
	public void Add_Product_to_cart(String productName) throws InterruptedException {
		
		productcatelougue.productSelection(productName);
		cartpage = productcatelougue.goToCartPage();
	}
	
	@When("^Verify the Product (.+) and go to checkout Page and place the Order$")
	public void Verify_the_Product_and_go_to_checkout_Page_and_place_order(String productName) {
		
		cartpage.productVerification(productName);
		paymentpage = cartpage.checkout();
		
		paymentpage.enterCountry("India");
		paymentpage.waitforElementToAppear(By.cssSelector(".list-group"));
		paymentpage.selectCountry();
		textMessage = paymentpage.placeTheOrder();
		
	}
	
	@Then("{string} message is displayed on the Confirmation Page")
	public void Verify_message_is_displayed_on_the_confirmation_Page(String string){
		
		Assert.assertEquals(textMessage.getText(), string);
		driver.quit();
	}
	
	@Then("I verify the message {string}")
	public void Verify_message_is_displayed(String string){
		
		Assert.assertEquals(landingpage.geterrorMessage(), string);
		driver.quit();
	}
}
