
package openformula.functions;

import java.util.Vector;

import openformula.ast.AstNode;
import openformula.interpreter.AstNodeEvaluatorProxy;
import openformula.value.ErrorValue;
import openformula.value.Value;
import openformula.value.ValueConverter;

public abstract class Function
{
	private ValueConverter valueConverter;
	
	public Function()
	{
		valueConverter = new ValueConverter();
	}
	
	public Value call(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		if (!validateArgs(args, astNodeEvaluatorProxy))
		{
			Value value = Value.createErrorValue(ErrorValue.NAME);
			return value;
		}
		
		return calc(args, astNodeEvaluatorProxy);
	}
	
	public boolean validateArgs(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		return true;
	}
	
	public abstract Value calc(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy);
	
	protected ValueConverter getValueConverter()
	{
		return valueConverter;
	}
}
