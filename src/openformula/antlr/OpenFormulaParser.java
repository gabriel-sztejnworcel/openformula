// Generated from OpenFormula.g4 by ANTLR 4.5.3
package openformula.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OpenFormulaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, Identifier=15, IdentifierWithDot=16, 
		SingleQuoted=17, SheetName=18, SingleCellReference=19, ParameterSeparator=20, 
		Error=21, Integer=22, StandardNumber=23, NonStandardNumber=24, String=25, 
		Whitespace=26;
	public static final int
		RULE_formula = 0, RULE_expression = 1, RULE_number = 2, RULE_reference = 3, 
		RULE_parameterList = 4, RULE_functionName = 5;
	public static final String[] ruleNames = {
		"formula", "expression", "number", "reference", "parameterList", "functionName"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'of:='", "'='", "'+'", "'-'", "'^'", "'*'", "'/'", "'<>'", "'<'", 
		"'>'", "'<='", "'>='", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "Identifier", "IdentifierWithDot", "SingleQuoted", "SheetName", 
		"SingleCellReference", "ParameterSeparator", "Error", "Integer", "StandardNumber", 
		"NonStandardNumber", "String", "Whitespace"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "OpenFormula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OpenFormulaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormulaContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(OpenFormulaParser.EOF, 0); }
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(T__0);
			setState(14);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(13);
				match(T__1);
				}
			}

			setState(16);
			expression(0);
			setState(17);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionNumberContext extends ExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ExpressionNumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionStringContext extends ExpressionContext {
		public TerminalNode String() { return getToken(OpenFormulaParser.String, 0); }
		public ExpressionStringContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionAddContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionAddContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionGreaterThanContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionGreaterThanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionGreaterThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionUnaryMinusContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUnaryMinusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionUnaryMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionPowerContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionPowerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionPower(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionDivideContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionDivideContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionDivide(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionSubtractContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionSubtractContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionSubtract(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionReferenceContext extends ExpressionContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public ExpressionReferenceContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionReference(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionLessOrEqualContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionLessOrEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionLessOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionUnaryPlusContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionUnaryPlusContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionUnaryPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionLessThanContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionLessThanContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionLessThan(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionNotEqualsContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionNotEqualsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionNotEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionEqualsContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionEqualsContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionEquals(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionGreaterOrEqualContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionGreaterOrEqualContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionGreaterOrEqual(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionErrorContext extends ExpressionContext {
		public TerminalNode Error() { return getToken(OpenFormulaParser.Error, 0); }
		public ExpressionErrorContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionError(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionFunctionCallContext extends ExpressionContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ExpressionFunctionCallContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionParenthesisContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionMultiplyContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionMultiplyContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitExpressionMultiply(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			switch (_input.LA(1)) {
			case Integer:
			case StandardNumber:
			case NonStandardNumber:
				{
				_localctx = new ExpressionNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(20);
				number();
				}
				break;
			case String:
				{
				_localctx = new ExpressionStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(String);
				}
				break;
			case SingleCellReference:
				{
				_localctx = new ExpressionReferenceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				reference();
				}
				break;
			case T__2:
				{
				_localctx = new ExpressionUnaryPlusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(23);
				match(T__2);
				setState(24);
				expression(16);
				}
				break;
			case T__3:
				{
				_localctx = new ExpressionUnaryMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(T__3);
				setState(26);
				expression(15);
				}
				break;
			case T__12:
				{
				_localctx = new ExpressionParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(27);
				match(T__12);
				setState(28);
				expression(0);
				setState(29);
				match(T__13);
				}
				break;
			case Identifier:
			case IdentifierWithDot:
				{
				_localctx = new ExpressionFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				functionName();
				setState(32);
				match(T__12);
				setState(34);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__12) | (1L << Identifier) | (1L << IdentifierWithDot) | (1L << SingleCellReference) | (1L << Error) | (1L << Integer) | (1L << StandardNumber) | (1L << NonStandardNumber) | (1L << String))) != 0)) {
					{
					setState(33);
					parameterList();
					}
				}

				setState(36);
				match(T__13);
				}
				break;
			case Error:
				{
				_localctx = new ExpressionErrorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(Error);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(74);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionPowerContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(41);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(42);
						match(T__4);
						setState(43);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionMultiplyContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(44);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(45);
						match(T__5);
						setState(46);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionDivideContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(47);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(48);
						match(T__6);
						setState(49);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionAddContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(50);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(51);
						match(T__2);
						setState(52);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionSubtractContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(53);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(54);
						match(T__3);
						setState(55);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionEqualsContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(56);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(57);
						match(T__1);
						setState(58);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionNotEqualsContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(59);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(60);
						match(T__7);
						setState(61);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionLessThanContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(62);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(63);
						match(T__8);
						setState(64);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionGreaterThanContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(65);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(66);
						match(T__9);
						setState(67);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionLessOrEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(68);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(69);
						match(T__10);
						setState(70);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionGreaterOrEqualContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(71);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(72);
						match(T__11);
						setState(73);
						expression(5);
						}
						break;
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode StandardNumber() { return getToken(OpenFormulaParser.StandardNumber, 0); }
		public TerminalNode NonStandardNumber() { return getToken(OpenFormulaParser.NonStandardNumber, 0); }
		public TerminalNode Integer() { return getToken(OpenFormulaParser.Integer, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Integer) | (1L << StandardNumber) | (1L << NonStandardNumber))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
	 
		public ReferenceContext() { }
		public void copyFrom(ReferenceContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SingleCellReferenceContext extends ReferenceContext {
		public TerminalNode SingleCellReference() { return getToken(OpenFormulaParser.SingleCellReference, 0); }
		public SingleCellReferenceContext(ReferenceContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitSingleCellReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_reference);
		try {
			_localctx = new SingleCellReferenceContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(SingleCellReference);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> ParameterSeparator() { return getTokens(OpenFormulaParser.ParameterSeparator); }
		public TerminalNode ParameterSeparator(int i) {
			return getToken(OpenFormulaParser.ParameterSeparator, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			expression(0);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ParameterSeparator) {
				{
				{
				setState(84);
				match(ParameterSeparator);
				setState(85);
				expression(0);
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(OpenFormulaParser.Identifier, 0); }
		public TerminalNode IdentifierWithDot() { return getToken(OpenFormulaParser.IdentifierWithDot, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OpenFormulaVisitor ) return ((OpenFormulaVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functionName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_la = _input.LA(1);
			if ( !(_la==Identifier || _la==IdentifierWithDot) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\34`\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\5\2\21\n\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3%\n\3\3\3"+
		"\3\3\3\3\5\3*\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3M\n\3\f\3\16\3P\13\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\7\6Y\n"+
		"\6\f\6\16\6\\\13\6\3\7\3\7\3\7\2\3\4\b\2\4\6\b\n\f\2\4\3\2\30\32\3\2\21"+
		"\22n\2\16\3\2\2\2\4)\3\2\2\2\6Q\3\2\2\2\bS\3\2\2\2\nU\3\2\2\2\f]\3\2\2"+
		"\2\16\20\7\3\2\2\17\21\7\4\2\2\20\17\3\2\2\2\20\21\3\2\2\2\21\22\3\2\2"+
		"\2\22\23\5\4\3\2\23\24\7\2\2\3\24\3\3\2\2\2\25\26\b\3\1\2\26*\5\6\4\2"+
		"\27*\7\33\2\2\30*\5\b\5\2\31\32\7\5\2\2\32*\5\4\3\22\33\34\7\6\2\2\34"+
		"*\5\4\3\21\35\36\7\17\2\2\36\37\5\4\3\2\37 \7\20\2\2 *\3\2\2\2!\"\5\f"+
		"\7\2\"$\7\17\2\2#%\5\n\6\2$#\3\2\2\2$%\3\2\2\2%&\3\2\2\2&\'\7\20\2\2\'"+
		"*\3\2\2\2(*\7\27\2\2)\25\3\2\2\2)\27\3\2\2\2)\30\3\2\2\2)\31\3\2\2\2)"+
		"\33\3\2\2\2)\35\3\2\2\2)!\3\2\2\2)(\3\2\2\2*N\3\2\2\2+,\f\20\2\2,-\7\7"+
		"\2\2-M\5\4\3\21./\f\17\2\2/\60\7\b\2\2\60M\5\4\3\20\61\62\f\16\2\2\62"+
		"\63\7\t\2\2\63M\5\4\3\17\64\65\f\r\2\2\65\66\7\5\2\2\66M\5\4\3\16\678"+
		"\f\f\2\289\7\6\2\29M\5\4\3\r:;\f\13\2\2;<\7\4\2\2<M\5\4\3\f=>\f\n\2\2"+
		">?\7\n\2\2?M\5\4\3\13@A\f\t\2\2AB\7\13\2\2BM\5\4\3\nCD\f\b\2\2DE\7\f\2"+
		"\2EM\5\4\3\tFG\f\7\2\2GH\7\r\2\2HM\5\4\3\bIJ\f\6\2\2JK\7\16\2\2KM\5\4"+
		"\3\7L+\3\2\2\2L.\3\2\2\2L\61\3\2\2\2L\64\3\2\2\2L\67\3\2\2\2L:\3\2\2\2"+
		"L=\3\2\2\2L@\3\2\2\2LC\3\2\2\2LF\3\2\2\2LI\3\2\2\2MP\3\2\2\2NL\3\2\2\2"+
		"NO\3\2\2\2O\5\3\2\2\2PN\3\2\2\2QR\t\2\2\2R\7\3\2\2\2ST\7\25\2\2T\t\3\2"+
		"\2\2UZ\5\4\3\2VW\7\26\2\2WY\5\4\3\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3"+
		"\2\2\2[\13\3\2\2\2\\Z\3\2\2\2]^\t\3\2\2^\r\3\2\2\2\b\20$)LNZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}