




import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;


public class TestLogin extends TestBase{
	
	
	
	@SuppressWarnings("deprecation")
	@Test
   public void Login() throws Exception{
		
	
 // Provide Log4j configuration settings
	Log.startTestCase("Login"); 
	
	
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 WebElement Username = driver.findElement(By.name(TestConstant.Username));
	 WebElement Password =driver.findElement(By.name(TestConstant.Password));
	
	 
    Log.info("RowCount"+TestData.getRowCount(TestConstant.Sheet1));
    
   
    for(int iRow = 1;iRow<= 1;iRow++){
    			
   
    Username.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    Username.sendKeys(TestData.getCellData(iRow,0,TestConstant.Sheet1)); 
    Password.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    Password.sendKeys(TestData.getCellData(iRow,1,TestConstant.Sheet1));
    Password.sendKeys(Keys.RETURN);
    Log.info("Just Clicked on Sign Button");
    
    
    
  
    
    if(driver.findElements(By.xpath(TestConstant.dashboard)).isEmpty()){
    	TestData.setCellData("FAIL", iRow,2);
    	
    	  
    }else{
    	
    	TestData.setCellData("PASS", iRow,2);
    	Log.info("Successfully Logged in");
    
    	  
    }	  
    }
   
     		 
	}

}
