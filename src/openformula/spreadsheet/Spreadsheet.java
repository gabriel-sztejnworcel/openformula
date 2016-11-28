
package openformula.spreadsheet;

import java.util.HashMap;
import java.util.Map;

public class Spreadsheet
{
	private Map<String, Sheet> sheets;
	
	public static Spreadsheet loadOds(String path) throws Exception
	{
		return new SpreadsheetLoader().loadOds(path);
	}
	
	public Spreadsheet()
	{
		sheets = new HashMap<String, Sheet>();
	}
	
	public Sheet addSheet(String sheetName)
	{
		Sheet sheet = getSheet(sheetName);
		
		if (sheet == null)
		{
			sheet = new Sheet(this, sheetName);
			sheets.put(sheetName, sheet);
		}
		
		return sheet;
	}
	
	public Sheet getSheet(String sheetName)
	{
		Sheet sheet = sheets.get(sheetName);
		return sheet;
	}
}
