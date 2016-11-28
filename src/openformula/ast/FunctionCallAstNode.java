
package openformula.ast;

import java.util.Vector;

public class FunctionCallAstNode extends AstNode
{
	private String functionName;
	private Vector<AstNode> args;
	
	public FunctionCallAstNode(String functionName, Vector<AstNode> args)
	{
		super(AstNodeType.FUNCTION_CALL);
		this.functionName = functionName;
		this.args = args;
	}

	public String getFunctionName()
	{
		return functionName;
	}

	public Vector<AstNode> getArgs()
	{
		return args;
	}
}
