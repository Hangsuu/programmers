package hello.javaLv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Java17686 {
    // 파일명 정렬
    // 2018 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/17686
    public String[] solution(String[] files) {
        Arrays.sort(files, (a, b) -> {
            String[] partsA = new String[2];
            partsA[0] = a.split("\\d")[0];
            partsA[1] = a.split("\\D+")[1];

            String[] partsB = new String[2];
            partsB[0] = b.split("\\d")[0];
            partsB[1] = b.split("\\D+")[1];

            if(!partsA[0].toLowerCase().equals(partsB[0].toLowerCase())) {
                return partsA[0].toLowerCase().compareTo(partsB[0].toLowerCase());
            } else if (Integer.parseInt(partsA[1]) != Integer.parseInt(partsB[1])) {
                return Integer.parseInt(partsA[1]) - Integer.parseInt(partsB[1]);
            } else {
                return 0;
            }
        });
        return files;
    }
}
