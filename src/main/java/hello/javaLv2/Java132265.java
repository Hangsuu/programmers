package hello.javaLv2;

import java.util.HashSet;
import java.util.Set;

public class Java132265 {
    // 롤케이크 자르기
    // courses/30/lessons/132265
    public int solution(int[] topping) {
        int answer = 0;
        int n = topping.length;
        int[] toppingLeft = new int[topping.length];
        int[] toppingRight = new int[topping.length];
        Set<Integer> leftNum = new HashSet<>();
        Set<Integer> rightNum = new HashSet<>();

        for(int i=0; i<topping.length; i++) {
            leftNum.add(topping[i]);
            toppingLeft[i] = leftNum.size();
            rightNum.add(topping[n-i-1]);
            toppingRight[n-i-1] = rightNum.size();
        }

        for(int i=1; i<topping.length-1; i++) {
            if(toppingLeft[i] == toppingRight[i+1]) {
                answer ++;
            }
        }
        return answer;
    }
}
