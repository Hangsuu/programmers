package hello.javaLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java42888 {
    // 오픈채팅방
    // 2019 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/42888
    public String[] solution(String[] record) {
        Map<String, String> uidName = new HashMap<>();
        List<String[]> resultList = new ArrayList<>();

        for(int i=0; i<record.length; i++) {
            String[] recordInfo = record[i].split(" ");
            if("Enter".equals(recordInfo[0])) {
                String[] resultRecord = {recordInfo[1], "님이 들어왔습니다."};
                resultList.add(resultRecord);
                uidName.put(recordInfo[1], recordInfo[2]);
            } else if("Leave".equals(recordInfo[0])) {
                String[] resultRecord = {recordInfo[1], "님이 나갔습니다."};
                resultList.add(resultRecord);
            } else {
                uidName.put(recordInfo[1], recordInfo[2]);
            }
        }
        String[] answer = new String[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            answer[i] = uidName.get(resultList.get(i)[0]) + resultList.get(i)[1];
        }
        return answer;
    }
}
