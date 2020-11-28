package Mike.pr6;

import gen.MyGrammaticLexer;
import gen.MyGrammaticParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

public class Main {

    public static void main(String[] args) {
        String text = "1 - 2 - 3 * 4 * 5 / 2 + 9"; // = -22
        MyGrammaticLexer lexer = new MyGrammaticLexer(CharStreams.fromString(text));
        MyGrammaticParser parser = new MyGrammaticParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expr();

        System.out.println("\n-----------------------------------------------------");

        System.out.println("Проанализированная строка в виде дерева:");
        writeTree(tree, "");

        System.out.println("\n-----------------------------------------------------");

        System.out.println("С использованием скобок:");
        writeGrammar(tree);

        System.out.println("\n-----------------------------------------------------");

        System.out.println("Результат выражения: " + TreeValue(tree));
    }

    private static void writeTree(ParseTree tree, String tab) {
        for (int i = 0; i < tree.getChildCount(); i++) {

            writeTree(tree.getChild(i), tab + "\t\t");

            if (tree.getChild(i) instanceof TerminalNodeImpl) {
                TerminalNodeImpl node = (TerminalNodeImpl) tree.getChild(i);
                Token token = node.getSymbol();
                int type = token.getType();

                String typeName = MyGrammaticLexer.VOCABULARY.getSymbolicName(type);
                System.out.println(tab + typeName + ": " + token.getText());
            }
        }
    }


    private static void writeGrammar(ParseTree tree) {
        int len = tree.getChildCount();
        for (int i = 0; i < len; i++) {

            if (i == 0 && len != 1)
                System.out.print("(");

            writeGrammar(tree.getChild(i));

            if (tree.getChild(i) instanceof TerminalNodeImpl) {
                TerminalNodeImpl node = (TerminalNodeImpl) tree.getChild(i);
                Token token = node.getSymbol();

                System.out.print(token.getText());
            }

            if (i == len - 1 && len != 1)
                System.out.print(")");
        }
    }


    private static float TreeValue(ParseTree tree) {
        int len = tree.getChildCount();
        float value = 0;
        String sign = "";

        for (int i = 0; i < len; i++) {

            if (tree.getChild(i) instanceof TerminalNodeImpl) {
                TerminalNodeImpl node = (TerminalNodeImpl) tree.getChild(i);
                Token token = node.getSymbol();
                String typeName = MyGrammaticLexer.VOCABULARY.getSymbolicName(token.getType());

                if (typeName.equals("NUMBER"))
                    value = valueOperation(value, Float.parseFloat(token.getText()), sign);
                else
                    sign = typeName;
            } else
                value = valueOperation(value, TreeValue(tree.getChild(i)), sign);

        }
        return value;
    }

    private  static float valueOperation(float value1, float value2, String sign) {
        if (sign.equals(""))
            value1 = value2;
        if (sign.equals("ADD"))
            value1 += value2;
        if (sign.equals("SUB"))
            value1 -= value2;
        if (sign.equals("MUL"))
            value1 *= value2;
        if (sign.equals("DIV"))
            value1 /= value2;

        return value1;
    }
}