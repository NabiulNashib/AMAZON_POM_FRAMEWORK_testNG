package com.amazon.uiautomation.homepage;

import com.amazon.uiautomation.excelreader.ExcelReader;
import com.amazon.uiautomation.testbase.TestBase;
import com.amazon.uiautomation.uiactions.HomePage;
import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.*;

public class TC003_VerifyLoginWithDifferentRecords extends TestBase {
    public static final Logger log = Logger.getLogger(TC003_VerifyLoginWithDifferentRecords.class.getName());
    protected HomePage homePage;
    ExcelReader excelReader;

    @Test(dataProvider = "dataSet")
    public void tC003_VerifyLoginWithDifferentRecords(String email, String passWord, String runMode){
        if(runMode.equalsIgnoreCase("n")){
            throw new SkipException("user make this record not to run");
        }
        log.info("--------------------TC003_VerifyLoginWithDifferentRecords Test Started-----------------");
        homePage = new HomePage(driver);
        homePage.loginToProfile(email,passWord,runMode);
        log.info("--------------------TC003_VerifyLoginWithDifferentRecords Test Finished-----------------");
    }


    @DataProvider(name = "dataSet")
    public Object[][] dataReader(){
        Object [][] data = null;
        excelReader = new ExcelReader("C:\\Users\\ShiftStudent\\amazon_test\\src\\main\\java\\com.amazon.uiautomation.data\\testData.xlsx");
        data = excelReader.getExcelSheetData(0,true);
        return data;
    }
}
