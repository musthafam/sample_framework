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
	 * @param filePath  the Filepath of the excel sheet
	 * @param sheetName The sheetname that needs be accessed
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
	
	
	
	

}
