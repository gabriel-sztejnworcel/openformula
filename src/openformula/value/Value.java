
package openformula.value;

import java.util.GregorianCalendar;

public class Value
{
	public enum ValueType
	{
		NUMBER,
		STRING,
		DATE,
		BOOLEAN,
		REFERENCE,
		ERROR
	}

	private ValueType type;
	private Object val;
	
	public static Value createErrorValue(String errorStr)
	{
		ErrorValue error = new ErrorValue(errorStr);
		Value value = new Value(error);
		return value;
	}
	
	public static Value createReferenceValue(String sheetName, String cellPosition)
	{
		Reference ref = new Reference(sheetName, cellPosition);
		Value value = new Value(ref);
		return value;
	}
	
	public static Value createNumberValue(Double val)
	{
		return new Value(val);
	}
	
	public static Value createStringValue(String val)
	{
		return new Value(val);
	}

	public static Value createDateValue(GregorianCalendar val)
	{
		return new Value(val);
	}

	public static Value createBooleanValue(Boolean val)
	{
		return new Value(val);
	}

	private Value(Double val)
	{
		this.type = ValueType.NUMBER;
		this.val = val;
	}
	
	private Value(String val)
	{
		this.type = ValueType.STRING;
		this.val = val;
	}
	
	private Value(GregorianCalendar val)
	{
		this.type = ValueType.DATE;
		this.val = val;
	}
	
	private Value(Boolean val)
	{
		this.type = ValueType.BOOLEAN;
		this.val = val;
	}

	private Value(Reference val)
	{
		this.type = ValueType.REFERENCE;
		this.val = val;
	}

	private Value(ErrorValue val)
	{
		this.type = ValueType.ERROR;
		this.val = val;
	}
	
	public ValueType getType()
	{
		return type;
	}
	
	public Double getAsNumber()
	{
		return (Double)val;
	}

	public String getAsString()
	{
		return (String)val;
	}

	public GregorianCalendar getAsDate()
	{
		return (GregorianCalendar)val;
	}

	public Boolean getAsBoolean()
	{
		return (Boolean)val;
	}

	public Reference getAsReference()
	{
		return (Reference)val;
	}

	public ErrorValue getAsError()
	{
		return (ErrorValue)val;
	}
}
