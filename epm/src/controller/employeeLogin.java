package controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class employeeLogin {

	@SuppressWarnings("finally")

	// Method to validate Employee login credentials and Never Used
	public boolean validateEmployee(int id, String password) {
		int empid = 0;
		String emppassword = "";
		try {

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\emp.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowi = sheet.iterator();
			Cell cell;

			while (rowi.hasNext()) {
				Row row = rowi.next();
				cell = row.getCell(0);
				empid = (int) cell.getNumericCellValue();
				cell = row.getCell(5);
				emppassword = cell.getStringCellValue();
				if (empid == id && emppassword.equals(password)) {
					break;
				}

			}

			workbook.close();
			inputStream.close();

		} catch (Exception e) {
			System.out.print(e);
		} finally {
			if (empid == id && emppassword.equals(password)) {
				return true;
			} else {
				return false;
			}
		}

	}

}
