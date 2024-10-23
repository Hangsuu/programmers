package hello.javaLv2;

import java.util.Arrays;

public class Java42747 {
    // H-Index
    // courses/30/lessons/42747
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for(int i=0; i<citations.length; i++) {
            int currentIndex = citations.length - i;
            if(currentIndex <= citations[i] ) {
                answer = currentIndex;
                i = citations.length;
            }
        }

        return answer;
    }
}
