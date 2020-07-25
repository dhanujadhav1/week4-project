package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.Employee;
import model.Expenses;

public class accessEmployeeFile {
//Method to Write Data to Employee Excel Sheet 
	public int writeDataToEmployee(Employee emp, int rowCount) {

		try {

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\emp.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			int cellCount = -1;
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.createRow(rowCount += 1);
			Cell cell = row.createCell(cellCount += 1);

			cell.setCellValue(emp.id);
			cell = row.createCell(cellCount += 1);

			cell.setCellValue(emp.name);
			cell = row.createCell(cellCount += 1);

			cell.setCellValue(emp.dateOfBirth);
			cell = row.createCell(cellCount += 1);

			cell.setCellValue(emp.experiance);
			cell = row.createCell(cellCount += 1);

			cell.setCellValue(emp.dept);
			cell = row.createCell(cellCount += 1);
			cell.setCellValue(emp.password);
			// to store expenses to the employee
			int cellc = cellCount;
			row = sheet.createRow(rowCount += 1);
			cell = row.createCell(cellc += 1);
			cell.setCellValue("Expense Reason");
			cell = row.createCell(cellc += 1);
			cell.setCellValue("Expense Amount");
			cell = row.createCell(cellc += 1);
			cell.setCellValue("Expense Description");
			cellc = cellCount;
			List<Expenses> expense = new ArrayList<>();
			expense = emp.expenses;
			// Adding multiple expenses to list
			for (Expenses exp : expense) {
				row = sheet.createRow(rowCount += 1);
				cell = row.createCell(cellc += 1);
				cell.setCellValue(exp.expenseName);
				cell = row.createCell(cellc += 1);
				cell.setCellValue(exp.expenseAmount);
				cell = row.createCell(cellc += 1);
				cell.setCellValue(exp.expenseDescription);
				cellc = cellCount;
			}

			FileOutputStream outputStream = new FileOutputStream("G:\\a\\week4\\final project\\emp.xlsx");
			workbook.write(outputStream);
			inputStream.close();
			workbook.close();
			outputStream.close();
			return rowCount;
		} catch (Exception e) {
			System.out.print(e);
			return rowCount;
		}

	}

//Method to read details of all employess and print on console
	public void readDataToPrintFromEmployee() {
		try {
			float id = 0;
			String operation;

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\emp.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Cell cell;
			Iterator<Row> rowi = sheet.iterator();
			while (rowi.hasNext()) {
				Row row = rowi.next();
				Iterator<Cell> celli = row.iterator();
				while (celli.hasNext()) {
					cell = celli.next();
					System.out.print(cell + "       ");
				}
				System.out.print("");
				System.out.println();

			}

			workbook.close();
			inputStream.close();

		} catch (Exception e) {
			System.out.print(e);
		}

	}

// method to search employee by name
	public void searchEmployeeByName(String name) {
		try {

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\emp.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowi = sheet.iterator();
			Cell cell;
			String value;
			while (rowi.hasNext()) {
				Row row = rowi.next();
				cell = row.getCell(1);
				if (cell != null) {
					value = cell.getStringCellValue();
					value.trim();
					if (value != null && value.equals(name)) {
						Iterator<Cell> cellins = row.iterator();

						while (cellins.hasNext()) {

							Cell cell1 = cellins.next();
							System.out.print(cell1 + " ");
						}
						System.out.println();

					}
				}
			}
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			System.out.print(e);
		}

	}

// Method to search Employee By Department
	public void searchEmployeeByDept(String name) {
		try {

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\emp.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowi = sheet.iterator();
			Cell cell;
			String value;
			while (rowi.hasNext()) {
				Row row = rowi.next();
				cell = row.getCell(4);
				if (cell != null) {
					value = cell.getStringCellValue();
					value.trim();
					if (value != null && value.equals(name)) {
						Iterator<Cell> cellins = row.iterator();

						while (cellins.hasNext()) {

							Cell cell1 = cellins.next();
							System.out.print(cell1 + " ");
						}
						System.out.println();

					}
				}
			}
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			System.out.print(e);
		}

	}

	// Method to search employee by id

	public void getEmployeeById(int id) {
		try {

			FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\emp.xlsx"));
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowi = sheet.iterator();
			Cell cell;
			double value1;
			int value;
			while (rowi.hasNext()) {
				Row row = rowi.next();
				cell = row.getCell(0);
				if (cell != null && cell.getClass().getName() != "String") {
					value1 = cell.getNumericCellValue();
					value = (int) value1;
					if (value == id) {
						Iterator<Cell> cellins = row.iterator();

						while (cellins.hasNext()) {

							Cell cell1 = cellins.next();
							System.out.print(cell1 + " ");
						}
						System.out.println();

					}
				}
			}
			workbook.close();
			inputStream.close();
		} catch (Exception e) {
			System.out.print(e);
		}

	}

}
