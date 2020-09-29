package com.lab3.mike;

/*
    Входной язык содержит арифметические выражения, разделённые символом ; (точка с запятой).
    Арифметические выражения состоят из идентификаторов, шестнадцатеричных чисел, знака присваивания (:=),
    знаков операций +, –, *, / и круглых скобок.

    Шестнадцатеричными числами считать последовательность цифр и символов a, b, c, d, e, f,
    начинающуюся с цифры (например, 89, 45ac, 0abc).
 */

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer("12 := 89a + 4cd; 44 := 9da + 6d;");
        try {
            for (Token token : lexer.getAllTokens())
                System.out.println(token.str + "\t " + token.type);
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }
    }
}
