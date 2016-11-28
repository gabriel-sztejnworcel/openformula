
package openformula.ast;

public class ComparisonAstNode extends AstNode
{
	public enum ComparisonOperator
	{
		EQUALS,
		NOT_EQUALS,
		LESS_THAN,
		LESS_OR_EQUAL,
		GREATER_THAN,
		GREATER_OR_EQUAL
	}
	
	private AstNode leftNode;
	private AstNode rightNode;
	private ComparisonOperator op;
	
	public ComparisonAstNode(AstNode leftNode, AstNode rightNode, ComparisonOperator op)
	{
		super(AstNodeType.COMPARISON_OPERATION);
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.op = op;
	}

	public AstNode getLeftNode()
	{
		return leftNode;
	}

	public AstNode getRightNode()
	{
		return rightNode;
	}

	public ComparisonOperator getOp()
	{
		return op;
	}
}
