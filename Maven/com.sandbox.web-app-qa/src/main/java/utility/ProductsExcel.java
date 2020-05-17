package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductsExcel {
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static FileInputStream fi;

	public static void findExcelSheet() {
		try {
			fi = new FileInputStream("src/test/resources\\ProductsList.xlsx");
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProdName(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(0);
		return cell.getStringCellValue();
	}
	
	public static String getProdId(int i) {
		DataFormatter formatter = new DataFormatter();
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(1);
		String id = formatter.formatCellValue(cell);
		return id;
	}
	public static String getProdDescription(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(2);
		return cell.getStringCellValue();
	}
	public static String getProdPrice(int i) {
		DataFormatter formatter = new DataFormatter();
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(3);
		String price = formatter.formatCellValue(cell);
		return price;
	}
	
	public static int getRowNumber() {
		try {
			return sheet.getLastRowNum() + 1;
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Error.");
			return -1;
		}
	}
	
	public static void closeFi() {
		try {
			fi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
}

}
