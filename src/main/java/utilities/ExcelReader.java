package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
//	public FileInputStream fis=null;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	int rowCount;
	
	public ExcelReader(String path, String sheetName) {
		// TODO Auto-generated constructor stub
		try {
//			System.out.println("File path = " + path);
//			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet(sheetName);
			
		}catch(Exception e) {
			
			System.out.println("Excel Reader constructor Failed!!");
			e.printStackTrace();
		}		
		
	}
	
	
	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getColumnCount() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	public String getCellData(int row, int column) {
		
		String jj = "";
		try {			
			
			jj =  sheet.getRow(row).getCell(column).getStringCellValue();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return jj;
		
	}
		
	public int getIntCellData(int row, int column) {
		int data = 0;
		double x = 0.0;
		try {
			
			 x = sheet.getRow(row).getCell(column).getNumericCellValue();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		data = (int)x;
		return data;
	}
	
	
	
	
	public String getValueOfProperty(String property) {
		String value = "";
		rowCount = getRowCount();
		System.out.println("Row count = " + rowCount);
		for(int i=0;i<rowCount;i++) {
						
			if(getCellData(i, 0).equals(property)) {
				System.out.println("Item found!!");
				value = getCellData(i, 1);
				break;
			}
			
		}
		
		return value;
	}
		


	
}
