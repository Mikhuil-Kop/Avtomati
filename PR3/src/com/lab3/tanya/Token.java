package com.lab3.tanya;

public class Token {
    public TokenType type;
    public String str;
    public int from;
    public int to;

    public Token(TokenType type, String str, int from, int to) {
        this.type = type;
        this.str = str;
        this.from = from;
        this.to = to;
    }
}
