
package openformula.functions;

import java.util.GregorianCalendar;
import java.util.Vector;

import openformula.ast.AstNode;
import openformula.interpreter.AstNodeEvaluatorProxy;
import openformula.value.Value;

public class DayFunction extends DateSplitFunction
{
	@Override
	public Value calc(Vector<AstNode> args, AstNodeEvaluatorProxy astNodeEvaluatorProxy)
	{
		return splitDate(args, astNodeEvaluatorProxy, GregorianCalendar.DAY_OF_MONTH);
	}
}
