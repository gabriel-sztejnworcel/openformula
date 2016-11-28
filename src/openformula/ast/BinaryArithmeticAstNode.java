
package openformula.ast;

public class BinaryArithmeticAstNode extends AstNode
{
	public enum BinaryArithmeticOperator
	{
		PLUS,
		MINUS,
		MULTIPLY,
		DIVIDE,
		POWER
	}
	
	private AstNode leftNode;
	private AstNode rightNode;
	private BinaryArithmeticOperator op;
	
	public BinaryArithmeticAstNode(AstNode leftNode, AstNode rightNode, BinaryArithmeticOperator op)
	{
		super(AstNodeType.BINARY_ARITHMETIC_OPERATION);
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

	public BinaryArithmeticOperator getOp()
	{
		return op;
	}
}
