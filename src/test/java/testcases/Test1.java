package testcases;

import org.testng.annotations.Test;

import sample.ExcelUtils;

public class Test1 extends ExcelUtils{
	@Test
	public void test1() {
		ExcelUtils.setExcelPath("C:/Users/ai/workspace_new/test/src/test/resources/Test.xlsx", "Sheet1");
		String cellVal = ExcelUtils.getCellData(1, 1);
		System.out.println("Cell Value"+cellVal);
		String cellVa2 = ExcelUtils.getCellData("Test2", "Password");
		System.out.println("Cell Value"+cellVa2);
	}

}
