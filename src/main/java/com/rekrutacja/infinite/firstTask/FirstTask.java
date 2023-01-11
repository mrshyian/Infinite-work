package com.rekrutacja.infinite.firstTask;

import java.util.Arrays;

public class FirstTask {

    public static int StringScanner(String str) {
        if (str == null || str.isEmpty()) return 0; // sprawdzenie czy nie jest string pustym lub null
        char plusOrMinus = str.charAt(str.length()-1);
        if (plusOrMinus != '+' && plusOrMinus != '-') return 0; // sprawdzenie czy ma string "+" lub "-" na końcu

        String strWithoutPlusOrMinus = str.substring(0, str.length()-1); // oddzielony string od snaka na końcu
        String[] afterSplit = strWithoutPlusOrMinus.split("[,.;]"); // posplitowany o każdy znak z zadania

        // jeżeli string ma na początku lub na końcu znak o który splitujemy, to split() stworzy pusty string.
        //stream niżej pozbywa siępustych stringów w zbiorze
        afterSplit = Arrays.stream(afterSplit)
                .filter(val -> (val.length() > 0))
                .toArray(String[]::new);

        // jeżeli na końcu stringa był znak "+" usuwamy "white spaces", parsujemy stringi do integerów i sumujemy ję
        if (plusOrMinus == '+') {
            return Arrays.stream(afterSplit)
                    .map(String :: trim)
                    .mapToInt(Integer:: parseInt)
                    .sum();
        } else {
            // jeżeli na końcu stringa był znak "-" to parsujemy stringi do inetegerów i od pierwszej liczby odejmujemy resztę
            int difference = Integer.parseInt(afterSplit[0].trim());
            for (int i=1; i<afterSplit.length; i++ ){
                difference -= Integer.parseInt(afterSplit[i].trim());
            }
            return difference;
        }
    }
}
