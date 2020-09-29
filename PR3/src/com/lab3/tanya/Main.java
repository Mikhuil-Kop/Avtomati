package com.lab3.tanya;

/*
Входной язык содержит логические выражения, разделённые символом ; (точка с запятой).
Логические выражения состоят из идентификаторов, символьных констант 'T' и 'F',
знака присваивания (:=), операций or, xor, and, not и круглых скобок.
 */

import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        Lexer lexer = new Lexer("T := F ! T & F; T := TF&^");
        try {
            for (Token token : lexer.getAllTokens())
                System.out.println(token.str + "\t " + token.type);
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }
    }
}
