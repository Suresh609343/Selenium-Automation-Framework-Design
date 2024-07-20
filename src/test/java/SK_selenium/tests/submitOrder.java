package SK_selenium.tests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SK_selenium.TestComponents.WebBaseTest;
import SK_selenium.pageObjects.CartPage;
import SK_selenium.pageObjects.OrdersPage;
import SK_selenium.pageObjects.PaymentPage;
import SK_selenium.pageObjects.ProductCatelouge;

public class submitOrder extends WebBaseTest{

	String productName = "IPHONE 13 PRO";
	
	@Test(dataProvider="getData",groups="Purchase")
	public void E_CommerceTest(HashMap<String, String> input) throws InterruptedException, IOException {
		
//		String productName = "IPHONE 13 PRO";
		ProductCatelouge productcatelougue = landingpage.LoginApplication(input.get("email"), input.get("password"));
		
		productcatelougue.productSelection(input.get("productName")); 
		CartPage cartpage = productcatelougue.goToCartPage();

		cartpage.productVerification(productName);
		PaymentPage paymentpage = cartpage.checkout();

		paymentpage.enterCountry("India");
		paymentpage.waitforElementToAppear(By.cssSelector(".list-group"));
		paymentpage.selectCountry();
		WebElement textMessage = paymentpage.placeTheOrder();
		
		Assert.assertEquals(textMessage.getText(), "THANKYOU FOR THE ORDER.");
	}
	
	@Test(dependsOnMethods= {"E_CommerceTest"})
	public void OrderHistortTest() {
		
		ProductCatelouge productcatelougue = landingpage.LoginApplication("sureshkumar@gmail.com", "6093430Sm*");
		OrdersPage orders = productcatelougue.goToordersPage();
		orders.goToordersPage();
		Assert.assertTrue(orders.findtheProduct(productName));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
		
		
//		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\SK_selenium\\data\\PurchaseOrder.json");
		
//		return new Object[][] {{data.get(0)},{data.get(1)}};
		
		
		
		
//		This is the 1st Dataset paired in a Key-value pair manner.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "sureshkumar@gmail.com");
		map.put("password", "6093430Sm*");
		map.put("productName", "IPHONE 13 PRO");
		
//		Now for the 2nd Dataset.
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "skmgralanja@gmail.com");
		map1.put("password", "6093430Sm*");
		map1.put("productName", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
		
//		ORRRRRRR
		
//		return new Object[][] {{"sureshkumar@gmail.com","6093430Sm*","IPHONE 13 PRO"},{"skmgralanja@gmail.com","6093430Mg*","ADIDAS ORIGINAL"}};
	}

}
