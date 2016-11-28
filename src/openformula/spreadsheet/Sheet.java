
package openformula.spreadsheet;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import openformula.spreadsheet.Cell.CellValueType;

public class Sheet
{
	private Spreadsheet spreadsheet;
	private String name;
	private Map<String, Cell> cells;
	
	public Sheet(Spreadsheet spreadsheet, String name)
	{
		this.spreadsheet = spreadsheet;
		this.name = name;
		this.cells = new HashMap<String, Cell>();
	}
	
	public String getName()
	{
		return name;
	}
	
	public Cell getCell(String cellPosition)
	{
		return cells.get(cellPosition);
	}
	
	public void setFormulaCell(String cellPosition, String formula, CellValueType returnType)
	{
		Cell formulaCell = new FormulaCell(spreadsheet, name, cellPosition, formula, returnType);
		cells.put(cellPosition, formulaCell);
	}
	
	// TODO: reduce code duplication in setConstCell()
	
	public void setConstCell(String cellPosition, Double numberValue)
	{
		Cell constCell = new ConstCell(numberValue);
		cells.put(cellPosition, constCell);
	}

	public void setConstCell(String cellPosition, String strValue)
	{
		Cell constCell = new ConstCell(strValue);
		cells.put(cellPosition, constCell);
	}

	public void setConstCell(String cellPosition, Boolean booleanValue)
	{
		Cell constCell = new ConstCell(booleanValue);
		cells.put(cellPosition, constCell);
	}

	public void setConstCell(String cellPosition, GregorianCalendar dateValue)
	{
		Cell constCell = new ConstCell(dateValue);
		cells.put(cellPosition, constCell);
	}
}
