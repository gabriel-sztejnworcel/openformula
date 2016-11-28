
package openformula.interpreter;

import openformula.ast.AstNode;
import openformula.ast.BinaryArithmeticAstNode;
import openformula.ast.ComparisonAstNode;
import openformula.ast.FunctionCallAstNode;
import openformula.ast.UnaryArithmeticAstNode;
import openformula.ast.ValueAstNode;
import openformula.ast.ComparisonAstNode.ComparisonOperator;
import openformula.functions.FunctionCalculator;
import openformula.spreadsheet.Cell;
import openformula.spreadsheet.Sheet;
import openformula.spreadsheet.Spreadsheet;
import openformula.value.ErrorValue;
import openformula.value.Reference;
import openformula.value.Value;
import openformula.value.ValueConverter;
import openformula.value.ValuePair;
import openformula.value.Value.ValueType;

public class AstNodeEvaluator
{
	private Spreadsheet spreadsheet;
	private FunctionCalculator functionCalculator;
	private AstNodeEvaluatorProxy astNodeEvaluatorProxy;
	private ValueConverter valueConverter;
	
	public AstNodeEvaluator(Spreadsheet spreadsheet)
	{
		this.spreadsheet = spreadsheet;
		this.functionCalculator = FunctionCalculator.getInstance();
		this.astNodeEvaluatorProxy = new AstNodeEvaluatorProxy(this);
		this.valueConverter = new ValueConverter();
	}
	
	public Value evaluate(AstNode node)
	{
		Value value = null;
		
		switch (node.getType())
		{
		case BINARY_ARITHMETIC_OPERATION:
			value = evaluate((BinaryArithmeticAstNode)node);
			break;
			
		case COMPARISON_OPERATION:
			value = evaluate((ComparisonAstNode)node);
			break;
			
		case FUNCTION_CALL:
			value = evaluate((FunctionCallAstNode)node);
			break;
			
		case UNARY_ARITHMETIC_OPERATION:
			value = evaluate((UnaryArithmeticAstNode)node);
			break;
			
		case VALUE:
			value = evaluate((ValueAstNode)node);
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		return value;
	}

	public Value evaluateAndDereference(AstNode node)
	{
		Value value = evaluate(node);
		
		if (value.getType() == ValueType.REFERENCE)
		{
			Reference ref = value.getAsReference();
			value = dereference(ref);
		}
		
		return value;
	}
	
	public Value dereference(Reference ref)
	{
		Value value = null;
		
		Sheet sheet = spreadsheet.getSheet(ref.getSheetName());
		Cell cell = null;
		
		if (sheet != null)
		{
			cell = sheet.getCell(ref.getCellPosition());
		}
		
		if (cell != null) // cell exists
		{
			cell.calculate();
			
			if (cell.isError())
			{
				value = Value.createErrorValue(cell.getError());
			}
			else
			{
				value = getValueFromCell(cell);
			}
		}
		else // cell does not exist
		{
			value = Value.createErrorValue(ErrorValue.REF);
		}
		
		return value;
	}
	
	private Value evaluate(BinaryArithmeticAstNode node)
	{
		Value leftValue = evaluateAndDereference(node.getLeftNode());
		Value rightValue = evaluateAndDereference(node.getRightNode());
		
		leftValue = valueConverter.convert(leftValue, ValueType.NUMBER);
		
		if (leftValue.getType() == ValueType.ERROR)
		{
			return leftValue;
		}
		
		rightValue = valueConverter.convert(rightValue, ValueType.NUMBER);
		
		if (rightValue.getType() == ValueType.ERROR)
		{
			return rightValue;
		}

		Double leftNumber = leftValue.getAsNumber();
		Double rightNumber = rightValue.getAsNumber();
		Double result = null;
		
		switch (node.getOp())
		{
		case PLUS:
			result = leftNumber + rightNumber;
			break;
			
		case MINUS:
			result = leftNumber - rightNumber;
			break;
			
		case MULTIPLY:
			result = leftNumber * rightNumber;
			break;
			
		case DIVIDE:
			result = leftNumber / rightNumber;
			break;
			
		case POWER:
			result = Math.pow(leftNumber, rightNumber);
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		Value value = Value.createNumberValue(result);
		return value;
	}

	private Value evaluate(ComparisonAstNode node)
	{
		Value leftValue = evaluateAndDereference(node.getLeftNode());
		Value rightValue = evaluateAndDereference(node.getRightNode());
		
		ValuePair comparisonOperands = checkToConvertComparisonOperands(leftValue, rightValue);
		leftValue = comparisonOperands.getFirst();
		rightValue = comparisonOperands.getSecond();
		
		if (leftValue.getType() == ValueType.ERROR || rightValue.getType() == ValueType.ERROR)
		{
			Value value = Value.createErrorValue(ErrorValue.VALUE);
			return value;
		}
		
		Value value = null;
		
		switch (leftValue.getType())
		{
		case NUMBER:
			value = calcComparisonOperation(leftValue.getAsNumber(), rightValue.getAsNumber(), node.getOp());
			break;
			
		case STRING:
			value = calcComparisonOperation(leftValue.getAsString(), rightValue.getAsString(), node.getOp());
			break;
			
		case BOOLEAN:
			value = calcComparisonOperation(leftValue.getAsBoolean(), rightValue.getAsBoolean(), node.getOp());
			break;
			
		case DATE:
			value = calcComparisonOperation(leftValue.getAsDate(), rightValue.getAsDate(), node.getOp());
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		return value;
	}

	private Value evaluate(FunctionCallAstNode node)
	{
		return functionCalculator.callFunction(node.getFunctionName(), node.getArgs(), astNodeEvaluatorProxy);
	}

	private Value evaluate(UnaryArithmeticAstNode node)
	{
		Value operandValue = evaluateAndDereference(node.getOperandNode());
		operandValue = valueConverter.convert(operandValue, ValueType.NUMBER);
		
		if (operandValue.getType() == Value.ValueType.ERROR)
		{
			return operandValue;
		}
		
		Double operandNumber = operandValue.getAsNumber();
		Double result = null;
		
		switch (node.getOp())
		{
		case PLUS:
			result = operandNumber;
			break;
			
		case MINUS:
			result = -1.0 * operandNumber;
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		Value value = Value.createNumberValue(result);
		return value;
	}

	private Value evaluate(ValueAstNode node)
	{
		return node.getValue();
	}
	
	private <T> Value calcComparisonOperation(Comparable<T> left, T right, ComparisonOperator op)
	{
		int i = left.compareTo(right);
		Boolean result = null;
		
		switch (op)
		{
		case EQUALS:
			result = i == 0;
			break;
			
		case GREATER_OR_EQUAL:
			result = i >= 0;
			break;
			
		case GREATER_THAN:
			result = i > 0;
			break;
			
		case LESS_OR_EQUAL:
			result = i <= 0;
			break;
			
		case LESS_THAN:
			result = i < 0;
			break;
			
		case NOT_EQUALS:
			result = i != 0;
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		Value value = Value.createBooleanValue(result);
		return value;
	}
	
	private Value getValueFromCell(Cell cell)
	{
		Value value = null;
		
		switch (cell.getType())
		{
		case NUMBER:
			value = Value.createNumberValue(cell.getAsNumber());
			break;
			
		case STRING:
			value = Value.createStringValue(cell.getAsString());
			break;
			
		case BOOLEAN:
			value = Value.createBooleanValue(cell.getAsBoolean());
			break;
			
		case DATE:
			value = Value.createDateValue(cell.getAsDate());
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
		
		return value;
	}

	private ValuePair checkToConvertComparisonOperands(Value leftValue, Value rightValue)
	{
		if (leftValue.getType() == rightValue.getType())
		{
			ValuePair comparisonOperands = new ValuePair(leftValue, rightValue);
			return comparisonOperands;
		}
		
		if (leftValue.getType() == ValueType.NUMBER && rightValue.getType() != Value.ValueType.NUMBER)
		{
			rightValue = valueConverter.convert(rightValue, ValueType.NUMBER);
		}
		else if (rightValue.getType() == ValueType.NUMBER && leftValue.getType() != Value.ValueType.NUMBER)
		{
			leftValue = valueConverter.convert(leftValue, ValueType.NUMBER);
		}
		else if (leftValue.getType() == ValueType.BOOLEAN && rightValue.getType() != Value.ValueType.BOOLEAN)
		{
			rightValue = valueConverter.convert(rightValue, ValueType.BOOLEAN);
		}
		else if (rightValue.getType() == ValueType.BOOLEAN && leftValue.getType() != Value.ValueType.BOOLEAN)
		{
			leftValue = valueConverter.convert(leftValue, ValueType.BOOLEAN);
		}
		else if (leftValue.getType() == ValueType.DATE && rightValue.getType() != Value.ValueType.DATE)
		{
			rightValue = valueConverter.convert(rightValue, ValueType.DATE);
		}
		else if (rightValue.getType() == ValueType.DATE && leftValue.getType() != Value.ValueType.DATE)
		{
			leftValue = valueConverter.convert(leftValue, ValueType.DATE);
		}
		else if (leftValue.getType() == ValueType.STRING && rightValue.getType() != Value.ValueType.STRING)
		{
			rightValue = valueConverter.convert(rightValue, ValueType.STRING);
		}
		else if (rightValue.getType() == ValueType.STRING && leftValue.getType() != Value.ValueType.STRING)
		{
			leftValue = valueConverter.convert(leftValue, ValueType.STRING);
		}

		ValuePair comparisonOperands = new ValuePair(leftValue, rightValue);
		return comparisonOperands;
	}
}
