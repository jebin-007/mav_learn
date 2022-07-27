package learnApachePoi;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XcelWriteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employees");
		
		TreeMap<String, Object[]> data = new TreeMap<String, Object[]>();
		
		data.put("1",new Object[] {"ID","First Name","Last Name"});
		data.put("2",new Object[] {1,"Jebin","Joseph"});
		data.put("3",new Object[] {2,"Tony","Simon"});
		data.put("4",new Object[] {3,"Mathew","Philiph"});
		data.put("5",new Object[] {4,"Dennis","Mathew"});
		data.put("6",new Object[] {5,"Kevin","Roger"});
		
		Set<String> keyset = data.keySet();
		int rowNum = 0;
		for(String k:keyset) {
			Row row = sheet.createRow(rowNum++);
			Object[] objArray = data.get(k);
			int cellNum = 0;
			for(Object obj:objArray) {
				Cell cell = row.createCell(cellNum++);
				if(obj instanceof Integer) {
					cell.setCellValue((Integer) obj);
				}
				else if (obj instanceof String) {
					cell.setCellValue((String) obj);
				}
				}
				
			}
		try {
			FileOutputStream jjOut = new FileOutputStream(new File("Data.xlsx"));
			workbook.write(jjOut);
			System.out.println("File created successfully!!");
			jjOut.close();
		
		}catch ( Exception e) {
			System.out.println("File creation error!!");
		}

	}

}
