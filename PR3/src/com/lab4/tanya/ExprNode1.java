package com.lab4.tanya;
import com.lab3.mike.Token;

/**
 * Класс, определяющий структуру дерева разбора выражения.
 */
public class ExprNode1 {
    /**
     * true, если листовой узел (ЧИСЛО).
     * false, если узел бинарной операции (+ или -)
     */
    public final boolean isNumber;
    /**
     * Лексема для числа (заполняется при isNumber = true)
     */
    public final Token number;
    /**
     * Лексема для символа операции (заполняется при isNumber = false)
     */
    public final Token op;
    /**
     * Левое поддерево (заполняется при isNumber = false)
     */
    public final ExprNode1 left;
    /**
     * Правое поддерево (заполняется при isNumber = false)
     */
    public final ExprNode1 right;

    /**
     * Конструктор для узла дерева с поддеревьями * @param left левое поддерево
     *
     * @param left  левое поддерево
     * @param op    операция в узле
     * @param right правое поддерево
     */
    public ExprNode1(ExprNode1 left, Token op, ExprNode1 right) {
        this.isNumber = false;
        this.number = null;
        this.left = left;
        this.op = op;
        this.right = right;
    }

    /**
     * Конструктор для листа дерева (числа)
     */
    public ExprNode1(Token number) {
        this.isNumber = true;
        this.number = number;
        this.left = null;
        this.op = null;
        this.right = null;
    }

    @Override
    public String toString() {
        if (isNumber) {
            return number.str;
        } else {
            return "(" + left.toString() + op.str + right.toString() + ")";
        }
    }
}