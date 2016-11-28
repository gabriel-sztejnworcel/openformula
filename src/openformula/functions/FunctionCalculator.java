
package openformula.functions;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import openformula.ast.AstNode;
import openformula.interpreter.AstNodeEvaluatorProxy;
import openformula.value.ErrorValue;
import openformula.value.Value;

public class FunctionCalculator
{
	private static FunctionCalculator instance = null;
	
	public static FunctionCalculator getInstance()
	{
		if (instance == null)
		{
			instance = new FunctionCalculator();
			initFunctions();
		}
		
		return instance;
	}

	private static void initFunctions()
	{
		instance.registerFunction("SUM", new SumFunction());
		instance.registerFunction("IF", new IfFunction());
		instance.registerFunction("YEAR", new YearFunction());
		instance.registerFunction("MONTH", new MonthFunction());
		instance.registerFunction("DAY", new DayFunction());
	}

	private Map<String, Function> functions;
	
	private FunctionCalculator()
	{
		functions = new HashMap<String, Function>();
	}
	
	public Value callFunction(String functionName, Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		Value retValue = null;
		Function function = functions.get(functionName.toUpperCase());
		
		if (function == null)
		{
			retValue = Value.createErrorValue(ErrorValue.NAME);
		}
		else
		{
			retValue = function.call(args, astNodeEvaluatorProxy);
		}
		
		return retValue;
	}
	
	private void registerFunction(String functionName, Function function)
	{
		functions.put(functionName.toUpperCase(), function);
	}
}
