package com.company;

public enum TokenType {
    /**
     * Пробелы
     */
    SPACES,
    /**
     * Целое число
     */
    NUMBER,
    /**
     * Символ '+'
     */
    ADD,
    /**
     * Символ '-'
     */
    SUB,
    /**
     * Символ '*'
     */
    MUL,
    /**
     * Символ '/'
     */
    DIV,
    /**
     * Символ '!'
     */
    EXCLAM,
    /**
     * Символ '('
     */
    LPAR,
    /**
     * Символ ')'
     */
    RPAR,
    /**
     * Переменная
     */
    VAR,
    /**
     * Приравнивание
     */
    ASSIGN,
    /**
     * Больше
     */
    MORE,
    /**
     * Меньше
     */
    LESS,
    /**
     * Равно
     */
    EQUAL,
    /**
     * Больше или равно
     */
    MORE_OR_EQUAL,
    /**
     * Меньше или равно
     */
    LESS_OR_EQUAL,
    /**
     * НЕ равно
     */
    NOT_EQUAL
}
