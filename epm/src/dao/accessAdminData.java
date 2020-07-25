package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Admin;

public class accessAdminData {
	public accessAdminData() {
	}

	static int cellCount = 0;

	// Method to write Data to admin Excel file
	public int writeDataToAdmin(Admin admin, int rowCount) {

		try {
			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\admin.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.createRow(rowCount += 1);
			Cell cell = row.createCell(0);
			cell.setCellValue(admin.adminId);
			cell = row.createCell(1);
			cell.setCellValue(admin.adminName);
			cell = row.createCell(2);
			cell.setCellValue(admin.adminPassword);
			inputStream.close();
			FileOutputStream outputStream = new FileOutputStream("G:\\a\\week4\\final project\\admin.xlsx");
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
			return rowCount;
		} catch (Exception e) {
			System.out.print(e);
			return 0;
		}

	}

	// Method to read data from admin Excel file
	public void readDataFromAdmin() {
		try {

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\admin.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowi = sheet.iterator();
			while (rowi.hasNext()) {
				Row row = rowi.next();
				Iterator<Cell> celli = ((Row) row).iterator();
				while (celli.hasNext()) {

					Cell cell = celli.next();
					System.out.print(cell + " ");
				}
				System.out.println();

			}

			workbook.close();
			inputStream.close();

		} catch (Exception e) {
			System.out.print(e);
		}

	}

}
