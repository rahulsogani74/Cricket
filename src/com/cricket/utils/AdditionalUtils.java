package com.cricket.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * yha pr teams ko 2 group ke liy alg alg kiya gya h ...
 *  taaki teams ka 2 group bnaya ja ske.
 */
public class AdditionalUtils {

    public static List[] splitInTwoParts(List<String> list) {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        int size = list.size();
        for (int i = 0; i < size / 2; i++)
            first.add(list.get(i));
        for (int i = size / 2; i < size; i++)
            second.add(list.get(i));
        return new List[] { first, second };
    }

    /**
     * Return any random number sometime 1 or sometime 0
     */
    public static Integer getRandom() {
        Random rand = new Random();
        final int randomNumber = rand.nextInt(1000);
        return randomNumber % 2;
    }
}
