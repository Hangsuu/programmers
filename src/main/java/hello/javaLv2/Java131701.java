package hello.javaLv2;

import java.util.HashSet;
import java.util.Set;

public class Java131701 {
    // 연속 부분 수열 합의 개수
    // courses/30/lessons/131701
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> sum = new HashSet<>();
        int[] elementsSum = new int[n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                elementsSum[j] += elements[(j+i)%n];
                sum.add(elementsSum[j]);
            }
        }

        int answer = sum.size();
        return answer;
    }
}
