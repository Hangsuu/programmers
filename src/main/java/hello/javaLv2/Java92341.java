package hello.javaLv2;

import java.util.*;

public class Java92341 {
    // 주차 요금 계산
    // courses/30/lessons/92341
    // 2022 KAKAO BLIND RECRUITMENT
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> timeSum = new HashMap<>();

        for(int i = 0; i < records.length; i++) {
            int hr = Integer.parseInt(records[i].substring(0, 2));
            int min = Integer.parseInt(records[i].substring(3, 5));
            String carNum = records[i].substring(6, 10);
            String status = records[i].substring(11);
            int time = hr*60 + min;
            if("IN".equals(status)) {
                parking.put(carNum, time);
            } else if(parking.containsKey(carNum)) {
                int startTime = parking.get(carNum);
                parking.remove(carNum);
                int timeDif = time - startTime;
                timeSum.put(carNum, timeSum.containsKey(carNum) ? timeSum.get(carNum) + timeDif : timeDif);
            }
        }

        Set<String> notOut = parking.keySet();
        for(String carNum : notOut) {
            int startTime = parking.get(carNum);
            int timeDif = (23*60 + 59) - startTime;
            timeSum.put(carNum, timeSum.containsKey(carNum) ? timeSum.get(carNum) + timeDif : timeDif);
        }

        Set<String> carNumbers = timeSum.keySet();
        List<String> carNumbersForSort = new ArrayList<>();
        for(String carNum : carNumbers) {
            carNumbersForSort.add(carNum);
        }
        Collections.sort(carNumbersForSort);
        answer = new int[carNumbersForSort.size()];
        for(int i=0; i<carNumbersForSort.size(); i++) {
            int timeDif = timeSum.get(carNumbersForSort.get(i));
            int feeTemp = 0;
            if(timeDif <= fees[0]) {
                feeTemp += fees[1];
            } else {
                feeTemp += fees[1] + ((timeDif-fees[0])/fees[2] + ((timeDif-fees[0])%fees[2]==0? 0 : 1)) * fees[3];
            }
            answer[i] = feeTemp;
        }
        return answer;
    }
}
