package SK_selenium.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import SK_selenium.pageObjects.Landingpage;

public class WebBaseTest {
	
	public WebDriver driver;
	public Landingpage landingpage;

	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		String file = System.getProperty("user.dir")+"\\src\\main\\java\\SK_selenium\\resources\\GlobalData.properties";
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :  prop.getProperty("browser");
		
		if(browserName.contains("Chrome")) {
			
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1440,900));
		}
		else if(browserName.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
//		json to String 
		
		String jsoncontent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\SK_selenium\\data\\PurchaseOrder.json"),
				StandardCharsets.UTF_8);
		
//		String to HashMap
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String, String>> data = mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>(){});
				
		return data;
		
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
		FileUtils.copyFile(file, new File(destination));
		return destination;
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage launchApplication() throws IOException {
		
		initializeDriver();
		landingpage = new Landingpage(driver);
		landingpage.goTo();
		return landingpage;
	}
	

	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
