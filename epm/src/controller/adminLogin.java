package controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class adminLogin {
//Method to validate admin login credentials
	public boolean validateAdmin(String id, String password) {
		try {

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\admin.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			String storedid = cell.getStringCellValue();
			storedid.trim();
			cell = row.getCell(2);
			String storedpass = cell.getStringCellValue();
			storedpass.trim();

			workbook.close();
			inputStream.close();
			if (id.equals(storedid) && password.equals(storedpass))
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
