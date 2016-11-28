
package openformula.spreadsheet;

import java.util.GregorianCalendar;

import openformula.value.Value;

public class ConstCell extends Cell
{
	public ConstCell(Double numberValue)
	{
		super(CellValueType.NUMBER);
		this.value = Value.createNumberValue(numberValue);
	}
	
	public ConstCell(String strValue)
	{
		super(CellValueType.STRING);
		this.value = Value.createStringValue(strValue);
	}

	public ConstCell(Boolean booleanValue)
	{
		super(CellValueType.BOOLEAN);
		this.value = Value.createBooleanValue(booleanValue);
	}

	public ConstCell(GregorianCalendar dateValue)
	{
		super(CellValueType.DATE);
		this.value = Value.createDateValue(dateValue);
	}

	@Override
	public void calculate()
	{
		// do nothing, value is assigned in c'tor
	}
}
