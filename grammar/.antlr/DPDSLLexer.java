// Generated from e:/Code/dpsql-python/grammar/DPDSL.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class DPDSLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, SELECT=9, 
		FROM=10, AS=11, OF=12, LABEL_TYPE=13, ID=14, NUMBER=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "SELECT", 
			"FROM", "AS", "OF", "LABEL_TYPE", "ID", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'['", "']'", "'SUM'", "'COUNT'", "'AVG'", 
			"'SELECT'", "'FROM'", "'AS'", "'OF'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "SELECT", "FROM", 
			"AS", "OF", "LABEL_TYPE", "ID", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public DPDSLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DPDSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010u\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\fY\b\f\u0001\r\u0001\r\u0005\r]\b\r\n\r\f\r`\t\r\u0001\u000e\u0004\u000e"+
		"c\b\u000e\u000b\u000e\f\u000ed\u0001\u000e\u0001\u000e\u0004\u000ei\b"+
		"\u000e\u000b\u000e\f\u000ej\u0003\u000em\b\u000e\u0001\u000f\u0004\u000f"+
		"p\b\u000f\u000b\u000f\f\u000fq\u0001\u000f\u0001\u000f\u0000\u0000\u0010"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010\u0001\u0000\u0004\u0003\u0000AZ__az\u0004\u0000"+
		"09AZ__az\u0001\u000009\u0003\u0000\t\n\r\r  z\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0001!\u0001\u0000\u0000\u0000\u0003"+
		"#\u0001\u0000\u0000\u0000\u0005%\u0001\u0000\u0000\u0000\u0007\'\u0001"+
		"\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000\u000b+\u0001\u0000\u0000"+
		"\u0000\r/\u0001\u0000\u0000\u0000\u000f5\u0001\u0000\u0000\u0000\u0011"+
		"9\u0001\u0000\u0000\u0000\u0013@\u0001\u0000\u0000\u0000\u0015E\u0001"+
		"\u0000\u0000\u0000\u0017H\u0001\u0000\u0000\u0000\u0019X\u0001\u0000\u0000"+
		"\u0000\u001bZ\u0001\u0000\u0000\u0000\u001db\u0001\u0000\u0000\u0000\u001f"+
		"o\u0001\u0000\u0000\u0000!\"\u0005,\u0000\u0000\"\u0002\u0001\u0000\u0000"+
		"\u0000#$\u0005(\u0000\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0005)\u0000"+
		"\u0000&\u0006\u0001\u0000\u0000\u0000\'(\u0005[\u0000\u0000(\b\u0001\u0000"+
		"\u0000\u0000)*\u0005]\u0000\u0000*\n\u0001\u0000\u0000\u0000+,\u0005S"+
		"\u0000\u0000,-\u0005U\u0000\u0000-.\u0005M\u0000\u0000.\f\u0001\u0000"+
		"\u0000\u0000/0\u0005C\u0000\u000001\u0005O\u0000\u000012\u0005U\u0000"+
		"\u000023\u0005N\u0000\u000034\u0005T\u0000\u00004\u000e\u0001\u0000\u0000"+
		"\u000056\u0005A\u0000\u000067\u0005V\u0000\u000078\u0005G\u0000\u0000"+
		"8\u0010\u0001\u0000\u0000\u00009:\u0005S\u0000\u0000:;\u0005E\u0000\u0000"+
		";<\u0005L\u0000\u0000<=\u0005E\u0000\u0000=>\u0005C\u0000\u0000>?\u0005"+
		"T\u0000\u0000?\u0012\u0001\u0000\u0000\u0000@A\u0005F\u0000\u0000AB\u0005"+
		"R\u0000\u0000BC\u0005O\u0000\u0000CD\u0005M\u0000\u0000D\u0014\u0001\u0000"+
		"\u0000\u0000EF\u0005A\u0000\u0000FG\u0005S\u0000\u0000G\u0016\u0001\u0000"+
		"\u0000\u0000HI\u0005O\u0000\u0000IJ\u0005F\u0000\u0000J\u0018\u0001\u0000"+
		"\u0000\u0000KL\u0005P\u0000\u0000LM\u0005U\u0000\u0000MN\u0005B\u0000"+
		"\u0000NO\u0005L\u0000\u0000OP\u0005I\u0000\u0000PY\u0005C\u0000\u0000"+
		"QR\u0005P\u0000\u0000RS\u0005R\u0000\u0000ST\u0005I\u0000\u0000TU\u0005"+
		"V\u0000\u0000UV\u0005A\u0000\u0000VW\u0005T\u0000\u0000WY\u0005E\u0000"+
		"\u0000XK\u0001\u0000\u0000\u0000XQ\u0001\u0000\u0000\u0000Y\u001a\u0001"+
		"\u0000\u0000\u0000Z^\u0007\u0000\u0000\u0000[]\u0007\u0001\u0000\u0000"+
		"\\[\u0001\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000"+
		"\u0000^_\u0001\u0000\u0000\u0000_\u001c\u0001\u0000\u0000\u0000`^\u0001"+
		"\u0000\u0000\u0000ac\u0007\u0002\u0000\u0000ba\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000el\u0001\u0000\u0000\u0000fh\u0005.\u0000\u0000gi\u0007\u0002\u0000"+
		"\u0000hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000lf\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000m\u001e\u0001\u0000\u0000"+
		"\u0000np\u0007\u0003\u0000\u0000on\u0001\u0000\u0000\u0000pq\u0001\u0000"+
		"\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001"+
		"\u0000\u0000\u0000st\u0006\u000f\u0000\u0000t \u0001\u0000\u0000\u0000"+
		"\u0007\u0000X^djlq\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}