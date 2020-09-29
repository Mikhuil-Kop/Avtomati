package com.lab4.mike;
import com.lab3.mike.*;

import java.text.ParseException;
import java.util.List;

/**
 * Грамматический разбор грамматики
 * выражение ::= ЧИСЛО ('+' ЧИСЛО)
 */
public class Parser {
    /**
     * Список лексем
     */
    private final List<Token> tokens;
    /**
     * Индекс текущей лексемы
     */
    private int index = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    /**
     * Проверка типа текущей лексемы.
     *
     * @param type предполагаемый тип лексемы
     * @return не null, если текущая лексема предполагаемого типа (при этом
     * текущи индекс сдвигается на 1);
     * null, если текущая лексема другого типа
     */
    private Token match(TokenType type) {
        if (index >= tokens.size())
            return null;
        Token token = tokens.get(index);
        if (token.type != type)
            return null;
        index++;
        return token;
    }

    /**
     * Сообщение об ошибке с указанием текущей позиции в тексте. *
     *
     * @param message текст сообщения
     */
    private void error(String message) throws ParseException { // Позиция ошибки в тексте
        int errorPosition;
        if (index >= tokens.size()) {
            // Мы стоим в конце текста
            if (tokens.isEmpty()) {
                // Лексем не было вообще - текст пустой; указываем на начало текста
                errorPosition = 0;
            } else {
                // Берем координату после последней лексемы
                errorPosition = tokens.get(tokens.size() - 1).to;
            }
        } else {
            // Берем координату текущей лексемы
            Token token = tokens.get(index);
            errorPosition = token.from;
        }
        throw new ParseException(message, errorPosition);
    }

    /**
     * Грамматический разбор выражения по грамматике
     * выражение ::= слагаемое (('+'|'-') слагаемое)*
     * слагаемое ::= ЧИСЛО | '(' выражение ')'
     */
    public void matchExpression() throws ParseException {
        // В начале должно быть СЛАГАЕМОЕ:
        Token n1 = match(TokenType.NUMBER);
        if (n1 == null) {
            error("Missing number");
        }
        //Произвольное колличество (+|-)СЛАГАЕМОЕ
        while (true) {
            //Проверка на +|-
            if (match(TokenType.ADD) != null || match(TokenType.SUB) != null) {
                //СЛАГАЕМОЕ -> число или выражение
                Token n2 = match(TokenType.NUMBER);
                if (n2 == null) {
                    matchExpression();
                }
            } else {
                break;
            }
        }
        if(index < tokens.size())
            error("Token Overflow: Unexpected Token '" + tokens.get(index).str + "'");
    }
}