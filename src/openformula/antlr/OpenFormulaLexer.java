// Generated from OpenFormula.g4 by ANTLR 4.5.3
package openformula.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class OpenFormulaLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "Identifier", "IdentifierWithDot", 
		"SingleQuoted", "SheetName", "SingleCellReference", "ParameterSeparator", 
		"Error", "Integer", "StandardNumber", "NonStandardNumber", "String", "Whitespace"
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


	public OpenFormulaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "OpenFormula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\34\u00dc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\7\20\\\n\20\f\20\16\20_\13\20\3"+
		"\21\3\21\7\21c\n\21\f\21\16\21f\13\21\3\22\3\22\3\22\3\22\6\22l\n\22\r"+
		"\22\16\22m\3\22\3\22\3\23\5\23s\n\23\3\23\3\23\5\23w\n\23\3\24\3\24\5"+
		"\24{\n\24\3\24\3\24\6\24\177\n\24\r\24\16\24\u0080\3\24\3\24\7\24\u0085"+
		"\n\24\f\24\16\24\u0088\13\24\3\24\3\24\3\25\3\25\3\26\3\26\6\26\u0090"+
		"\n\26\r\26\16\26\u0091\3\26\3\26\3\26\3\26\3\26\5\26\u0099\n\26\5\26\u009b"+
		"\n\26\3\27\6\27\u009e\n\27\r\27\16\27\u009f\3\30\6\30\u00a3\n\30\r\30"+
		"\16\30\u00a4\3\30\3\30\6\30\u00a9\n\30\r\30\16\30\u00aa\5\30\u00ad\n\30"+
		"\3\30\3\30\5\30\u00b1\n\30\3\30\6\30\u00b4\n\30\r\30\16\30\u00b5\5\30"+
		"\u00b8\n\30\3\31\3\31\6\31\u00bc\n\31\r\31\16\31\u00bd\3\31\3\31\5\31"+
		"\u00c2\n\31\3\31\6\31\u00c5\n\31\r\31\16\31\u00c6\5\31\u00c9\n\31\3\32"+
		"\3\32\3\32\3\32\7\32\u00cf\n\32\f\32\16\32\u00d2\13\32\3\32\3\32\3\33"+
		"\6\33\u00d7\n\33\r\33\16\33\u00d8\3\33\3\33\2\2\34\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\20\4\2C\\c|\6\2\62;C\\aac|\7"+
		"\2\60\60\62;C\\aac|\b\2)),,\61\61<<AA]_\3\2C\\\3\2\63;\3\2\62;\4\2..="+
		"=\4\2\62;C\\\4\2##AA\4\2GGgg\4\2--//\3\2$$\5\2\13\f\17\17\"\"\u00f5\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\5<\3\2\2\2\7>\3\2"+
		"\2\2\t@\3\2\2\2\13B\3\2\2\2\rD\3\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23K\3\2"+
		"\2\2\25M\3\2\2\2\27O\3\2\2\2\31R\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37Y\3"+
		"\2\2\2!`\3\2\2\2#g\3\2\2\2%r\3\2\2\2\'x\3\2\2\2)\u008b\3\2\2\2+\u008d"+
		"\3\2\2\2-\u009d\3\2\2\2/\u00a2\3\2\2\2\61\u00b9\3\2\2\2\63\u00ca\3\2\2"+
		"\2\65\u00d6\3\2\2\2\678\7q\2\289\7h\2\29:\7<\2\2:;\7?\2\2;\4\3\2\2\2<"+
		"=\7?\2\2=\6\3\2\2\2>?\7-\2\2?\b\3\2\2\2@A\7/\2\2A\n\3\2\2\2BC\7`\2\2C"+
		"\f\3\2\2\2DE\7,\2\2E\16\3\2\2\2FG\7\61\2\2G\20\3\2\2\2HI\7>\2\2IJ\7@\2"+
		"\2J\22\3\2\2\2KL\7>\2\2L\24\3\2\2\2MN\7@\2\2N\26\3\2\2\2OP\7>\2\2PQ\7"+
		"?\2\2Q\30\3\2\2\2RS\7@\2\2ST\7?\2\2T\32\3\2\2\2UV\7*\2\2V\34\3\2\2\2W"+
		"X\7+\2\2X\36\3\2\2\2Y]\t\2\2\2Z\\\t\3\2\2[Z\3\2\2\2\\_\3\2\2\2][\3\2\2"+
		"\2]^\3\2\2\2^ \3\2\2\2_]\3\2\2\2`d\t\2\2\2ac\t\4\2\2ba\3\2\2\2cf\3\2\2"+
		"\2db\3\2\2\2de\3\2\2\2e\"\3\2\2\2fd\3\2\2\2gk\7)\2\2hl\n\5\2\2ij\7)\2"+
		"\2jl\7)\2\2kh\3\2\2\2ki\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2no\3\2\2"+
		"\2op\7)\2\2p$\3\2\2\2qs\7&\2\2rq\3\2\2\2rs\3\2\2\2sv\3\2\2\2tw\5\37\20"+
		"\2uw\5#\22\2vt\3\2\2\2vu\3\2\2\2w&\3\2\2\2xz\7]\2\2y{\5%\23\2zy\3\2\2"+
		"\2z{\3\2\2\2{|\3\2\2\2|~\7\60\2\2}\177\t\6\2\2~}\3\2\2\2\177\u0080\3\2"+
		"\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0086"+
		"\t\7\2\2\u0083\u0085\t\b\2\2\u0084\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2"+
		"\2\2\u0089\u008a\7_\2\2\u008a(\3\2\2\2\u008b\u008c\t\t\2\2\u008c*\3\2"+
		"\2\2\u008d\u008f\7%\2\2\u008e\u0090\t\n\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u009a\3\2"+
		"\2\2\u0093\u009b\t\13\2\2\u0094\u0098\7\61\2\2\u0095\u0099\t\6\2\2\u0096"+
		"\u0097\t\b\2\2\u0097\u0099\t\13\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3"+
		"\2\2\2\u0099\u009b\3\2\2\2\u009a\u0093\3\2\2\2\u009a\u0094\3\2\2\2\u009b"+
		",\3\2\2\2\u009c\u009e\t\b\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2"+
		"\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0.\3\2\2\2\u00a1\u00a3\t"+
		"\b\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00ac\3\2\2\2\u00a6\u00a8\7\60\2\2\u00a7\u00a9\t"+
		"\b\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a6\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00b7\3\2\2\2\u00ae\u00b0\t\f\2\2\u00af\u00b1\t\r\2\2\u00b0"+
		"\u00af\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b4\t\b"+
		"\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00ae\3\2\2\2\u00b7\u00b8\3\2"+
		"\2\2\u00b8\60\3\2\2\2\u00b9\u00bb\7\60\2\2\u00ba\u00bc\t\b\2\2\u00bb\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd\u00be\3\2\2\2\u00be"+
		"\u00c8\3\2\2\2\u00bf\u00c1\t\f\2\2\u00c0\u00c2\t\r\2\2\u00c1\u00c0\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c5\t\b\2\2\u00c4"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00bf\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\62\3\2\2\2\u00ca\u00d0\7$\2\2\u00cb\u00cf\n\16\2\2\u00cc\u00cd\7$\2\2"+
		"\u00cd\u00cf\7$\2\2\u00ce\u00cb\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d4\7$\2\2\u00d4\64\3\2\2\2\u00d5\u00d7\t\17\2"+
		"\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\b\33\2\2\u00db\66\3\2\2\2\35"+
		"\2]dkmrvz\u0080\u0086\u0091\u0098\u009a\u009f\u00a4\u00aa\u00ac\u00b0"+
		"\u00b5\u00b7\u00bd\u00c1\u00c6\u00c8\u00ce\u00d0\u00d8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}