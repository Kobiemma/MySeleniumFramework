import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;

public class Transactions extends TestBase{
	
	
	@Test
	public void viewTransactions() throws Exception {
		
		
		Log.startTestCase("View Transaction Page");
		
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     WebElement transactions = driver.findElement(By.xpath("//p[@class='sc-dVhcbM iOSPTj'][contains(text(),'Transaction')]"));
	     transactions.click();
	     driver.findElement(By.xpath("//div[@style='width: 10rem; height: 4.4rem; background: rgb(0, 66, 116) none repeat scroll 0% 0%; display: flex; justify-content: center; align-items: center; cursor: pointer; margin-left: 2rem;']")).click();
	     
	     for(int iRow = 1;iRow<=1;iRow++){
	    	 
	    	 driver.findElement(By.name("serviceNameLike")).sendKeys(TestData.getCellData(1, 0, TestConstant.Sheet3));
			 
			 driver.findElement(By.id("mui-component-select-paymentStatus")).click();
			 driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(1, 1, TestConstant.Sheet3)+"')]")).click();
			 
			 driver.findElement(By.name("merchantNameLike")).sendKeys(TestData.getCellData(1, 2, TestConstant.Sheet3));
			 
			 driver.findElement(By.id("mui-component-select-paymentType")).click();
			 driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(1, 3, TestConstant.Sheet3)+"')]")).click();
			 Thread.sleep(500);
			 
			 driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-inputAdornedEnd') and @type='text'])[1]")).sendKeys(TestData.getCellData(1, 4, TestConstant.Sheet3));
			 driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-inputAdornedEnd') and @type='text'])[2]")).sendKeys(TestData.getCellData(1, 5, TestConstant.Sheet3));
	    	 
			 driver.findElement(By.xpath("//button[contains(@class,'MuiButton-text jss') and @type='submit']")).click();
	     }
		
		
	}

}
