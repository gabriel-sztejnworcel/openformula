
package openformula.ast;

public class UnaryArithmeticAstNode extends AstNode
{
	public enum UnaryArithmeticOperator
	{
		PLUS,
		MINUS
	}
	
	private AstNode operandNode;
	private UnaryArithmeticOperator op;
	
	public UnaryArithmeticAstNode(AstNode operandNode, UnaryArithmeticOperator op)
	{
		super(AstNodeType.UNARY_ARITHMETIC_OPERATION);
		this.operandNode = operandNode;
		this.op = op;
	}

	public AstNode getOperandNode()
	{
		return operandNode;
	}

	public UnaryArithmeticOperator getOp()
	{
		return op;
	}
}
