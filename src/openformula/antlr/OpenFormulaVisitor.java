// Generated from OpenFormula.g4 by ANTLR 4.5.3
package openformula.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OpenFormulaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OpenFormulaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OpenFormulaParser#formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormula(OpenFormulaParser.FormulaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionNumber}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumber(OpenFormulaParser.ExpressionNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionString}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionString(OpenFormulaParser.ExpressionStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionAdd}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAdd(OpenFormulaParser.ExpressionAddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGreaterThan}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGreaterThan(OpenFormulaParser.ExpressionGreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryMinus}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryMinus(OpenFormulaParser.ExpressionUnaryMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionPower}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionPower(OpenFormulaParser.ExpressionPowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionDivide}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionDivide(OpenFormulaParser.ExpressionDivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionSubtract}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSubtract(OpenFormulaParser.ExpressionSubtractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionReference}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionReference(OpenFormulaParser.ExpressionReferenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionLessOrEqual}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionLessOrEqual(OpenFormulaParser.ExpressionLessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionUnaryPlus}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionUnaryPlus(OpenFormulaParser.ExpressionUnaryPlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionLessThan}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionLessThan(OpenFormulaParser.ExpressionLessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionNotEquals}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNotEquals(OpenFormulaParser.ExpressionNotEqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionGreaterOrEqual}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionGreaterOrEqual(OpenFormulaParser.ExpressionGreaterOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionEquals}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionEquals(OpenFormulaParser.ExpressionEqualsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionError}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionError(OpenFormulaParser.ExpressionErrorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionParenthesis}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionParenthesis(OpenFormulaParser.ExpressionParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionFunctionCall}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFunctionCall(OpenFormulaParser.ExpressionFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionMultiply}
	 * labeled alternative in {@link OpenFormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionMultiply(OpenFormulaParser.ExpressionMultiplyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OpenFormulaParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(OpenFormulaParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleCellReference}
	 * labeled alternative in {@link OpenFormulaParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleCellReference(OpenFormulaParser.SingleCellReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OpenFormulaParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(OpenFormulaParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OpenFormulaParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(OpenFormulaParser.FunctionNameContext ctx);
}