package com.lab4.mike;

import com.lab3.mike.*;
import java.text.ParseException;
import java.util.List;
/*
    Реализовать разбор заданной грамматики в соответствии с вариантом задания.

    выражение ::= слагаемое (('+'|'-') слагаемое)*
    слагаемое ::= ЧИСЛО | '(' выражение ')'
 */

public class Main {

    /**
     * Проверка грамматического разбора выражения
     */
    public static void main(String[] args) {
        Lexer lexer;
        List<Token> allTokens;
        Parser parser;

        try {
            lexer = new Lexer("89a + 4cd - 56");
            allTokens = lexer.getAllTokens();
            for(int i = 0; i < allTokens.size(); i++)
                System.out.println(i +")\t"+ allTokens.get(i).str +"\t"+ allTokens.get(i).type);
        }catch (ParseException pe){
            System.out.println("Error In Lexer: " + pe.getMessage()+ " at " + pe.getErrorOffset());
            return;
        }

        try {
            parser = new Parser(allTokens);
            parser.matchExpression();
        }catch (ParseException pe){
            System.out.println("Error In Parser: " + pe.getMessage() + " at " + pe.getErrorOffset());
            return;
        }
        System.out.println("No Errors");
    }
}
