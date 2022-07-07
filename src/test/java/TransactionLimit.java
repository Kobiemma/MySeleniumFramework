import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;

public class TransactionLimit extends TestBase{
	
@SuppressWarnings("deprecation")
@Test
public void createTransactionLimit() throws Exception {
	
	Log.startTestCase("Create Transaction Limits");
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//p[contains(text(),'Transaction Limit')]")).click();
	driver.findElement(By.xpath("//*[@class='sc-jzJRlG cokFpe']")).click();
	
	
	for(int iRow = 1;iRow<=1;iRow++){
		
		
		driver.findElement(By.name("authTransactionCapAmount")).sendKeys("10");
		driver.findElement(By.name("dailyLimitAmount")).sendKeys("10");
		driver.findElement(By.name("name")).sendKeys("10");
		driver.findElement(By.name("transactionLimitAmount")).sendKeys("10");
		
		driver.findElement(By.id("mui-component-select-bankCode")).click();
		driver.findElement(By.xpath("//li[contains(@class,'MuiListItem-gutters MuiListItem-button') and @data-value='700']")).click();
		
		Thread.sleep(500);

		 driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-text jss') and @type='submit']")).click();
	}
	
}	
	@Test
	@SuppressWarnings("deprecation")
	public void viewTransactionLimits() throws Exception {
	
		Log.startTestCase("View Transaction Limits");
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		 driver.findElement(By.xpath("//button[contains(@class,'swal-button--confirm') and text()='OK']")).click();
		 driver.findElement(By.xpath("//p[contains(text(),'Transaction Limit')]")).click();
		 
		 driver.findElement(By.xpath("//button[contains(@class,'MuiButton-containedPrimary') and @type='button']")).click();
		 driver.findElement(By.name("name")).sendKeys("10");
		 driver.findElement(By.name("bankCode")).sendKeys("700");
		 driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-inputAdornedEnd') and @type='text'])[1]")).sendKeys(TestData.getCellData(1, 4, TestConstant.Sheet3));
		 driver.findElement(By.xpath("(//input[contains(@class,'MuiInputBase-inputAdornedEnd') and @type='text'])[2]")).sendKeys(TestData.getCellData(1, 5, TestConstant.Sheet3));
    	 
		 Thread.sleep(500);

		 driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-text jss') and @type='submit']")).click();
		
	}
}
