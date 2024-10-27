package hello.javaLv2;

import java.util.ArrayList;
import java.util.List;

public class Java42586 {
    // 기능개발
    // courses/30/lessons/42586
    public int[] solution(int[] progresses, int[] speeds) {
        int progressesDays = 0;
        int[] restDays = new int[progresses.length];

        for(int i=0; i<progresses.length; i++) {
            double restProgresses = 100.0 - progresses[i];
            int restDay = (int) Math.ceil(restProgresses / speeds[i]);
            progressesDays = Math.max(restDay, progressesDays);
            restDays[i] = progressesDays;
        }

        List<Integer> answerList = new ArrayList<>();
        int restDayBefore = restDays[0];
        int count = 1;
        for(int i=1; i<restDays.length; i++) {
            if(restDays[i-1] == restDays[i]) {
                count ++;
            } else {
                answerList.add(count);
                count = 1;
            }
        }
        answerList.add(count);

        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return  answer;
    }
}
