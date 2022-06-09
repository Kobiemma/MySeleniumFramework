package Utility;

public class TestConstant {
	
	//Paths And SheetName
	 //public static final String baseURL = "https://www.google.com/";
	 public static final String baseURL = "http://172.17.10.83:9876/";
     public static final String Path_TestData = "C:\\Users\\delphine.muoka\\eclipse-workspace\\SeleniumFramework1\\src\\test\\resources\\DataDriven\\TestData.xlsx";
     public static final String Path_ScreenShot = "C:\\Users\\delphine.muoka\\eclipse-workspace\\SeleniumFramework1\\src\\test\\resources\\ScreenShot\\";
     public static final String Log4j_Config = "C:\\Users\\Nkolika\\workspace\\Test\\src\\log4j.xml";
     public static final String Sheet1 = "LoginDetails";
     public static final String Sheet2 = "CardScheme";
     public static final String Sheet3 = "CardProfile";
    
     //Class To Run
    public static boolean ManageMerchants = true;
     
     
     //Login Elements
    
     public static String Username = "username";
     public static String Password = "password";
     public static String dashboard = "//span[contains(text(),'Dashboard')]";
     
   //Manage Merchants Elements
     public static String managemerchants = "//*[@id=\"sidebarnav\"]/li[3]/a/span";
     public static String CardProduction = "Card Production";
     public static String CardScheme = "Card Scheme";
     public static String CardName = "Card_Profile_Scheme.Name";
     public static String Create = "Create";
     public static String Save = "Save";
     public static String FilterName= "Filter_Name";
     public static String search = "Search";
     public static String ViewDetails = "#Results > tbody > tr:nth-child(1) > td:nth-child(3) > button";
     public static String edit = "Edit";
     public static String update = "Update_";
     
     //Card Profile Elements
     public static String AddNewPanComponent = "#AddCardProductionProfilePage > button";
     public static String ProfileName = "Name";
     public static String profileCardScheme = "CardScheme";
     public static String ExpirationPeriod = "ExpirationPeriod";
     public static String PANGenerationThreshold = "PAN_Generation_Notification_Threshold";
     public static String PANLength ="PANLength";
     public static String PANPrefix = "PANPrefix";
     public static String PanComponentType = "PanComponents_0_PanComponentType";
     public static String PanComponentsLength = "PanComponents_0_Length";
     public static String CreateCardProfile = "Create_Card_Profile";
     
     
}
