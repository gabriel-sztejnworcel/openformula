
package openformula.antlr;

import java.util.List;
import java.util.Vector;

import openformula.antlr.OpenFormulaParser.*;
import openformula.ast.AstNode;
import openformula.ast.BinaryArithmeticAstNode;
import openformula.ast.ComparisonAstNode;
import openformula.ast.FunctionCallAstNode;
import openformula.ast.UnaryArithmeticAstNode;
import openformula.ast.ValueAstNode;
import openformula.ast.BinaryArithmeticAstNode.BinaryArithmeticOperator;
import openformula.ast.ComparisonAstNode.ComparisonOperator;
import openformula.ast.UnaryArithmeticAstNode.UnaryArithmeticOperator;
import openformula.value.Value;

public class OpenFormulaAstBuilderVisitor extends OpenFormulaBaseVisitor<AstNode>
{
	private String sourceSheetName;
	// private String sourceCellPosition;
	
	public OpenFormulaAstBuilderVisitor(String sourceSheetName, String sourceCellPosition)
	{
		this.sourceSheetName = sourceSheetName;
		// this.sourceCellPosition = sourceCellPosition;
	}
	
	@Override
	public AstNode visitFormula(FormulaContext ctx)
	{
		return visit(ctx.expression());
	}

	@Override
	public AstNode visitExpressionNumber(ExpressionNumberContext ctx)
	{
		Double number = Double.parseDouble(ctx.getText());
		Value value = Value.createNumberValue(number);
		AstNode node = new ValueAstNode(value);
		return node;
	}

	@Override
	public AstNode visitExpressionString(ExpressionStringContext ctx)
	{
		Value value = Value.createStringValue(ctx.getText());
		AstNode node = new ValueAstNode(value);
		return node;
	}

	@Override
	public AstNode visitExpressionAdd(ExpressionAddContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new BinaryArithmeticAstNode(leftNode, rightNode, BinaryArithmeticOperator.PLUS);
		return node;
	}

	@Override
	public AstNode visitExpressionGreaterThan(ExpressionGreaterThanContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new ComparisonAstNode(leftNode, rightNode, ComparisonOperator.GREATER_THAN);
		return node;
	}

	@Override
	public AstNode visitExpressionUnaryMinus(ExpressionUnaryMinusContext ctx)
	{
		AstNode operandNode = visit(ctx.expression());
		AstNode node = new UnaryArithmeticAstNode(operandNode, UnaryArithmeticOperator.MINUS);
		return node;
	}

	@Override
	public AstNode visitExpressionPower(ExpressionPowerContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new BinaryArithmeticAstNode(leftNode, rightNode, BinaryArithmeticOperator.POWER);
		return node;
	}

	@Override
	public AstNode visitExpressionDivide(ExpressionDivideContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new BinaryArithmeticAstNode(leftNode, rightNode, BinaryArithmeticOperator.DIVIDE);
		return node;
	}

	@Override
	public AstNode visitExpressionSubtract(ExpressionSubtractContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new BinaryArithmeticAstNode(leftNode, rightNode, BinaryArithmeticOperator.MINUS);
		return node;
	}

	@Override
	public AstNode visitExpressionLessOrEqual(ExpressionLessOrEqualContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new ComparisonAstNode(leftNode, rightNode, ComparisonOperator.LESS_OR_EQUAL);
		return node;
	}

	@Override
	public AstNode visitExpressionUnaryPlus(ExpressionUnaryPlusContext ctx)
	{
		AstNode operandNode = visit(ctx.expression());
		AstNode node = new UnaryArithmeticAstNode(operandNode, UnaryArithmeticOperator.PLUS);
		return node;
	}

	@Override
	public AstNode visitExpressionLessThan(ExpressionLessThanContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new ComparisonAstNode(leftNode, rightNode, ComparisonOperator.LESS_THAN);
		return node;
	}

	@Override
	public AstNode visitExpressionNotEquals(ExpressionNotEqualsContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new ComparisonAstNode(leftNode, rightNode, ComparisonOperator.NOT_EQUALS);
		return node;
	}

	@Override
	public AstNode visitExpressionGreaterOrEqual(ExpressionGreaterOrEqualContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new ComparisonAstNode(leftNode, rightNode, ComparisonOperator.GREATER_OR_EQUAL);
		return node;
	}

	@Override
	public AstNode visitExpressionEquals(ExpressionEqualsContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new ComparisonAstNode(leftNode, rightNode, ComparisonOperator.EQUALS);
		return node;
	}

	@Override
	public AstNode visitExpressionError(ExpressionErrorContext ctx)
	{
		Value value = Value.createErrorValue(ctx.getText());
		AstNode node = new ValueAstNode(value);
		return node;
	}

	@Override
	public AstNode visitExpressionParenthesis(ExpressionParenthesisContext ctx)
	{
		return visit(ctx.expression());
	}

	@Override
	public AstNode visitSingleCellReference(SingleCellReferenceContext ctx)
	{
		// remove '[' and ']' from the beginning and end
		String reference = ctx.getText().substring(1, ctx.getText().length() - 1);
		
		int dotIndex = reference.indexOf('.');
		
		String sheetName = reference.substring(0, dotIndex);
		String cellPosition = reference.substring(dotIndex + 1);
		
		if (sheetName.isEmpty())
		{
			sheetName = sourceSheetName;
		}
		
		Value value = Value.createReferenceValue(sheetName, cellPosition);
		AstNode node = new ValueAstNode(value);
		return node;
	}

	@Override
	public AstNode visitExpressionFunctionCall(ExpressionFunctionCallContext ctx)
	{
		String functionName = ctx.functionName().getText();
		List<ExpressionContext> parameterList = ctx.parameterList().expression();
		Vector<AstNode> parameters = new Vector<AstNode>(parameterList.size());
		
		for (ExpressionContext ectx : parameterList)
		{
			AstNode parameterNode = visit(ectx);
			parameters.add(parameterNode);
		}
		
		AstNode node = new FunctionCallAstNode(functionName, parameters);
		return node;
	}

	@Override
	public AstNode visitExpressionMultiply(ExpressionMultiplyContext ctx)
	{
		AstNode leftNode = visit(ctx.expression(0));
		AstNode rightNode = visit(ctx.expression(1));
		AstNode node = new BinaryArithmeticAstNode(leftNode, rightNode, BinaryArithmeticOperator.MULTIPLY);
		return node;
	}
}
