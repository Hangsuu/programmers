package hello.javaLv2;

import java.util.ArrayList;
import java.util.List;

public class Java172927 {
    // 광물 캐기
    // courses/30/lessons/172927
    // 그리디 알고리즘
    public int solution(int[] picks, String[] minerals) {
        int picksCount = 0;
        for(int i=0; i<3; i++) {
            picksCount += picks[i];
        }
        int pickNeed = (int) Math.ceil(minerals.length / 5.0);
        int mineralBound = Math.min(picksCount, pickNeed);
        List<List<Integer>> mineralScore = new ArrayList<>();
        for(int i=0; i<mineralBound; i++) {
            mineralScore.add(new ArrayList<>());
            mineralScore.get(i).add(0);
            for(int j=0; j<5; j++) {
                if(i*5 + j < minerals.length) {
                    if (minerals[i*5 + j].equals("diamond")) {
                        mineralScore.get(i).set(0, mineralScore.get(i).get(0) +25);
                        mineralScore.get(i).add(1);
                    } else if (minerals[i*5 + j].equals("iron")){
                        mineralScore.get(i).set(0, mineralScore.get(i).get(0) +5);
                        mineralScore.get(i).add(2);
                    } else {
                        mineralScore.get(i).set(0, mineralScore.get(i).get(0) +1);
                        mineralScore.get(i).add(3);
                    }
                }
            }
        }
        mineralScore.sort((a, b) -> {
            return b.get(0) - a.get(0);
        });
        int answer = 0;
        for(int j=0; j<mineralBound; j++) {
            List<Integer> tempList = mineralScore.get(j);
            if(picks[0] > 0) {
                picks[0] --;
                for(int i=1; i<tempList.size(); i++) {
                    if(tempList.get(i) == 1) {
                        answer += 1;
                    } else if (tempList.get(i) == 2) {
                        answer += 1;
                    } else {
                        answer += 1;
                    }
                }
            } else if(picks[1] > 0) {
                picks[1] --;
                for(int i=1; i<tempList.size(); i++) {
                    if(tempList.get(i) == 1) {
                        answer += 5;
                    } else if (tempList.get(i) == 2) {
                        answer += 1;
                    } else {
                        answer += 1;
                    }
                }
            } else {
                picks[2] --;
                for(int i=1; i<tempList.size(); i++) {
                    if(tempList.get(i) == 1) {
                        answer += 25;
                    } else if (tempList.get(i) == 2) {
                        answer += 5;
                    } else {
                        answer += 1;
                    }
                }
            }
        }


        return answer;
    }
}
