package check;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class tp {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream input= new FileInputStream(new File("G:\\a\\week4\\final project\\admin.xlsx"));
		try {
		Workbook wb = new XSSFWorkbook(input); 
		Sheet sheet1 = wb.getSheetAt(0);
		//Row row=sheet1.createRow(0);
		//Cell cell= row.createCell(0);
		Row row=sheet1.getRow(0);
		Cell cell=row.getCell(0);
		int abc=(int) cell.getNumericCellValue();
		cell=row.getCell(1);
		String str=cell.getStringCellValue();
		cell=row.getCell(2);
		String as=cell.getStringCellValue();
	System.out.print(" "+abc+" "+ str+" "+as);
		}
		catch( Exception e){
			System.out.println("Error"+e);
		}
		
	}


	}


