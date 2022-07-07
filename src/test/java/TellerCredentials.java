import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;

public class TellerCredentials extends TestBase{
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public void createTeller(int iRow) throws Exception {
		
		
		Log.startTestCase("Create Teller Credentials");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[@class='sc-dVhcbM iOSPTj'][contains(text(),'Teller Credentials')]")).click();
		driver.findElement(By.xpath("//*[@class='sc-jzJRlG cokFpe']")).click();	
		
		
		driver.findElement(By.id("mui-component-select-bankCode")).click();
		driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 0, TestConstant.Sheet5)+"')]")).click();
		Thread.sleep(1000);
		//driver.findElement(By.id("mui-component-select-branchCode")).click();
		//driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 0, TestConstant.Sheet5)+"')]")).click();
		//Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[contains(@class, 'MuiOutlinedInput-input') and @placeholder = 'Please enter a tag']")).sendKeys(TestData.getCellData(iRow, 2, TestConstant.Sheet5));
		
		driver.findElement(By.xpath("//input[contains(@class, 'MuiOutlinedInput-input') and @placeholder = 'Please enter an account number']")).sendKeys(TestData.getCellData(iRow, 3, TestConstant.Sheet5));
		
		Thread.sleep(500);

		driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-text jss') and @type='submit']")).click();
		
		
			
	}
	@Test
	public void CreateTellerSuccess() throws Exception {
		
		SoftAssert softassert = new SoftAssert();
		createTeller(1);
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//div[@class='swal-title']")).getText();
		Log.info("The actual message is"+message);
		softassert.assertEquals(message,"Success");
		softassert.assertAll();
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		Thread.sleep(1000);
	}
	

}
