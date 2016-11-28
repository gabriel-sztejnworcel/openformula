
package openformula.ast;

public abstract class AstNode
{
	public enum AstNodeType
	{
		VALUE,
		COMPARISON_OPERATION,
		BINARY_ARITHMETIC_OPERATION,
		UNARY_ARITHMETIC_OPERATION,
		FUNCTION_CALL
	}
	
	private AstNodeType type;
	
	public AstNode(AstNodeType type)
	{
		this.type = type;
	}
	
	public AstNodeType getType()
	{
		return type;
	}
}
