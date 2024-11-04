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
            // 숫자 그룹을 분리하면서 보존하기 위한 정규식 패턴
            Pattern pattern = Pattern.compile("\\d+|[^\\d]+");
            Matcher matcherA = pattern.matcher(a);
            Matcher matcherB = pattern.matcher(b);

            List<String> partsA = new ArrayList<>();
            while (matcherA.find()) {
                partsA.add(matcherA.group());
            }

            List<String> partsB = new ArrayList<>();
            while (matcherB.find()) {
                partsB.add(matcherB.group());
            }

            if(!partsA.get(0).toLowerCase().equals(partsB.get(0).toLowerCase())) {
                return partsA.get(0).toLowerCase().compareTo(partsB.get(0).toLowerCase());
            } else if (Integer.parseInt(partsA.get(1)) != Integer.parseInt(partsB.get(1))) {
                return Integer.parseInt(partsA.get(1)) - Integer.parseInt(partsB.get(1));
            } else {
                return 0;
            }
        });
        return files;
    }
}
