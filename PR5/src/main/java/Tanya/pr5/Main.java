package Tanya.pr5;

import gen.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class Main {

    public static void main(String[] args) {
        String text = "1222 + 412 / 214 * 12 * 255 - 61252";
        MyGrammaticLexer lex = new MyGrammaticLexer(CharStreams.fromString(text));
        MyGrammaticParser par = new MyGrammaticParser(new CommonTokenStream(lex));

        ParseTree tree = par.expr();

        System.out.println("\n");
        recurseOut(tree);
    }
    private static void recurseOut(ParseTree tree) {
        if(tree.getChildCount()>0) {
            for (int i = 0; i < tree.getChildCount(); i++) {
                recurseOut(tree.getChild(i));
                if (tree.getChild(i) instanceof TerminalNodeImpl) {
                    TerminalNodeImpl node = (TerminalNodeImpl) tree.getChild(i);
                    Token token = node.getSymbol();
                    String name = MyGrammaticLexer.VOCABULARY.getSymbolicName(token.getType());
                    System.out.println(name + ": " + token.getText());
                }
            }
        }
    }
}