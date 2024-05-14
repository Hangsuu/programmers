package hello.javaLv2;

import java.util.HashMap;
import java.util.Map;

public class Java84512 {
    // 모음사전
    // courses/30/lessons/84512
    public int solution(String word) {
        int answer = 0;
        Map<String, Integer> alphabetMap = new HashMap<>();
        alphabetMap.put("A", 0);
        alphabetMap.put("E", 1);
        alphabetMap.put("I", 2);
        alphabetMap.put("O", 3);
        alphabetMap.put("U", 4);

        String[] words = word.split("");
        for(int i=0; i<words.length; i++) {
            if(i==0) {
                answer += 781 * alphabetMap.get(words[i]) + 1;
            } else if(i==1) {
                answer += 156 * alphabetMap.get(words[i]) + 1;
            } else if(i==2) {
                answer += 31 * alphabetMap.get(words[i]) + 1;
            } else if(i==3) {
                answer += 6 * alphabetMap.get(words[i]) + 1;
            } else if(i==4) {
                answer += alphabetMap.get(words[i]) + 1;
            }
        }

        return answer;
    }
}
