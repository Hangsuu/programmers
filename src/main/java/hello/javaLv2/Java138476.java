package hello.javaLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java138476 {
    // 귤 고르기
    // courses/30/lessons/138476
    public int solution(int k, int[] tangerine) {
        List<Integer> tangerineList = new ArrayList<>();
        Map<Integer, Integer> tangerineIndex = new HashMap<>();

        for(int i=0; i<tangerine.length; i++) {
            if(tangerineIndex.get(tangerine[i]) != null) {
                int index = tangerineIndex.get(tangerine[i]);
                tangerineList.set(index, tangerineList.get(index)+1);
            } else {
                List<Integer> tempList = new ArrayList<>();
                tangerineList.add(1);
                tangerineIndex.put(tangerine[i], tangerineList.size() -1);
            }
        }
        tangerineList.sort((a, b) -> b-a);

        int answer = 0;
        int index = 0;
        while(k > 0) {
            if(k >= tangerineList.get(index)) {
                k -= tangerineList.get(index);
                answer ++;
                index ++;
            } else {
                answer ++;
                k = 0;
            }
        }
        return answer;
    }
}
