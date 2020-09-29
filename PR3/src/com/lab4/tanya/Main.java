package com.lab4.tanya;

import com.lab3.mike.Lexer;
import com.lab3.mike.Token;

import java.text.ParseException;
import java.util.List;
/*
    Реализовать разбор заданной грамматики в соответствии с вариантом задания.

    выражение ::= слагаемое (('+'|'-') слагаемое)*
    слагаемое ::= множитель (('*'|'/') множитель)*
    множитель ::= ('-')? ЧИСЛО | '(' выражение ')'

    Число - любое целое число (лексмы взяты не из варианта прошлого задания, а из методички)
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
            lexer = new Lexer("89 + 4 - 56 * -44 * 2 + 3 - 5 * 412");
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
