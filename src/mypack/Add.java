package mypack;

import java.io.File;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Add 
{
  @Test
  public void add() throws Exception 
  {
	  File f=new File("Book1.xls");//file name java.io.file
		Workbook workboo1=Workbook.getWorkbook(f);//workbook related to .jxl
		Sheet sheet1=workboo1.getSheet(0);//0 means sheet1 and it's related to .jxl
		int nour=sheet1.getRows();// total numbner of rows will be stored into nour, open same excel file for writing
		int nouc=sheet1.getColumns();
		WritableWorkbook writebook1=Workbook.createWorkbook(f,workboo1);
		WritableSheet writesheet1=writebook1.getSheet(0);//0 means sheet1, data driven from 2nd row(index is 1), 1st rows have column has header names
		System.out.println("Table");
		for(int i=0;i<nour;i++)	//0 is row no 1, so we are taking values from row #2 in "i" place
		{
			int x=Integer.parseInt(sheet1.getCell(0, i).getContents());
			int y=Integer.parseInt(sheet1.getCell(1, i).getContents());
			//int y1=Integer.parseInt(sheet1.getCell(2, i).getContents());
			int z=x+y;
			Number n=new Number(nouc,i,z);/*number class belongs to "jxl", //2 means "Column C", i means row num starting 2 and, z is value will be stored in column c	*/
			writesheet1.addCell(n);
			System.out.println(x+" "+" "+y+" "+z);
		}
		//save excel file
		writebook1.write();
		writebook1.close();
		workboo1.close();		
  }
}
