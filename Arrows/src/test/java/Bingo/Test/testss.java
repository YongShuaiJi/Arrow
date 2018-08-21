package Bingo.Test;

import Bingo.tool.AutoDataExcel;

public class testss {
	public static void main(String[] args) {
		String file = "C:\\Users\\Administrator\\Desktop\\11111.xlsx";
		String SheetName = "Sheet1";
		AutoDataExcel a = new AutoDataExcel();
		a.setFile(file);
		a.setSheetName(SheetName);
		String[][] str = a.GetDataEnterpriseinfo();
		for(String[] sing1 : str) 
		{
			for(String strs : sing1) {
				System.out.println(strs);
			}
		}
	}

}
