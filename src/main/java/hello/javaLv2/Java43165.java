package hello.javaLv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java43165 {
    // 타겟 넘버
    // courses/30/lessons/43165
    public int solution(int[] numbers, int target) {
        int answer = 0;
        Map<Integer, Integer> numberMap = new HashMap<>();
        numberMap.put(numbers[0], 1);
        numberMap.put(-numbers[0], 1);
        for (int i=1; i<numbers.length; i++) {
            int currentNumber = numbers[i];
            List<Integer> numberList = new ArrayList<>(numberMap.keySet());
            Map<Integer, Integer> newNumberMap = new HashMap<>();
            for(int j=0; j<numberList.size(); j++) {
                int calculatedNumber = numberList.get(j);
                int plusNumber = numberList.get(j) + currentNumber;
                int minusNumber = numberList.get(j) - currentNumber;

                if(i==numbers.length - 1
                        && (plusNumber == target || minusNumber == target)) {
                    answer += numberMap.get(calculatedNumber);
                } else {
                    if (newNumberMap.containsKey(plusNumber)) {
                        newNumberMap.put(plusNumber, newNumberMap.get(plusNumber)+numberMap.get(calculatedNumber));
                    } else {
                        newNumberMap.put(plusNumber, numberMap.get(calculatedNumber));
                    }
                    if (newNumberMap.containsKey(minusNumber)) {
                        newNumberMap.put(minusNumber, newNumberMap.get(minusNumber)+numberMap.get(calculatedNumber));
                    } else {
                        newNumberMap.put(minusNumber, numberMap.get(calculatedNumber));
                    }
                }
            }
            numberMap = newNumberMap;
        }
        return answer;
    }
}
