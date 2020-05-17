package utility;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Register30 {
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static FileInputStream fi;

	public static void findExcelSheet() {
		try {
			fi = new FileInputStream("src/test/resources\\Registration30Users.xlsx");
			wb = new XSSFWorkbook(fi);
			sheet = wb.getSheetAt(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getUserName(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(0);
		return cell.getStringCellValue();
	}
	
	public static String getEMail(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(1);
		return cell.getStringCellValue();
	}

	public static String getPassword(int i) {
		Row row = sheet.getRow(i);
		Cell cell = row.getCell(2);
		return cell.getStringCellValue();
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
