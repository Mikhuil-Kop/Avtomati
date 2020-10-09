package com.company;

import java.util.*;

public class MainVariant2 {

    public static void main(String[] args) {
        final int START = 0;

        final int H_FIRST_LIMITED = 1;
        final int H_FIRST = 2;
        final int H_SECOND = 3;
        final int H_DOT = 4;

        final int M_FIRST_LIMITED = 5;
        final int M_FIRST = 6;
        final int M_SECOND = 7;
        final int M_DOT = 8;

        final int S_FIRST_LIMITED = 9;
        final int S_FIRST = 10;
        final int S_SECOND = 11;

        List<Character> lessThanTwo = Arrays.asList('0', '1');
        List<Character> fourAndLess = Arrays.asList('0', '1', '2', '3', '4');
        List<Character> lessThanSix = Arrays.asList('0', '1', '2', '3', '4', '5');
        List<Character> allNumbers = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> two = Collections.singletonList('2');
        List<Character> six = Collections.singletonList('6');
        List<Character> zero = Collections.singletonList('0');
        List<Character> dots = Collections.singletonList(':');

        Set<Integer> endStates = Collections.singleton(S_SECOND);


        StateMachine sm = new StateMachine(START, endStates);

        //часы
        sm.add(START, two, H_FIRST_LIMITED);
        sm.add(START, lessThanTwo, H_FIRST);

        sm.add(H_FIRST_LIMITED, fourAndLess, H_SECOND);
        sm.add(H_FIRST, allNumbers, H_SECOND);

        sm.add(H_SECOND, dots, H_DOT);

        //минуты
        sm.add(H_DOT, six, M_FIRST_LIMITED);
        sm.add(H_DOT, lessThanSix, M_FIRST);

        sm.add(M_FIRST_LIMITED, zero, M_SECOND);
        sm.add(M_FIRST, allNumbers, M_SECOND);

        sm.add(M_SECOND, dots, M_DOT);

        //секунды
        sm.add(M_DOT, six, S_FIRST_LIMITED);
        sm.add(M_DOT, lessThanSix, S_FIRST);

        sm.add(S_FIRST_LIMITED, zero, S_SECOND);
        sm.add(S_FIRST, allNumbers, S_SECOND);

        //Костыль. Иначе StateMachine из методички будет выдавать ошибку раньше, чем распознает, что последний символ найден.
        sm.add(S_SECOND, ';', S_SECOND);



// Поиск всех вхождений в строке:
        String inputString = "\"27:09:65 23:00:55 22:65:05 21:21:21 23:32:77 23:32:60";
        sm.findAll(inputString);
    }
}
