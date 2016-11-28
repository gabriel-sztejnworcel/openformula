
package openformula.functions;

import java.util.GregorianCalendar;
import java.util.Vector;

import openformula.ast.AstNode;
import openformula.interpreter.AstNodeEvaluatorProxy;
import openformula.value.Value;
import openformula.value.Value.ValueType;

public abstract class DateSplitFunction extends Function
{
	@Override
	public boolean validateArgs(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		return args.size() == 1;
	}
	
	protected Value splitDate(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy, int dateFieldType)
	{
		Value value = astNodeEvaluatorProxy.evaluateAndDereference(args.get(0));
		
		if (value.getType() != ValueType.ERROR && value.getType() != ValueType.DATE)
		{
			value = getValueConverter().convert(value, ValueType.DATE);
		}
		
		if (value.getType() == ValueType.ERROR)
		{
			return value;
		}
		
		Integer dateField = value.getAsDate().get(dateFieldType);
		
		if (dateFieldType == GregorianCalendar.MONTH)
		{
			++dateField;
		}
		
		Value retValue = Value.createNumberValue(dateField.doubleValue());
		return retValue;
	}
}
