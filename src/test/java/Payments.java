import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;

public class Payments extends TestBase {
	
	
	@Test
	@SuppressWarnings("deprecation")
	public void makePayment() throws Exception {
		
		Log.startTestCase("Make Payment Page");
		
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     WebElement paymentMenu = driver.findElement(By.xpath("//p[contains(text(),'Payment')]"));
	     paymentMenu.click();
	     
	     for(int iRow = 1;iRow<=1;iRow++){
	    	 
		 WebElement searchBox =driver.findElement(By.xpath("//div[@class='sc-GMQeP fWMUYW']//form//div[@class='sc-kafWEX eTfKOR']//input[@type='text']"));
		 searchBox.sendKeys(TestData.getCellData(1, 0, TestConstant.Sheet2));
		 WebElement SearchBtn = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
		 SearchBtn.click();
		 //searchBox.sendKeys(Keys.RETURN);
		 WebElement searchItem =driver.findElement(By.xpath("//div[@class='MuiTypography-root'][contains(text(),'Collection')]"));
		 searchItem.click();
		 
		 driver.findElement(By.name("firstName")).sendKeys(TestData.getCellData(1, 1, TestConstant.Sheet2));
		 driver.findElement(By.name("lastName")).sendKeys(TestData.getCellData(1, 2, TestConstant.Sheet2));
		 driver.findElement(By.name("phoneNumber")).sendKeys(TestData.getCellData(1, 3, TestConstant.Sheet2));
		 driver.findElement(By.name("email")).sendKeys(TestData.getCellData(1, 4, TestConstant.Sheet2));
		 driver.findElement(By.name("address")).sendKeys(TestData.getCellData(1, 5, TestConstant.Sheet2));
		 driver.findElement(By.name("paymentType")).sendKeys(TestData.getCellData(1, 6, TestConstant.Sheet2));
		 driver.findElement(By.name("req")).sendKeys(TestData.getCellData(1, 7, TestConstant.Sheet2));
		 driver.findElement(By.name("amount")).sendKeys(TestData.getCellData(1, 8, TestConstant.Sheet2));
		 driver.findElement(By.xpath("//button[@class='StyledTabMerchantNextButton'][contains(text(),'Continue')]")).click();
			 
		 }
		 
	}
	
	
	

}
