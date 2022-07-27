package learnApachePoi;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			FileInputStream file = new FileInputStream("Data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Employees");
			Iterator<Row> rows = sheet.rowIterator();
			while(rows.hasNext()) {
				System.out.println();
				Row row = rows.next();
				Iterator<Cell> cells = row.cellIterator();
				while(cells.hasNext()) {
					Cell cell = cells.next();
					switch(cell.getCellType()) {
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "\t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "\t");
						break;
					default:
						break;
					}
				}
			}
			workbook.close();
			file.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 
		 * Doing the same with for loop
		 * 
		 */
		
		System.out.println();
		System.out.println("***********************************\n*****************************");

		try {
			
			FileInputStream file = new FileInputStream("C:\\Data\\Wallethub\\Data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheet("Employees");
			
			Iterable<Row> rows = (Iterable<Row>) sheet.rowIterator();
			
			for(Row row: rows) {
				Iterable<Cell> cells = (Iterable<Cell>) row.cellIterator();
				System.out.println();
				
				for(Cell cell:cells) {
					switch(cell.getCellType()) {
					
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "/t");
						break;
					case STRING:
						System.out.println(cell.getStringCellValue() + "/t");
					default:
						break;
						
					}
				}
				
				
				
			}
			
			workbook.close();
			file.close();
			
		}catch(Exception e) {
			
		}
	}

}

