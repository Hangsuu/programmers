package hello.javaLv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Java152996 {
    // 시소 짝꿍
    // courses/30/lessons/152996
    public long solution(int[] weights) {
        Map<Integer, Long> sameWeightCount = new HashMap<>();
        Set<Integer> sameWeight = new HashSet<>();
        long answer = 0L;
        for(int i=0; i<weights.length; i++) {
            if(sameWeightCount.containsKey(weights[i])) {
                sameWeightCount.put(weights[i], sameWeightCount.get(weights[i]) + 1L);
            } else {
                sameWeight.add(weights[i]);
                sameWeightCount.put(weights[i], 1L);
            }
        }

        for(int weight : sameWeight) {
            answer += sameWeightCount.get(weight) * (sameWeightCount.get(weight)-1) / 2;
            if(weight % 2 == 0 && sameWeightCount.containsKey(weight/2)) {
                answer += sameWeightCount.get(weight) * sameWeightCount.get(weight/2);
            }
            if(weight % 3 == 0 && sameWeightCount.containsKey((weight/3)*2)) {
                answer += sameWeightCount.get(weight) * sameWeightCount.get((weight/3)*2);
            }
            if(weight % 4 == 0 && sameWeightCount.containsKey((weight/4)*3)) {
                answer += sameWeightCount.get(weight) * sameWeightCount.get((weight/4)*3);
            }
        }

        return answer;
    }
}
