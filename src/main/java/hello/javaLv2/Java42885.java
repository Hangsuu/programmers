package hello.javaLv2;

import java.util.ArrayList;
import java.util.List;

public class Java42885 {
    // 구명보트
    // courses/30/lessons/42885
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> peopleList = new ArrayList<>();
        for(int i=0; i<people.length; i++) {
            peopleList.add(people[i]);
        }
        peopleList.sort((a, b) -> a-b);

        int startIndex = 0;
        int endIndex = people.length - 1;

        while(startIndex <= endIndex) {
            if(startIndex == endIndex) {
                answer ++;
                endIndex --;
                startIndex ++;
            } else if (peopleList.get(startIndex) + peopleList.get(endIndex) > limit) {
                endIndex --;
                answer ++;
            } else {
                endIndex --;
                startIndex ++;
                answer ++;
            }

        }

        return answer;
    }
}
