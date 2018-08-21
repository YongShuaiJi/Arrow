package com.Haidian.WebEnergy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvidClass {
	public static Object[][] getData(String filePath, String fileName, String sheetName) throws IOException 
	  {
		  //根据参数传入的维护局文件路径和文件名称，组合数据文件的绝对路径
		  File file = new File(filePath+"\\"+fileName);
		  //创建一个FileInPutStream对象用于读取Excel表中的数据
		  FileInputStream inputstream = new FileInputStream(file);//FileInputStream相当于这个文件对象
		  //声明一个Workbook对象
		  Workbook Workbook = null;
		  //因为xls与xlsx不同的处理方式，所以分别处理
		  //获取文件扩展名字
		  String fileExtensionName = fileName.substring(fileName.indexOf("."));
		  /**
		   * 如果是xls类型的则：使用HSSFWorkbook
		   * 如果是xlsx类型的则：使用XSSFWorkbook
		   * */
		  if(fileExtensionName.equals(".xls")){
			  Workbook = new HSSFWorkbook(inputstream); 
		  }else if(fileExtensionName.equals(".xlsx")){
			  Workbook = new XSSFWorkbook(inputstream); 
		  }
		  Sheet sheet =  Workbook.getSheet(sheetName);
		  int rowCont = sheet.getLastRowNum()-sheet.getFirstRowNum();
		  List<Object[]> records = new ArrayList<Object[]>(); 
		  for(int i = 0; i < rowCont+1; i++)
		  {
			  Row row = sheet.getRow(i);
			  String fields[] = new String[row.getLastCellNum()];
			  for(int j = 0;j < row.getLastCellNum();j++)
			  {
				  fields[j] = row.getCell(j).getStringCellValue();
			  }
			  records.add(fields);
		  }
		  Object [][] results = new Object [records.size()][];
		  for(int i = 0;i<records.size();i++)
		  {
			  results[i] = records.get(i);
		  }
		  return results;
		}
}
