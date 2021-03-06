package model;




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


public class accessEmployeeData {
	public accessEmployeeData(){
		
	}
	
	static int cellCount=0; 
		
	
		public int writeDataToEmployee(Employee emp,int rowCount ) {
			try {
			 FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\admin.xlsx"));
	         Workbook workbook = new XSSFWorkbook(inputStream);
	         
	         Sheet sheet=workbook.getSheetAt(0);
	         Row row = sheet.createRow(rowCount+=1);
	         Cell cell=row.createCell(cellCount+=1);
	         
	         cell.setCellValue(emp.id);
	         cell=row.createCell(cellCount+=1);
	         
	         cell.setCellValue(emp.name);
	         cell=row.createCell(cellCount+=1);
	         
	         cell.setCellValue(emp.dateOfBirth);
	         cell=row.createCell(cellCount+=1);
	         
	         cell.setCellValue(emp.experiance);
	         cell=row.createCell(cellCount+=1);
	         
	         cell.setCellValue(emp.dept);
	         cell=row.createCell(cellCount+=1);
	         
	         
	         cell.setCellValue(emp.password);
	        
	         row = sheet.createRow(rowCount+=1);
		     List<Expenses> expense=new ArrayList<>();
		     expense=emp.expenses;
		         for(Expenses exp :expense) {
		         cell=row.createCell(cellCount+=1);
		         cell.setCellValue(exp.expenseName);
		         cell=row.createCell(cellCount+=1);
		         cell.setCellValue(exp.expenseAmount);
		         cell=row.createCell(cellCount+=1);
		         cell.setCellValue(exp.expenseDescription);
		         }
	      
	         inputStream.close();
	         FileOutputStream outputStream = new FileOutputStream("G:\\a\\week4\\final project\\admin.xlsx");
	         workbook.write(outputStream);
	         workbook.close();
	         outputStream.close();
	       return rowCount;
		}
		catch(Exception e) {
			System.out.print(e);
			return 0;
		}
	         
		}
		public void readDataFromEmployee() {
			try {
				
				 FileInputStream inputStream = new FileInputStream(new File("G:\\a\\week4\\final project\\admin.xlsx"));
		         Workbook workbook = new XSSFWorkbook(inputStream);
		         Sheet sheet=workbook.getSheetAt(0);
		         Iterator<Row> rowi = sheet.iterator();
		         while(rowi.hasNext())
		         {
		        	 Row row=rowi.next();
		        	 Iterator <Cell> celli=((Row) row).iterator();
		        	 while(celli.hasNext()) {
		        		
		        		 Cell cell = celli.next();
		        		 System.out.print(cell+" ");
		        	 }
		        	 System.out.println();
		        	 
		        	 
		         }
		       
		       
		         workbook.close();
		         inputStream.close();
		        
			}
			catch(Exception e) {
				System.out.print(e);
			}
			
		}
		
		




}

