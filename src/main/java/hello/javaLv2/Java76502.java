package hello.javaLv2;

import java.util.Stack;

public class Java76502 {
    // 괄호 회전하기
    // courses/30/lessons/76502
    public int solution(String s) {
        int answer = 0;
        String[] words = s.split("");

        for(int i=0; i<words.length; i++) {
            int smallCount = 0;
            int middleCount = 0;
            int largeCount = 0;
            // 0 : (, 1 : {, 2 : [
            Stack<Integer> lastStartIndex = new Stack<>();
            for(int j=0; j<words.length; j++) {
                int index = (i+j) % words.length;
                if (words[index].equals("(")) {
                    lastStartIndex.add(index);
                    smallCount ++;
                } else if (words[index].equals(")")) {
                    smallCount --;
                    if(lastStartIndex.size() > 0) {
                        int lastIndex = lastStartIndex.pop();
                        if(smallCount < 0 || !"(".equals(words[lastIndex])) {
                            smallCount = -1;
                            j = words.length;
                        }
                    } else {
                        smallCount = -1;
                        j = words.length;
                    }

                } else if (words[index].equals("{")) {
                    lastStartIndex.add(index);
                    middleCount ++;
                } else if (words[index].equals("}")) {
                    middleCount --;
                    if(lastStartIndex.size() > 0) {
                        int lastIndex = lastStartIndex.pop();
                        if(middleCount < 0 || !"{".equals(words[lastIndex])) {
                            middleCount = -1;
                            j = words.length;
                        }
                    } else {
                        middleCount = -1;
                        j = words.length;
                    }

                } else if (words[index].equals("[")) {
                    lastStartIndex.add(index);
                    largeCount ++;
                } else {
                    largeCount --;
                    if(lastStartIndex.size() > 0) {
                        int lastIndex = lastStartIndex.pop();
                        if(largeCount < 0 || !"[".equals(words[lastIndex])) {
                            largeCount = -1;
                            j = words.length;
                        }
                    } else {
                        largeCount = -1;
                        j = words.length;
                    }
                }
            }
            if (smallCount == 0 && middleCount == 0 && largeCount == 0) {
                answer ++;
            }
        }
        return answer;
    }
}
