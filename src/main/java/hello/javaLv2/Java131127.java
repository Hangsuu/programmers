package hello.javaLv2;

import java.util.HashMap;
import java.util.Map;

public class Java131127 {
    // 할인 행사
    // courses/30/lessons/131127
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int[] checkNumber = new int[number.length];

        Map<String, Integer> wantIndex = new HashMap<>();
        for(int i=0; i<want.length; i++) {
            wantIndex.put(want[i], i);
        }

        for(int i=0; i<discount.length; i++) {
            if(i < 10 && wantIndex.get(discount[i]) != null) {
                checkNumber[wantIndex.get(discount[i])] ++;
            } else if(wantIndex.get(discount[i]) != null && i >= 10 && wantIndex.get(discount[i-10]) != null) {
                checkNumber[wantIndex.get(discount[i])] ++;
                checkNumber[wantIndex.get(discount[i-10])] --;
            } else if(wantIndex.get(discount[i]) != null && wantIndex.get(discount[i-10]) == null) {
                checkNumber[wantIndex.get(discount[i])] ++;
            } else if(i >= 10 && wantIndex.get(discount[i]) == null && wantIndex.get(discount[i-10]) != null) {
                checkNumber[wantIndex.get(discount[i-10])] --;
            }
            if(isSale(number, checkNumber)) {
                answer ++;
            }
        }
        return answer;
    }

    private static boolean isSale(int[] number, int[] checkNumber) {
        for(int i=0; i<number.length; i++) {
            if(number[i] > checkNumber[i]) {
                return false;
            }
        }
        return true;
    }
}
