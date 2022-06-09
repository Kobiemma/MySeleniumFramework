





import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import Utility.Log;
import Utility.Screenshot;
import Utility.TestConstant;



public class TestBase {
	
protected static WebDriver driver; 
private Map<String, Object> vars;
JavascriptExecutor js;

@BeforeSuite
public void beforeSuite() {
	
String projectPath = System.getProperty("user.dir");
	
	System.out.println(projectPath);
	
	
     System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/Chromedriver/chromedriver.exe");
	//System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver64/geckodriver.exe");
 
  driver = new ChromeDriver();
  js = (JavascriptExecutor) driver;
  vars = new HashMap<String, Object>();
  driver.get(TestConstant.baseURL);
  
 
 // driver.manage().window().setSize(new Dimension(956, 692));
  

  
}

@AfterClass(alwaysRun = true)
public void afterClass() {
        
	if(!driver.findElements(By.id("bot1-Msg2")).isEmpty()){
    	driver.findElement(By.id("bot1-Msg2")).click();}
	    Log.endTestCase("END");
}

@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws Exception {
	if (result.getStatus()==ITestResult.FAILURE){
	Screenshot.takeScreenShoot(driver, result.getMethod());
	Log.info("Test Failed at"+""+result.getMethod().getMethodName());}
	
  }


public void asserting(String str1, String str2){
	if(!driver.findElements(By.id("bot1-Msg1")).isEmpty()){
		WebElement element= driver.findElement(By.className("pText"));
	    String str = element.getText();
	    Assert.assertTrue(str1.equals(str) || str2.equals(str));
	    driver.findElement(By.id("bot1-Msg1")).click();
	    Log.info(str1+"/"+str2);
    	}
}


}
 
 




