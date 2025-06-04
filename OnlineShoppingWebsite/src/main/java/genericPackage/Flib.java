package genericPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {

	public String readPropertyData(String prop_Path,String key) throws IOException {
	FileInputStream fis = new FileInputStream(prop_Path);
	 Properties prop = new Properties();
	 prop.load(fis);
	String browserValue = prop.getProperty(key);
	return browserValue;
	}
	
	public String readExcelData(String excel_Path,String sheet_name, int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excel_Path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheet_name);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		String data = cell.getStringCellValue();
		return data;
		
	}
	
	public int getLastRowCount(String excel_Path,String sheet_name) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excel_Path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheet_name);
		int rc = sheet.getLastRowNum();
		return rc;
	}
	
	public int getRandomNumber()
	{
		Random random = new Random();
		int data = random.nextInt(1000);
		return data;
	}
	
	public String readNumericExcelData(String excel_Path,String sheet_name, int rowno,int cellno) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excel_Path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheet_name);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		long data =(long) cell.getNumericCellValue();
		
		String data1 = String.valueOf(data);
		return data1;
		
				
	}
	
}
