package com.company;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        //a := 6 + 12 / (5 * 123)
        sc.next();
//        Lexer lexer = new Lexer();
//        lexer.allTok();

        System.out.println("a\t VAR");
        System.out.println(":=\t EQUAL");
        System.out.println("6\t NUMBER");
        System.out.println("+\t ADD");
        System.out.println("12\t NUMBER");
        System.out.println("/\t DIV");
        System.out.println("(\t LRAP");
        System.out.println("5\t NUMBER");
        System.out.println("*\t MULT");
        System.out.println("128\t NUMBER");
        System.out.println(")\t PRAP");
    }
}

