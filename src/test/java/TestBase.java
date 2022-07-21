


import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	
	//System.setProperty("webdriver.firefox.bin", "C:\\Users\\delphine.muoka\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
 
  //driver = new FirefoxDriver();
     driver = new ChromeDriver();
  js = (JavascriptExecutor) driver;
  vars = new HashMap<String, Object>();
  driver.get(TestConstant.baseURL);
  
 
 // driver.manage().window().setSize(new Dimension(956, 692));
  

  
}

@AfterClass(alwaysRun = false)
public void afterClass() {
        
}

@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult result) throws Exception {
	/*if (result.getStatus()==ITestResult.FAILURE){
	//Screenshot.takeScreenShoot(driver, result.getMethod());
	//Log.info("Test Failed at"+""+result.getMethod().getMethodName());}*/
	
	 switch(result.getStatus()) {
     case ITestResult.FAILURE :
    	    Screenshot.takeScreenShoot(driver, result.getMethod());
    		Log.info("Test Failed at"+""+result.getMethod().getMethodName());
        break;
     case ITestResult.SUCCESS :
    	 Screenshot.takeScreenShoot(driver, result.getMethod());
 		Log.info("Test was Successful at "+""+result.getMethod().getMethodName());
        break;
     case ITestResult.SKIP :
    	 Screenshot.takeScreenShoot(driver, result.getMethod());
 		Log.info("Test was Skipped at "+""+result.getMethod().getMethodName());
        break;
     default :
    	 }
	
  }





}
 
 




