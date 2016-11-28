
package openformula.spreadsheet;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import openformula.antlr.OpenFormulaAstBuilderVisitor;
import openformula.antlr.OpenFormulaLexer;
import openformula.antlr.OpenFormulaParser;
import openformula.ast.AstNode;
import openformula.interpreter.AstNodeEvaluator;
import openformula.value.ValueConverter;
import openformula.value.Value.ValueType;

public class FormulaCell extends Cell
{
	private AstNodeEvaluator astNodeEvaluator;
	private AstNode node;
	private ValueConverter valueConverter;
	
	public FormulaCell(Spreadsheet spreadsheet, String sheetName, String cellPosition, String formula, CellValueType returnType)
	{
		super(returnType);
		this.astNodeEvaluator = new AstNodeEvaluator(spreadsheet);
		this.node = parseFormula(sheetName, cellPosition, formula);
		this.valueConverter = new ValueConverter();
	}

	@Override
	public void calculate()
	{
		value = astNodeEvaluator.evaluateAndDereference(node);
		
		switch (getType())
		{
		case NUMBER:
			value = valueConverter.convert(value, ValueType.NUMBER);
			break;
			
		case STRING:
			value = valueConverter.convert(value, ValueType.STRING);
			break;
			
		case BOOLEAN:
			value = valueConverter.convert(value, ValueType.BOOLEAN);
			break;
			
		case DATE:
			value = valueConverter.convert(value, ValueType.DATE);
			break;
			
		default:
			throw new UnsupportedOperationException();
		}
	}

	private AstNode parseFormula(String sheetName, String cellPosition, String formula)
	{
		ANTLRInputStream input = new ANTLRInputStream(formula);
		OpenFormulaLexer lexer = new OpenFormulaLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OpenFormulaParser parser = new OpenFormulaParser(tokens);
		ParseTree tree = parser.formula();

		OpenFormulaAstBuilderVisitor visitor = new OpenFormulaAstBuilderVisitor(sheetName, cellPosition);
		AstNode node = visitor.visit(tree);
		return node;
	}
}
