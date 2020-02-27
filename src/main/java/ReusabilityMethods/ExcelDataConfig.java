	package ReusabilityMethods;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;

	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelDataConfig {
		
		static XSSFWorkbook wb;
		static XSSFSheet sheet; 
		
		static String filepath1="C:\\Users\\ruchi\\git\\Regal_Selenium\\Demo1.xlsx";
		static String excelPath="C:\\Users\\ruchi\\git\\Regal_Selenium\\TestData(2).xlsx";
	   
		
	      public String getData(String sheetname,int row, int column)
	      {
	    	  try {
	    		  
	  			File src=new File(excelPath); //Define path
	  			FileInputStream Fis=new FileInputStream(src);//Class which will accept this file source_Load it in form of bites
	  			wb=new XSSFWorkbook(Fis);//Load full Excel(WB)
	  			
	      		  
	      	  }
	      		  catch (Exception e) 
	          	  {
	      		 
	      			System.out.println(e.getMessage());
	      		  }
	      	sheet=wb.getSheet(sheetname);
	      	String data=sheet.getRow(row).getCell(column).getStringCellValue();
	      	return data;
	      
	      }
		
	      public String ReadDate(String sheetname,int row, int column)
	      {
	    	  try {
	    		  
	    		  File src1=new File(filepath1); //Define path
	    			FileInputStream Fread=new FileInputStream(src1);//Class which will accept this file source_Load it in form of bites
	    			wb=new XSSFWorkbook(Fread);//Load full Excel(WB)
	    			
	    			     		  
	      	  }
	      		  catch (Exception e) 
	          	  {
	      		 
	      			System.out.println(e.getMessage());
	      		  }
	      	sheet=wb.getSheet(sheetname);
	      	String data=sheet.getRow(row).getCell(column).getStringCellValue();
	      	return data;
	      
	      }
		
	      
		public String write(String Sheetname,int rowcount,int columncount,String value) throws Throwable
		{ 
			
			
			FileInputStream inp= new FileInputStream(filepath1); 
		    XSSFWorkbook wb = new XSSFWorkbook(inp); 
		    XSSFSheet sheet = wb.getSheet(Sheetname); 
		    XSSFRow row1 = sheet.createRow(rowcount);
			XSSFCell r1c1 = row1.createCell(columncount);
			r1c1.setCellValue(value);
		    System.out.println("sheet name is"+ sheet);
		    
		
		   
		    // Now this Write the output to a file 
		    FileOutputStream fileOut = new FileOutputStream(filepath1); 
		    wb.write(fileOut); 
		    fileOut.close();
			return value; 
		}
		
		

	}