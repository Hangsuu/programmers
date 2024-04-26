package hello.javaLv2;

import java.util.Stack;

public class Java131704 {
    // 택배상자
    // courses/30/lessons/131704
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> belt = new Stack<>();
        int[] boxNum = new int[order.length];
        for(int i=0; i<order.length; i++) {
            boxNum[i] = i+1;
        }
        int boxIndex = 0;
        for(int i=0; i<order.length; i++) {
            while(true) {
                if(boxIndex < order.length && boxNum[boxIndex] == order[i]) {
                    answer ++;
                    boxIndex ++;
                    break;
                } else if (boxIndex < order.length && (belt.isEmpty() || belt.peek() != order[i])) {
                    belt.add(boxNum[boxIndex]);
                    boxIndex++;
                } else if (!belt.isEmpty() && belt.peek() == order[i]) {
                    answer++;
                    belt.pop();
                    break;
                }
                if(boxIndex == order.length) {
                    i = order.length;
                    break;
                }
            }
        }
        return answer;
    }
}
