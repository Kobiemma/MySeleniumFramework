
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;


public class TestLogin extends TestBase{
	 
	
	@SuppressWarnings("deprecation")
   public void Login(int iRow) throws Exception{
		
 // Provide Log4j configuration settings
	Log.startTestCase("Login"); 
	
	
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 WebElement Username = driver.findElement(By.name("username"));
	 WebElement Password =driver.findElement(By.name("password"));
	 WebElement Submit =driver.findElement(By.xpath("//button[@type='submit']"));
	 
    			   
    //Username.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE)); Chrome
    Username.clear();
    Username.sendKeys(TestData.getCellData(iRow,0,TestConstant.Sheet1)); 
    //Password.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE)); Chrome
    Password.clear();
    Password.sendKeys(TestData.getCellData(iRow,1,TestConstant.Sheet1));
    Submit.click();
    //Password.sendKeys(Keys.RETURN);
    
    Log.info("Just Clicked on Sign Button");
    }
    
@Test  
 public void NegativeTests() throws Exception{ 
	 SoftAssert softAssert = new SoftAssert();
	 
for(int iRow = 1; iRow<=3; iRow++) {
		 
	 Login(iRow);
Thread.sleep(5000);
 WebElement errorOk = driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']"));
 softAssert.assertNotNull(errorOk);
 softAssert.assertAll();
 errorOk.click();
 
	 }
 }

 @Test   
 public void ValidEmailAndPassword() throws Exception{ 
	 
	 Login(4);
  
 SoftAssert softAssert = new SoftAssert();  
 WebElement dashboard = driver.findElement(By.xpath("//p[contains(text(),'Dashboard')]"));

 
 softAssert.assertNotNull(dashboard);
 softAssert.assertAll();
 Thread.sleep(1000);
 }
 
    }


     	 
     	 

	

