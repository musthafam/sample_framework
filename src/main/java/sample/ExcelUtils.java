package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static File file;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	/**
	 * This method helps to set the File path of the excel sheet and the Sheet name in which data is present
	 * @param filePath  the File path of the excel sheet
	 * @param sheetName The sheet name that needs be accessed
	 * 
	 */
	
	public static void setExcelPath(String filePath,String sheetName) {
		try {
			file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * This method helps to retrieve data for the given row and column number
	 * @param rowNumber  The row number in the excel sheet starting from 0
	 * @param columnNumber  The column number in the excel sheet starting from 0
	 * @return the cell value
	 */
	
	public static String getCellData(int rowNumber , int columnNumber) {
		String cellData = "";
		try {
			row=sheet.getRow(rowNumber);
			cell = row.getCell(columnNumber);
			cellData = cell.getStringCellValue();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return cellData;
		
	}
	
	/**
	 * This method helps to retrieve cell value based on Row name and Column Name
	 * @param rowName   Name of the row
	 * @param columnName Name of the column
	 * @return
	 */
	
	public static String getCellData(String rowName , String columnName) {
		String cellValue="";
		try {
			int rowNum = sheet.getLastRowNum()+1;
			int colNum = sheet.getRow(0).getLastCellNum();
			int reqColumn = 0;
			XSSFRow firstRow = sheet.getRow(0);
			for(int i=0;i<colNum;i++) {
				XSSFCell cellVal = firstRow.getCell(i);
				String tempColName = cellVal.getStringCellValue();
				if(tempColName.equalsIgnoreCase(columnName)) {
					reqColumn = cellVal.getColumnIndex();
				}
			}
			for(int j=0;j<rowNum;j++) {
				XSSFRow tempRow = sheet.getRow(j);
				XSSFCell tempCell = tempRow.getCell(0);
				XSSFCell reqCell = tempRow.getCell(reqColumn);
				if(tempCell.getStringCellValue().equalsIgnoreCase(rowName)) {
					cellValue=reqCell.getStringCellValue();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;
		
	}
	
	
	
	

}
