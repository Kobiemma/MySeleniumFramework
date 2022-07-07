import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;

public class TestUsers extends TestBase{
	
	
	
	@SuppressWarnings("deprecation")
	public void createUsers(int iRow) throws Exception {
		
		
		Log.startTestCase("Create Users");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[@class='sc-dVhcbM iOSPTj'][contains(text(),'Users')]")).click();
		driver.findElement(By.xpath("//*[@class='sc-jzJRlG cokFpe']")).click();	
		
		
		driver.findElement(By.name("firstName")).sendKeys(TestData.getCellData(iRow, 0, TestConstant.Sheet4));	
		driver.findElement(By.name("lastName")).sendKeys(TestData.getCellData(iRow, 1, TestConstant.Sheet4));
		driver.findElement(By.name("username")).sendKeys(TestData.getCellData(iRow, 2, TestConstant.Sheet4));
		driver.findElement(By.name("email")).sendKeys(TestData.getCellData(iRow, 3, TestConstant.Sheet4));
		driver.findElement(By.name("phoneNumber")).sendKeys(TestData.getCellData(iRow, 4, TestConstant.Sheet4));
		
		driver.findElement(By.id("mui-component-select-loginTimeLimitId")).click();
		driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 5, TestConstant.Sheet4)+"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mui-component-select-banks")).click();
		driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 6, TestConstant.Sheet4)+"')]")).click();
		
		//driver.findElement(By.id("mui-component-select-branchCode")).click();
	    //driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 0, TestConstant.Sheet4)+"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mui-component-select-transactionLimitId")).click();
		driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 8, TestConstant.Sheet4)+"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("mui-component-select-tellerCredentialsId")).click();
		driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 9, TestConstant.Sheet4)+"')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("twoFactorSeed")).sendKeys(TestData.getCellData(iRow, 10, TestConstant.Sheet4));
		
		driver.findElement(By.xpath("//*[@class='css-19bqh2r']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'"+TestData.getCellData(iRow, 11, TestConstant.Sheet4)+"')]")).click();
		
		Thread.sleep(500);

		driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-text jss') and @type='submit']")).click();
		
		
			
	}
		
		@Test
		public void createSuccesful() throws Exception {
			SoftAssert softassert = new SoftAssert();
			
			
			createUsers(1);
			Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//div[@class='swal-title']")).getText();
		Log.info("The actual message is"+message);
		softassert.assertEquals(message,"Success");
		softassert.assertAll();
		
		Thread.sleep(1000);
			
			
		
		
		}
		
	}
	
	


