package hello.javaLv2;

import java.util.Stack;

public class Java42883 {
    // 큰 수 만들기
    // courses/30/lessons/42883
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        int removeCount = k;

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            while (!stack.isEmpty() && removeCount > 0 && stack.peek() < digit) {
                stack.pop();
                removeCount--;
            }
            stack.push(digit);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().substring(0, number.length() - k);

    }
}
