package datadriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility_SingleDataSet {
	
	private static XSSFWorkbook ExcelBook;
	private static XSSFSheet ExcelSheet;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	/*
	 * Set the File path, open Excel file
	 * @params - Excel Path and Sheet Name
	 */
	public static void setExcelFile(String path, String sheetName) throws Exception {
		try {
			// Open Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			
			// Access the excel data sheet
			ExcelBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelBook.getSheet(sheetName);
		} catch (Exception e) {
			throw(e);
		}
	}
	
	/*
	 * Read the test date from the excel cell
	 * @params - Row num and Col num
	 */
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return "";
		}
	}
	
	/*
	 * Read the test date from the excel cell
	 * @params - Row num and Col num
	 */
	public static String getDataCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelSheet.getRow(RowNum).getCell(ColNum);
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			Date dateValue = Cell.getDateCellValue();
			String dateStringFormat = df.format(dateValue);
			
			return dateStringFormat;
		} catch (Exception e) {
			return "";
		}
	}
	
	/*
	 * Write in the Excel cell, String result
	 * @params - Row num and Col num
	 */
	public static void setCellData(String result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if(Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(result);
			}
			
			FileOutputStream fileOut = new FileOutputStream(Constants.File_Path + Constants.File_Name);
			ExcelBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} 
		catch (Exception e) {
			throw(e);
		}
	}
	
	/*
	 * Write in the Excel cell, double result
	 * @params - Row num and Col num
	 */
	public static void setCellData(double result, int RowNum, int ColNum) throws Exception {
		try {
			Row = ExcelSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if(Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(result);
			}
			
			FileOutputStream fileOut = new FileOutputStream(Constants.File_Path + Constants.File_Name);
			ExcelBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} 
		catch (Exception e) {
			throw(e);
		}
	}
}
