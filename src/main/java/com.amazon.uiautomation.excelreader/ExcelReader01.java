package com.amazon.uiautomation.excelreader;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader01 {
    private String path;
    private FileInputStream fis;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow rows;
    private XSSFCell cell;

    public ExcelReader01(String path){
        this.path = path;
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
        }
        catch(Exception e){e.getStackTrace();}
    }

    public String [][] getDataFromSheet(String sheetName, String excelName){
        String dataSets[][] = null;
        try{
            sheet = workbook.getSheet(sheetName);
             int totalRows = sheet.getLastRowNum() +1 ;
             int totalColumns = sheet.getRow(0).getLastCellNum();
             dataSets = new String[totalRows - 1][totalColumns];
             for(int i = 1; i < totalRows; i++){
                 rows = sheet.getRow(i);
                 for(int j = 0; j < totalColumns; j++){
                     cell = rows.getCell(j);
                     if(cell.getCellType() == Cell.CELL_TYPE_STRING){
                         dataSets[i - 1][j] = cell.getStringCellValue();
                     }
                     else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
                         String cellText = String.valueOf(cell.getNumericCellValue());
                         dataSets[i - 1][j] = cellText;
                     }
                     else{
                         dataSets[i - 1][j] = String.valueOf(cell.getBooleanCellValue());
                     }
                 }
                 return dataSets;
             }
        }
        catch(Exception e){e.getStackTrace();}
        return  dataSets;
    }
}
