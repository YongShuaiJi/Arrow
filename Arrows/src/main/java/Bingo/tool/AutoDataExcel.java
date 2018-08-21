package Bingo.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AutoDataExcel {
	private String fileName;
	private String SheetName;
	private List<String[]> list = new ArrayList<String[]>();
	public void setFile(String fileName) {
		this.fileName=fileName;
	}
	public void setSheetName(String SheetName) {
		this.SheetName=SheetName;
	}
	//获取传过来的路径，生成File对象
	private FileInputStream fileinput = null;
	private File file = new File(fileName);
	public String[][] GetDataEnterpriseinfo(){
		try {
			fileinput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook workbook = null;
		String ExcelNameOf = fileName.substring(fileName.indexOf("."));
		try {
			if(ExcelNameOf.equals(".xlsx")){
				workbook = new XSSFWorkbook(fileinput);
			}else if(ExcelNameOf.equals(".xls")){
				workbook = new HSSFWorkbook(fileinput);
			}else{
				System.out.println("文件格式不正确");
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(SheetName);
		int Number=sheet.getLastRowNum()-sheet.getFirstRowNum();
		return StringArray(sheet,Number);
	}
	
	private String[][] StringArray(Sheet sheet,int Number) {
		
		for(int i=1;i<Number+1;i++){
			Row row = sheet.getRow(i);
			String[] strings = new String[row.getLastCellNum()];
			for(int x=0;x<row.getLastCellNum();x++){
				strings[x] = row.getCell(x).getStringCellValue();
			}
			list.add(strings);
		}
		String[][] StringArray = new String[list.size()][];
		for(int y=0;y<list.size();y++){
			StringArray[y] = list.get(y);
		}
		return StringArray;
	}
	private String[][] StringArray(Sheet sheet,int Number,String str) {

		List<String[]> list2 = new ArrayList<String[]>();
		for(int i=0;i<Number+1;i++) {
			Row row = sheet.getRow(i);//获取行对象
			String[] strings = new String[row.getLastCellNum()];//
			for(int x=0;x<row.getLastCellNum();x++) {
				strings[x] = row.getCell(x).getStringCellValue();
			}
			list.add(strings);
		}
			int  o =list.size();
			String[] sing = new String[100];
			int e = -1;
			for(int i = 0;i<list.size();i++) {
				String str1 = list.get(i)[0];
				for(int s = 0;s<list.size();s++) {
					String str2 = list.get(s)[1];
					String str3 = str+"-"+str2;
					e= e +1;
					sing[e]=str3;
					System.out.println(str3);
				}
				list2.add(sing);
			}
	
		String[][] StringArray = new String[list2.size()][];
		for(int y=0;y<list2.size();y++){
			StringArray[y] = list2.get(y);
		}
		return StringArray;
	}
}
