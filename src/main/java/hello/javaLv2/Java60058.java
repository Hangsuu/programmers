package hello.javaLv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java60058 {
    // 괄호 변환
    // 2020 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/60058
    public String solution(String p) {
        String[] splited = p.split("");

        return "".equals(p) ? "" : changeArray(splited);
    }

    private static List<String[]> seperate(String[] a) {
        List<String[]> arraysList = new ArrayList<>();
        int index = 0;
        int correctCount = 0;
        boolean isStartLeft = a[0].equals("(");
        boolean isCorrect = true;
        while(isCorrect) {
            if (a[index].equals("(")) {
                correctCount ++;
            } else {
                correctCount --;
            }

            if((isStartLeft && correctCount >= 0) || (!isStartLeft && correctCount <= 0)) {
                index ++;
                if(index == a.length || correctCount == 0) {
                    isCorrect = false;
                }
            } else {
                isCorrect = false;
            }
        }

        String[] arr1 = Arrays.copyOfRange(a, 0, index);
        String[] arr2 = Arrays.copyOfRange(a, index, a.length);
        arraysList.add(arr1);
        arraysList.add(arr2);

        return arraysList;
    }

    private static boolean checkCorrect(String[] a) {
        boolean isCorrect = true;
        int correctCount = 0;
        for(int i=0; i < a.length; i++) {
            if(a[i].equals("(")) {
                correctCount ++;
            } else {
                correctCount --;
            }
            if(correctCount < 0) {
                isCorrect = false;
                i = a.length;
            }
        }

        return isCorrect;
    }

    private static boolean checkBalance(String[] a) {
        int correctCount = 0;
        boolean isStartLeft = a.length > 0 ? a[0].equals("(") : true;
        boolean isCorrect = true;
        for(int i=0; i<a.length; i++) {
            if (a[i].equals("(")) {
                correctCount ++;
            } else {
                correctCount --;
            }

            if((isStartLeft && correctCount > 0) || (!isStartLeft && correctCount < 0)) {

            } else {
                i = a.length;
                isCorrect = false;
            }
        }

        return isCorrect;
    }

    private static String changeArray(String[] splited) {
        if (splited.length == 0) {
            return "";
        }
        List<String[]> seperated = seperate(splited);
        String[] a = seperated.get(0);
        String[] b = seperated.get(1);

        if(checkCorrect(a)) {
            String temp = "";
            for(int i=0; i<a.length; i++) {
                temp += a[i];
            }
            return temp + changeArray(b);
        } else {
            String temp = "(";
            temp += changeArray(b);
            temp += ")";
            temp += getReverse(a);
            return temp;
        }
    }

    private static String getReverse(String[] a) {
        String temp = "";
        if(a.length >= 2) {
            for(int i=1; i<a.length-1; i++) {
                if(a[i].equals("(")) {
                    temp += ")";
                } else {
                    temp += "(";
                }
            }
        }
        return temp;
    }
}
