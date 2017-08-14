package datadriven;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		
		XSSFWorkbook ExcelBook;
		XSSFSheet ExcelSheet;
		XSSFCell Cell;
		
		// Location of the Excel file
		String path = "C:\\Users\\NISHANT\\eclipse-workspace\\SeleniumPractice\\src\\datadriven\\ExcelRead.xlsx";
		String sheetName = "Sheet1";
		
		try {
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelBook.getSheet(sheetName);
			
			Cell = ExcelSheet.getRow(1).getCell(2);
			String cellData = Cell.getStringCellValue();
			System.out.println("Cell Data: "+cellData);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
