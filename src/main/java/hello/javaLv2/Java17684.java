package hello.javaLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java17684 {
    // 압축
    // 2018 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/17684
    public int[] solution(String msg) {
        Map<String, Integer> indexMap = new HashMap<>();
        for(int i=0; i<26; i++) {
            indexMap.put(String.valueOf((char)(65+i)), i+1);
        }
        List<Integer> answerList = new ArrayList<>();

        String[] msgArray = msg.split("");
        for(int i=0; i<msgArray.length; i++) {
            String temp = "";
            int index = 0;
            while(i+index < msgArray.length && indexMap.containsKey(temp + msgArray[i+index])) {
                temp += msgArray[i+index];
                index ++;
            }
            answerList.add(indexMap.get(temp));
            if(i+index < msgArray.length) {
                indexMap.put(temp + msgArray[i+index], indexMap.keySet().size() + 1);
            }
            i+=index-1;
        }
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
