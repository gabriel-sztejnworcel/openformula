
package test;

import openformula.spreadsheet.Cell;
import openformula.spreadsheet.Sheet;
import openformula.spreadsheet.Spreadsheet;

public class Test
{
	public static void main(String[] args)
	{
		testOds();
	}
	
	private static void testOds()
	{
		try
		{
			Spreadsheet spreadsheet = Spreadsheet.loadOds("input/sample1.ods");
			Sheet sheet1 = spreadsheet.getSheet("Sheet1");
			
			Cell D1 = sheet1.getCell("D1");
			D1.calculate();
			System.out.println(D1.getAsNumber());

			Cell B2 = sheet1.getCell("B2");
			B2.calculate();
			System.out.println(B2.getAsNumber());

			Cell C2 = sheet1.getCell("C2");
			C2.calculate();
			System.out.println(C2.getAsNumber());

			Cell D2 = sheet1.getCell("D2");
			D2.calculate();
			System.out.println(D2.getAsNumber());

			Cell A3 = sheet1.getCell("A3");
			A3.calculate();
			System.out.println(A3.getAsString());
			
			sheet1.setConstCell("A1", 15.0);
			D1.calculate();
			System.out.println(D1.getAsNumber());
			A3.calculate();
			System.out.println(A3.getAsString());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
