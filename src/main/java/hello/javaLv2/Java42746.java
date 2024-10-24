package hello.javaLv2;

import java.util.Arrays;

public class Java42746 {
    // 정렬 가장 큰 수
    // courses/30/lessons/42746
    public String solution(int[] numbers) {
        String[] numbersString = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            numbersString[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbersString, (a, b) ->
                Integer.parseInt(b+a) - Integer.parseInt(a+b)
        );

        String answer = "";
        if("0".equals(numbersString[0])) {
            answer = "0";
        } else {
            for(int i=0; i<numbersString.length; i++) {
                answer += numbersString[i];
            }
        }

        return answer;
    }
}
