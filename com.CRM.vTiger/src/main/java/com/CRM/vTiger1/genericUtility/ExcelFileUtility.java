package com.CRM.vTiger1.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @author Soumyajit
 */
import org.testng.annotations.DataProvider;
public class ExcelFileUtility {
	/**
	 * 
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	
	public String toGetDataFromExcelFile(String sheetName,int row,int cell) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstant.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	
	public void toUpdateDataInExcelFile(String sheetName,int row,int cell,String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IpathConstant.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		workbook.getSheet(sheetName).createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IpathConstant.excelFilePath);
		workbook.write(fos);
	}
	
	@DataProvider
	public Object[][] multipleData() throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("DataProvider");
		int lastRow = sheet.getLastRowNum()+1;
		short lastCell = sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		DataFormatter formatter=new DataFormatter();
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return data;
	}
}
