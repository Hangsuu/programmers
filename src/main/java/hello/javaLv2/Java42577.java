package hello.javaLv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java42577 {
    // 해시 > 전화번호 목록
    // courses/30/lessons/42577
    // 시간복잡도 고려 못한 풀이
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
        lengthIndex.add(0);
        for(int i=1; i<phone_book.length; i++) {
            if(phone_book[i-1].length() != phone_book[i].length()) {
                lengthIndex.add(i);
            }
        }

        int currentLengthIndex = 1;
        for(int i=0; i<phone_book.length; i++) {
            if(i != 0 && phone_book[i-1].length() != phone_book[i].length()) {
                currentLengthIndex ++;
            }

            if(currentLengthIndex >= lengthIndex.size()) {
                break;
            }
            for(int j=lengthIndex.get(currentLengthIndex); j<phone_book.length; j++) {
                if(phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
