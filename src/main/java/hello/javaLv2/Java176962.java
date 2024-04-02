package hello.javaLv2;

import java.util.Arrays;
import java.util.Stack;

public class Java176962 {
    // 과제 진행하기
    // courses/30/lessons/176962
    public String[] solution(String[][] plans) {
        int size = plans.length;
        Stack<String[]> homeWork = new Stack<>();
        int currentTime = 24*60;
        for(int i=0; i<size; i++) {
            String[] tempTime = plans[i][1].split(":");
            int tempMin = Integer.parseInt(tempTime[0])*60 + Integer.parseInt(tempTime[1]);
            currentTime = Math.min(tempMin, currentTime);
            plans[i][1] = String.valueOf(tempMin);
        }
        Arrays.sort(plans, (plan1, plan2) -> {
            return Integer.parseInt(plan1[1]) - Integer.parseInt(plan2[1]);
        });

        String[] answer = new String[size];
        int index = 0;
        for(int i=0; i<size; i++) {
            int nextTimeStart = 0;
            if(i != size-1) {
                nextTimeStart = Integer.parseInt(plans[i+1][1]);
            }
            // 과제를 다 끝내지 못할 경우
            if(i != size-1
                    && Integer.parseInt(plans[i][1]) + Integer.parseInt(plans[i][2]) >
                    Integer.parseInt(plans[i+1][1])) {
                String[] tempString = new String[2];
                tempString[0] = plans[i][0];
                tempString[1] = String.valueOf(Integer.parseInt(plans[i][1])
                        + Integer.parseInt(plans[i][2])
                        - nextTimeStart);
                homeWork.add(tempString);
                currentTime = nextTimeStart;
            } else {
                // 과제를 다 끝낼 경우
                answer[index] = plans[i][0];
                index ++;
                currentTime += Integer.parseInt(plans[i][2]);
                // 시간이 남을 경우
                if(i != size-1 && currentTime < nextTimeStart) {
                    while(!homeWork.isEmpty() && currentTime < nextTimeStart) {
                        // 남아있는 과제 수행을 해도 시간이 남는 경우
                        if(Integer.parseInt(homeWork.peek()[1]) + currentTime <= nextTimeStart) {
                            String[] currentHomeWork = homeWork.pop();
                            answer[index] = currentHomeWork[0];
                            index++;
                            currentTime += Integer.parseInt(currentHomeWork[1]);
                            // 남아있는 과제 수행 시 시간이 부족한 경우
                        } else if(currentTime < nextTimeStart) {
                            String[] currentHomeWork = homeWork.pop();
                            currentHomeWork[1] =
                                    String.valueOf(Integer.parseInt(currentHomeWork[1])
                                            +currentTime-nextTimeStart);
                            homeWork.add(currentHomeWork);
                            currentTime = nextTimeStart;
                        } else {
                            break;
                        }

                    }
                }
            }
        }
        while(!homeWork.isEmpty()) {
            answer[index] = homeWork.pop()[0];
            index++;
        }
        return answer;
    }
}
