

import java.io.IOException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utility.Log;
import Utility.TestConstant;
import Utility.TestData;



public class ManageMerchants extends TestLogin{
	
@BeforeMethod(alwaysRun = true)
public void checkCaseToRun() throws IOException{
	
	if(TestConstant.ManageMerchants==false){
		throw new SkipException("Manage Merchants was Skipped")	;
	}
	
}	
@Test
public void AddCardProfile() throws Exception{
	Login();
	Log.startTestCase("Manage Merchants");
	Log.info("Manage Merchants");
	Log.info("RowCount"+TestData.getRowCount(TestConstant.Sheet3));

	driver.findElement(By.xpath("//svg[@class='MuiSvgIcon-root']")).click();
	
	
	for(int iRow = 1;iRow<= TestData.getRowCount(TestConstant.Sheet3);iRow++){
	driver.findElement(By.linkText(TestConstant.Create)).click();
	driver.findElement(By.name(TestConstant.ProfileName)).clear();
	driver.findElement(By.name(TestConstant.ProfileName)).sendKeys(TestData.getCellData(iRow, 0,TestConstant.Sheet3));
	Select sel= new Select(driver.findElement(By.id(TestConstant.profileCardScheme)));
	sel.selectByVisibleText(TestData.getCellData(iRow, 1,TestConstant.Sheet3));
	driver.findElement(By.name(TestConstant.ExpirationPeriod)).clear();
	driver.findElement(By.name(TestConstant.ExpirationPeriod)).sendKeys(TestData.getCellData(iRow, 2,TestConstant.Sheet3));
	driver.findElement(By.name(TestConstant.PANGenerationThreshold)).clear();
	driver.findElement(By.name(TestConstant.PANGenerationThreshold)).sendKeys(TestData.getCellData(iRow, 3,TestConstant.Sheet3));
	driver.findElement(By.name(TestConstant.PANLength)).clear();
	driver.findElement(By.name(TestConstant.PANLength)).sendKeys(TestData.getCellData(iRow, 4,TestConstant.Sheet3));
	driver.findElement(By.name(TestConstant.PANPrefix)).clear();
	driver.findElement(By.name(TestConstant.PANPrefix)).sendKeys(TestData.getCellData(iRow, 5,TestConstant.Sheet3));
	driver.findElement(By.cssSelector(TestConstant.AddNewPanComponent)).click();
	Select sel1= new Select(driver.findElement(By.name(TestConstant.PanComponentType)));
	sel1.selectByVisibleText(TestData.getCellData(iRow, 6,TestConstant.Sheet3));
	Thread.sleep(1000);
	driver.findElement(By.name(TestConstant.PanComponentsLength)).clear();
	driver.findElement(By.name(TestConstant.PanComponentsLength)).sendKeys(TestData.getCellData(iRow, 7,TestConstant.Sheet3));
	driver.findElement(By.id(TestConstant.CreateCardProfile)).click();
	
	asserting("CardProfile created","Error : One of these Fields are not unique at DejaVu.EntityService.Grains.Entity.d__17.MoveNext()");
	 
}

}

@Test
public void EditCardProfile() throws Exception{
	driver.findElement(By.name(TestConstant.FilterName)).sendKeys(TestData.getCellData(1, 0,TestConstant.Sheet2));
	driver.findElement(By.id(TestConstant.search)).click();
	Thread.sleep(500);
	driver.findElement(By.cssSelector(TestConstant.ViewDetails)).click();
	driver.findElement(By.linkText(TestConstant.edit)).click();
	driver.findElement(By.name(TestConstant.CardName)).clear();
	driver.findElement(By.name(TestConstant.CardName)).sendKeys(TestData.getCellData(2, 0,TestConstant.Sheet2));
	driver.findElement(By.id(TestConstant.update)).click();
	
	asserting("Card scheme updated","Scheme name already exists");
}
}