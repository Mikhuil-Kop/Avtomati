package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        final int START = 0;
        final int UPPER = 1;

        String str = "QWERTYUIOPASDFGHJKLZXCVBNM";
        List<Character> chars = new java.util.ArrayList<>(Collections.emptyList());
        for (int i = 0; i < str.length(); i++)
            chars.add(str.charAt(i));

        Set<Integer> endStates = Collections.singleton(UPPER);
        StateMachine sm = new StateMachine(START, endStates);

        sm.add(START, chars, UPPER);
        sm.add(UPPER, chars, UPPER);

// Поиск всех вхождений в строке:
        String inputString = "\"/Applications/IntelliJ IDEA CE.app/Contents/jbr/Contents/Home/bin/java\" \"-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=63457:/Applications/IntelliJ IDEA CE.app/";
        sm.findAll(inputString);
    }
}