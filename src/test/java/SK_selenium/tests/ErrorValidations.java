package SK_selenium.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import SK_selenium.TestComponents.WebBaseTest;
import SK_selenium.pageObjects.CartPage;
import SK_selenium.pageObjects.ProductCatelouge;

public class ErrorValidations extends WebBaseTest{

	@Test(groups= {"ErrorValidations"})
	public void LoginErrorValidation() throws InterruptedException, IOException {
		
		landingpage.LoginApplication("sureshkumar@gmail.com", "609343Sm*");
		
		Assert.assertEquals(landingpage.geterrorMessage(), "Incorrect email or password.");
		
	}
	
	@Test
	public void ProductErrorVlidation() throws InterruptedException, IOException {
		
		String productName = "IPHONE 13 PRO";
		ProductCatelouge productcatelougue = landingpage.LoginApplication("sureshkumar@gmail.com", "6093430Sm*");
		
		productcatelougue.productSelection(productName); 
		CartPage cartpage = productcatelougue.goToCartPage();

		boolean match = cartpage.productVerification("IPHONE 13 PROO");
		Assert.assertFalse(match);

	}
}
