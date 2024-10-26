package hello.javaLv2;

import java.util.Arrays;
import java.util.Collections;

public class Java42587 {
    // 스택/큐 프로세스
    // courses/30/lessons/42587
    public int solution(int[] priorities, int location) {
        int index = 0;
        int newIndex = 0;
        int max = 0;
        Integer[] newPriorities = new Integer[priorities.length];
        boolean[] polled = new boolean[priorities.length];
        for(int i=0; i<priorities.length; i++) {
            newPriorities[i] = priorities[i];
            if (max < priorities[i]) {
                max = priorities[i];
                index = i;
            }
        }

        Arrays.sort(newPriorities, Collections.reverseOrder());

        int answer = 0;
        while(true) {
            if(!polled[index]) {
                if(priorities[index] == newPriorities[newIndex]) {
                    answer ++;
                    if(index == location) {
                        break;
                    } else {
                        polled[index] = true;
                        if(newIndex + 1 == priorities.length) {
                            newIndex = 0;
                        } else {
                            newIndex ++;
                        }
                    }
                }
            }
            if(index + 1 == priorities.length) {
                index = 0;
            } else {
                index ++;
            }
        }

        return answer;
    }
}
