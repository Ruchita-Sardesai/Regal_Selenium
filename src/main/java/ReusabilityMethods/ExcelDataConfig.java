package ReusabilityMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet; 
	
	
      public ExcelDataConfig(String excelPath)
      {
    	  try {
    		  
			File src=new File(excelPath); //Define path
			FileInputStream Fis=new FileInputStream(src);//Class which will accept this file source_Load it in form of bites
			wb=new XSSFWorkbook(Fis);//Load full Excel(WB)
			
			FileOutputStream fout=new FileOutputStream(src);
		    wb.write(fout);
		    
		    wb.close();
			
    	      }
    	  catch (Exception e) 
    	  {
		 
			System.out.println(e.getMessage());
		  }
    	  
      }


    public String getData(int sheetNumber,int row, int column)
    {
    	sheet= wb.getSheetAt(sheetNumber);
    	String data=sheet.getRow(row).getCell(column).getStringCellValue();
    	return data;
    
    }
    
    public void WriteData(int sheetNumber,int row, int column,String Setcellvalue)
    {
    	
    	   	
    	sheet= wb.getSheetAt(sheetNumber);
    	sheet.getRow(row).createCell(column).setCellValue(Setcellvalue);
    	
    
    }
}