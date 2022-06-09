package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class TestData {
	private static XSSFSheet ExcelWSheet;	 
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num


public static String getCellData(int RowNum, int ColNum, String Sheetname) throws Exception{
	String cellData = null;       
	try{
		    
		     OpenExcelFile();
			// Access the required test data sheet
			ExcelWSheet = ExcelWBook.getSheet(Sheetname);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            cellData = Cell.getStringCellValue();
	            }
            catch(Exception e){
            	Log.error("TestData Class | Method getCellData | Exception desc"+e.getMessage());	
			
			}
	 return cellData;
}
public static int getRowCount(String Sheetname){
	int RowCount=0;
	try{
	OpenExcelFile();
	// Access the required test data sheet
	ExcelWSheet = ExcelWBook.getSheet(Sheetname);
	RowCount = ExcelWSheet.getLastRowNum();
	}
	catch(Exception e){
		
		Log.error("TestData Class | Method getRowCount | Exception desc"+e.getMessage());
	}
	return RowCount;
	
}

public static void OpenExcelFile(){
	
	try{
		File src = new File(TestConstant.Path_TestData);
		FileInputStream ExcelFile = new FileInputStream(src);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
	}
	catch(Exception e){
		
		Log.error("TestData Class | Method OpenExcelFile | Exception desc"+e.getMessage());
	}
	
}
//This method is to write in the Excel cell, Row num and Col num are the parameters

public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

			Row  = ExcelWSheet.getRow(RowNum);
			

		Cell = Row.getCell(ColNum, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

		if (Cell == null) {

			Cell = Row.createCell(ColNum);

			Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

// Constant variables Test Data path and Test Data file name

				FileOutputStream fileOut = new FileOutputStream(TestConstant.Path_TestData);

				ExcelWBook.write(fileOut);

				fileOut.flush();

				fileOut.close();

			}catch(Exception e){

				throw (e);

		}}
	}


