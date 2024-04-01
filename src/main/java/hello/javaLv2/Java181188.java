package hello.javaLv2;

import java.util.ArrayList;
import java.util.List;

public class Java181188 {
    // 요격 시스템
    // courses/30/lessons/181188
    public int solution(int[][] targets) {
        int targetNum = targets.length;

        List<List<Integer>> targetsList = new ArrayList<>();

        for(int i=0; i<targetNum; i++) {
            List<Integer> tempArray = new ArrayList<>();
            tempArray.add(targets[i][0]);
            tempArray.add(targets[i][1]);
            targetsList.add(tempArray);
        }

        targetsList.sort((target1, target2) -> {
            if(target1.get(0) == target2.get(0)) {
                return target1.get(0) - target2.get(0);
            } else {
                return target1.get(1) - target2.get(1);
            }
        });
        int answer = 0;
        int s = 0;
        for(int i=0; i<targetNum; i++) {
            if(s <= targetsList.get(i).get(0)) {
                answer ++;
                s = targetsList.get(i).get(1);
            }
        }
        return answer;
    }
}
