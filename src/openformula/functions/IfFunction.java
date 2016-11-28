
package openformula.functions;

import java.util.Vector;

import openformula.ast.AstNode;
import openformula.interpreter.AstNodeEvaluatorProxy;
import openformula.value.Value;
import openformula.value.Value.ValueType;

public class IfFunction extends Function
{
	@Override
	public boolean validateArgs(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		return args.size() >= 1 && args.size() <= 3;
	}

	@Override
	public Value calc(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		Value condition = astNodeEvaluatorProxy.evaluateAndDereference(args.get(0));
		condition = getValueConverter().convert(condition, ValueType.BOOLEAN);
		
		if (condition.getType() == ValueType.ERROR)
		{
			return condition;
		}
		
		Value retValue = null;
		
		if (condition.getAsBoolean())
		{
			if (args.size() >= 2)
			{
				retValue = astNodeEvaluatorProxy.evaluate(args.get(1));
			}
			else
			{
				retValue = Value.createBooleanValue(true);
			}
		}
		else
		{
			if (args.size() >= 3)
			{
				retValue = astNodeEvaluatorProxy.evaluate(args.get(2));
			}
			else
			{
				retValue = Value.createBooleanValue(false);
			}
		}
		
		return retValue;
	}
}
