package hello.javaLv2;

import java.util.HashSet;
import java.util.Set;

public class Java42839 {
    // 완전탐색 소수찾기
    // courses/30/lessons/42839
    // 순열
    public int solution(String numbers) {
        Set<Integer> numberSet = new HashSet<>();
        String[] numberArray = numbers.split("");
        for(int i=1; i <= numbers.length(); i++) {
            getNumber(numberArray, numberSet, new boolean[numbers.length()], 0, "", i);
        }

        int answer = 0;
        for(int number : numberSet) {
            if(number > 1) {
                boolean isPrime = true;
                for(int i=2; i <= Math.sqrt(number); i++) {
                    if(number % i == 0) {
                        isPrime = false;
                        i = (int) Math.sqrt(number) + 1;
                    }
                }
                if(isPrime) {
                    answer ++;
                }
            }

        }

        return answer;
    }

    private static void getNumber(String[] numbers, Set<Integer> numberSet, boolean[] visited, int depth, String addedString, int goalLength) {
        if(depth == goalLength && addedString.length() > 0) {
            numberSet.add(Integer.parseInt(addedString));
            return;
        }

        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                getNumber(numbers, numberSet, visited, depth+1, addedString + numbers[i], goalLength);
                visited[i] = false;
            }
        }
    }
}
