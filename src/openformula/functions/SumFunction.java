
package openformula.functions;

import java.util.Vector;

import openformula.ast.AstNode;
import openformula.interpreter.AstNodeEvaluatorProxy;
import openformula.value.Value;
import openformula.value.Value.ValueType;

public class SumFunction extends Function
{
	@Override
	public Value calc(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		Double sum = 0.0;
		
		for (AstNode arg : args)
		{
			Value argValue = astNodeEvaluatorProxy.evaluateAndDereference(arg);
			argValue = getValueConverter().convert(argValue, ValueType.NUMBER);
			
			if (argValue.getType() == ValueType.ERROR)
			{
				return argValue;
			}
			
			sum += argValue.getAsNumber();
		}
		
		Value retValue = Value.createNumberValue(sum);
		return retValue;
	}
}
