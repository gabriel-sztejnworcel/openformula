
package openformula.spreadsheet;

import java.util.GregorianCalendar;

import openformula.value.Value;
import openformula.value.Value.ValueType;

public abstract class Cell
{
	public enum CellValueType
	{
		EMPTY,
		NUMBER,
		STRING,
		BOOLEAN,
		DATE
	}
	
	private CellValueType type;
	protected Value value;
	
	public Cell(CellValueType type)
	{
		this.type = type;
		this.value = null;
	}
	
	public CellValueType getType()
	{
		return type;
	}
	
	public void checkToCalculate()
	{
		if (value == null)
		{
			calculate();
		}
	}
	
	public abstract void calculate();
	
	public Double getAsNumber()
	{
		checkToCalculate();
		return value.getAsNumber();
	}

	public String getAsString()
	{
		checkToCalculate();
		return value.getAsString();
	}

	public Boolean getAsBoolean()
	{
		checkToCalculate();
		return value.getAsBoolean();
	}

	public GregorianCalendar getAsDate()
	{
		checkToCalculate();
		return value.getAsDate();
	}
	
	public String getError()
	{
		return value.getAsError().getError();
	}
	
	public boolean isError()
	{
		checkToCalculate();
		return value.getType() == ValueType.ERROR;
	}
}
