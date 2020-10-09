import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;

public class ExprParser extends Parser {

    public ExprParser(TokenStream input) {
        super(input);
    }

    public String[] getTokenNames() {
        return new String[0];
    }

    public String[] getRuleNames() {
        return new String[0];
    }

    public String getGrammarFileName() {
        return null;
    }

    public ATN getATN() {
        return null;
    }
}
