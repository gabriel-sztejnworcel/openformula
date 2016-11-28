
package openformula.value;

import openformula.env.Config;
import openformula.util.Convert;
import openformula.value.Value.ValueType;

public class ValueConverter
{
	public Value convert(Value value, ValueType destType)
	{
		if (isInvalidConversion(value, destType))
		{
			Value retValue = Value.createErrorValue(ErrorValue.VALUE);
			return retValue;
		}
		
		Value retValue = null;
		
		switch (destType)
		{
		case NUMBER:
			retValue = convertToNumber(value);
			break;
			
		case STRING:
			retValue = convertToString(value);
			break;
			
		case DATE:
			retValue = convertToDate(value);
			break;
			
		case BOOLEAN:
			retValue = convertToBoolean(value);
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		return retValue;
	}
	
	boolean isInvalidConversion(Value value, ValueType destType)
	{
		boolean invalidConversion = false;
		
		if (value.getType() == ValueType.REFERENCE ||
			value.getType() == ValueType.ERROR ||
			destType == ValueType.REFERENCE ||
			destType == ValueType.ERROR)
		{
			invalidConversion = true;
		}
		
		return invalidConversion;
	}

	private Value convertToBoolean(Value value)
	{
		Value retValue = null;
		
		switch (value.getType())
		{
		case NUMBER:
			retValue = Value.createBooleanValue(value.getAsNumber() != 0.0);
			break;
			
		case STRING:
			retValue = Value.createBooleanValue(!value.getAsString().isEmpty());
			break;
			
		case DATE:
			retValue = Value.createBooleanValue(!value.getAsDate().equals(Config.getInstance().getEpoch()));
			break;
			
		case BOOLEAN:
			retValue = value;
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		return retValue;
	}

	private Value convertToDate(Value value)
	{
		Value retValue = null;
		
		try
		{
			switch (value.getType())
			{
			case NUMBER:
				retValue = Value.createDateValue(Convert.numberToDate(value.getAsNumber()));
				break;
				
			case STRING:
				retValue = Value.createDateValue(Convert.stringToDate(value.getAsString(), Config.getInstance().getDateFormat()));
				break;
				
			case DATE:
				retValue = value;
				break;
				
			case BOOLEAN:
				retValue = Value.createDateValue(Convert.numberToDate(value.getAsBoolean() ? 1.0 : 0.0));
				break;
				
			default:
				throw new UnsupportedOperationException();
			}
		}
		catch (Exception e)
		{
			retValue = Value.createErrorValue(ErrorValue.VALUE);
		}
		
		return retValue;
	}

	private Value convertToString(Value value)
	{
		Value retValue = null;
		
		switch (value.getType())
		{
		case NUMBER:
			retValue = Value.createStringValue(value.getAsNumber().toString());
			break;
			
		case STRING:
			retValue = value;
			break;
			
		case DATE:
			retValue = Value.createStringValue(Convert.dateToString(value.getAsDate(), Config.getInstance().getDateFormat()));
			break;
			
		case BOOLEAN:
			retValue = Value.createStringValue(value.getAsBoolean() ? "TRUE" : "FALSE");
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		return retValue;
	}

	private Value convertToNumber(Value value)
	{
		Value retValue = null;
		
		try
		{
			switch (value.getType())
			{
			case NUMBER:
				retValue = value;
				break;
				
			case STRING:
				retValue = Value.createNumberValue(Double.parseDouble(value.getAsString()));
				break;
				
			case DATE:
				retValue = Value.createNumberValue(Convert.dateToNumber(value.getAsDate()));
				break;
				
			case BOOLEAN:
				retValue = Value.createNumberValue(value.getAsBoolean() ? 1.0 : 0.0);
				break;
				
			default:
				throw new UnsupportedOperationException();
			}
		}
		catch (Exception e)
		{
			retValue = Value.createErrorValue(ErrorValue.VALUE);
		}
		
		return retValue;
	}
}
