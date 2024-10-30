package hello.javaLv2;

import java.util.*;

public class Java42577 {
    // 해시 > 전화번호 목록
    // courses/30/lessons/42577
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (a, b) -> {
            if(a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                for(int i=0; i<a.length(); i++) {
                    if(a.charAt(i) == b.charAt(i)) {
                        continue;
                    } else {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return 0;
            }
        });

        List<Integer> lengthIndex = new ArrayList<>();
        lengthIndex.add(phone_book[0].length());
        for(int i=1; i<phone_book.length; i++) {
            if(phone_book[i-1].length() != phone_book[i].length()) {
                lengthIndex.add(phone_book[i].length());
            }
        }

        Set<String> numberSet = new HashSet<>();
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<lengthIndex.size(); j++) {
                if(lengthIndex.get(j) <= phone_book[i].length()) {
                    String subString = phone_book[i].substring(0, lengthIndex.get(j));
                    if(numberSet.contains(subString)) {
                        return false;
                    }
                } else {
                    numberSet.add(phone_book[i]);
                    j = lengthIndex.size();
                }
            }
        }

        return true;
    }
}
