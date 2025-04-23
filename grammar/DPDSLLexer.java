package grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DPDSLLexer extends Lexer {
    // Token definitions matching the grammar
    public static final int
        SELECT = 1, FROM = 2, AS = 3, OF = 4, LABEL_TYPE = 5, ID = 6, NUMBER = 7, WS = 8;
    
    public static String[] channelNames = { "DEFAULT_TOKEN_CHANNEL", "HIDDEN" };
    public static String[] modeNames = { "DEFAULT_MODE" };

    public static final String[] ruleNames = {
        "SELECT", "FROM", "AS", "OF", "LABEL_TYPE", "ID", "NUMBER", "WS"
    };

    public DPDSLLexer(CharStream input) {
        super(input);
    }

    @Override
    public String getGrammarFileName() { return "DPDSL.g4"; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String[] getChannelNames() { return channelNames; }

    @Override
    public String[] getModeNames() { return modeNames; }
}