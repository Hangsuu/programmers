package hello.javaLv2;

import java.util.Stack;

public class Java42584 {
    // 스택/큐 주식가격
    // courses/30/lessons/42584
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> priceStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        priceStack.add(prices[0]);
        indexStack.add(0);

        for(int i=1; i<prices.length-1; i++) {
            int currentNum = prices[i];
            while(priceStack.size() > 0 && priceStack.peek() > currentNum) {
                int index= indexStack.pop();
                answer[index] = i-index;
                priceStack.pop();
            }
            priceStack.add(currentNum);
            indexStack.add(i);
        }
        while(priceStack.size() > 0) {
            int index= indexStack.pop();
            answer[index] = prices.length -1 -index;
            priceStack.pop();
        }
        return answer;
    }
}
