package Mike.pr5;

import gen.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class Main {

    public static void main(String[] args) {
        String text = "6 * 2 + 2 / 3 + 5 * 6 * 7";
        MyGrammaticLexer lexer = new MyGrammaticLexer(CharStreams.fromString(text));
        MyGrammaticParser parser = new MyGrammaticParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expr();
        System.out.println("\n");
        writeTree(tree);
    }

    private static void writeTree(ParseTree tree) {
        if(tree.getChildCount()>0) {
            for (int i = 0; i < tree.getChildCount(); i++) {

                writeTree(tree.getChild(i));

                if (tree.getChild(i) instanceof TerminalNodeImpl) {
                    TerminalNodeImpl node = (TerminalNodeImpl) tree.getChild(i);
                    Token token = node.getSymbol();
                    int type = token.getType();

                    String typeName = MyGrammaticLexer.VOCABULARY.getSymbolicName(type);
                    System.out.println(typeName + ": " + token.getText());
                }
            }
        }
    }
}