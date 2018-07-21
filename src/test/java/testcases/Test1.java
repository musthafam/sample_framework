package testcases;

import java.io.File;

import org.testng.annotations.Test;

import sample.ExcelUtils;

public class Test1 extends ExcelUtils{
	@Test
	public void test1() {
		String filePath = System.getProperty("user.dir")+File.separator+
				"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Test.xlsx";
		ExcelUtils.setExcelPath(filePath, "Sheet1");
		String cellVal = ExcelUtils.getCellData(1, 1);
		System.out.println("Cell Value"+cellVal);
		String cellVa2 = ExcelUtils.getCellData("Test2", "Password");
		System.out.println("Cell Value"+cellVa2);
	}

}
