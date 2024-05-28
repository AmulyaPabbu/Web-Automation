package day32;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class WritingExcel {

	public static void main(String[] args) throws IOException {
		
		//create a file
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
		
		//create new workbook
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		//create new sheet
		XSSFSheet sheet=workbook.createSheet();
		
		//create single row and cell
		/*XSSFCell cell=sheet.createRow(0).createCell(1);
		cell.setCellValue("Welcome");
		*/
		
		//creating multiple rows and cells -hardcoding
		XSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("Welcome");
		row.createCell(1).setCellValue("12345");
		row.createCell(2).setCellValue("xyz");
		
		XSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("Welcome");
		row2.createCell(1).setCellValue("to");
		row2.createCell(2).setCellValue("java");
		
		//Asking user to enter data
		/*Scanner sc=new Scanner(System.in);
		
		for(int r=0;r<=3;r++)
		{
			XSSFRow currentRow=sheet.createRow(r);
			for(int c=0;c<2;c++)
			{
				//currentRow.createCell(c).setCellValue("Welcome"); //hardcoding
				
				//asking user to write data
				System.out.println("Enter a value: ");
				String value=sc.next();
				currentRow.createCell(c).setCellValue(value);
				
			}
		}
		*/
		
		//attach workbook to file
		workbook.write(file);
		
		workbook.close();
		file.close();
		System.out.println("Writing is done");	

	}

}
