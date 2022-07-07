import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;

public class ipConfiguration extends TestBase{
	
	
	
	
	
	
	@SuppressWarnings("deprecation")
	public void createIPConfig(int iRow) throws Exception {
		
		
		Log.startTestCase("Create Teller Credentials");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//p[contains(text(),'IP Configuration')]")).click();
		driver.findElement(By.xpath("//*[@class='sc-jzJRlG cokFpe']")).click();	
		
		
		driver.findElement(By.name("domain")).sendKeys(TestData.getCellData(iRow, 0, TestConstant.Sheet6));
		
		driver.findElement(By.name("ip")).sendKeys(TestData.getCellData(iRow, 1, TestConstant.Sheet6));
		
		driver.findElement(By.id("mui-component-select-issuerCode")).click();
		driver.findElement(By.xpath("//li[contains(text(),'"+TestData.getCellData(iRow, 2, TestConstant.Sheet6)+"')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//button[contains(@class,'MuiButton-root MuiButton-text jss') and @type='submit']")).click();
		
		
			
	}
	@Test
	public void CreateIPconfigSuccess() throws Exception {
		
		SoftAssert softassert = new SoftAssert();
		createIPConfig(1);
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//div[@class='swal-title']")).getText();
		Log.info("The actual message is"+message);
		softassert.assertEquals(message,"Success");
		softassert.assertAll();
		
	}
	

}