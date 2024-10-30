package hello.javaLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java42578 {
    // 해시 > 의상
    // courses/30/lessons/42578
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            if (clothesMap.containsKey(clothes[i][1])) {
                clothesMap.put(clothes[i][1], clothesMap.get(clothes[i][1]) + 1);
            } else {
                clothesMap.put(clothes[i][1], 1);
            }
        }
        int answer = 1;

        for(Integer count : clothesMap.values()) {
            answer *= count + 1;
        }
        return answer-1;
    }
}
