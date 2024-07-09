package hello.javaLv2;

import java.util.*;

public class Java72412 {
    // 순위 검색
    // 이진탐색
    // courses/30/lessons/72412
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> candidates = new HashMap<>();

        for (int i=0; i<info.length; i++) {
            String[] person = info[i].split(" ");
            for(int j=1; j<=16; j++) {
                String personInfo = ((j/8)%2==0 ? person[0] : "-")
                        + ((j/4)%2==0 ? person[1] : "-")
                        + ((j/2)%2==0 ? person[2] : "-")
                        + (j%2==0 ? person[3] : "-");
                if(candidates.containsKey(personInfo)) {
                    List<Integer> tempList = candidates.get(personInfo);
                    tempList.add(Integer.parseInt(person[4]));
                    candidates.put(personInfo, tempList);
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(Integer.parseInt(person[4]));
                    candidates.put(personInfo, tempList);
                }
            }
        }

        for (List<Integer> list : candidates.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++) {
            String[] require = query[i].split(" ");
            String findKey = require[0] + require[2]
                    + require[4] + require[6];

            int score = Integer.parseInt(require[7]);

            if (candidates.containsKey(findKey)) {
                List<Integer> numberList = candidates.get(findKey);
                // 이진 탐색으로 score 이상의 개수 찾기
                int left = 0, right = numberList.size();
                while (left < right) {
                    int mid = (left + right) / 2;
                    if (numberList.get(mid) < score) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                answer[i] = numberList.size() - left;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }
}
