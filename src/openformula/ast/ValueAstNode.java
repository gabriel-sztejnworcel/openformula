
package openformula.ast;

import openformula.value.Value;

public class ValueAstNode extends AstNode
{
	private Value value;
	
	public ValueAstNode(Value value)
	{
		super(AstNodeType.VALUE);
		this.value = value;
	}
	
	public Value getValue()
	{
		return value;
	}
}
