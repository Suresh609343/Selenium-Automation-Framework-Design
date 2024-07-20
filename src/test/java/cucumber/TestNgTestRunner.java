package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="C:\\Users\\sures\\eclipse-workspace\\SeleniumFrameWorkDesign\\src\\test\\java\\cucumber",
		glue="SK_selenium.stepDefinition",
		monochrome=true,
		tags="@Regression",
		plugin= {"html:cucmberReports/cucmber.html"})


public class TestNgTestRunner extends AbstractTestNGCucumberTests{

	
}
