package hello.javaLv2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Java17680 {
    // 캐시
    // 2018 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/17680
    public int solution(int cacheSize, String[] cities) {
        Set<String> cache = new HashSet<>();
        Queue<String> cacheOrder = new LinkedList<>();

        int answer = 0;
        for(int i=0; i<cities.length; i++) {
            String citiLowerCase = cities[i].toLowerCase();
            if(cache.contains(citiLowerCase)) {
                int currentCacheSize = cacheOrder.size();
                for(int j=0; j<currentCacheSize; j++) {
                    if(cacheOrder.peek().equals(citiLowerCase)) {
                        cacheOrder.poll();
                    } else {
                        cacheOrder.add(cacheOrder.poll());
                    }
                }
                cacheOrder.add(citiLowerCase);
                answer ++;
            } else {
                if(cache.size() == cacheSize) {
                    cache.remove(cacheOrder.poll());
                }
                if(cacheSize > 0) {
                    cache.add(citiLowerCase);
                    cacheOrder.add(citiLowerCase);
                }
                answer += 5;
            }
        }

        return answer;
    }
}
