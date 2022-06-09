package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGMethod;
import org.apache.commons.io.FileUtils;

public class Screenshot {
	 
	public static void takeScreenShoot(WebDriver driver, ITestNGMethod testMethod) throws Exception {
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
	String nameScreenshot = testMethod.getMethodName();
	FileUtils.copyFile(scrFile, new File(TestConstant.Path_ScreenShot + getFileName(nameScreenshot)));
	Log.info("" + getFileName(nameScreenshot));
	}
	 
	private static String getFileName(String nameTest) throws IOException {
	DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
	Date date = new Date();
	return dateFormat.format(date) + "_" + nameTest + ".png";
	}
	 
}
