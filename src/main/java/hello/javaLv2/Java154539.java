package hello.javaLv2;

import java.util.Arrays;
import java.util.Stack;

public class Java154539 {
    // 뒤에 있는 큰 수 찾기
    // courses/30/lessons/154539
    public int[] solution(int[] numbers) {
        Stack<Integer> index = new Stack<>();
        int n = numbers.length;

        int[] answer = new int[n];
        index.add(numbers[n-1]);
        Arrays.fill(answer, -1);

        for(int i=n-1; i>=0; i--) {
            while(!index.isEmpty() && index.peek() <= numbers[i]) {
                index.pop();
            }

            if(!index.isEmpty() && index.peek() > numbers[i]) {
                answer[i] = index.peek();
            }
            index.add(numbers[i]);
        }

        return answer;
    }
}
