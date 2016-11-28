
package openformula.interpreter;

import openformula.ast.AstNode;
import openformula.value.Reference;
import openformula.value.Value;

public class AstNodeEvaluatorProxy
{
	private AstNodeEvaluator astNodeEvaluator;
	
	public AstNodeEvaluatorProxy(AstNodeEvaluator astNodeEvaluator)
	{
		this.astNodeEvaluator = astNodeEvaluator;
	}
	
	public Value evaluate(AstNode node)
	{
		return astNodeEvaluator.evaluate(node);
	}
	
	public Value evaluateAndDereference(AstNode node)
	{
		return astNodeEvaluator.evaluateAndDereference(node);
	}
	
	public Value dereference(Reference ref)
	{
		return astNodeEvaluator.dereference(ref);
	}
}
