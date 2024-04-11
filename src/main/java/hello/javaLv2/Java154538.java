package hello.javaLv2;

import java.util.LinkedList;
import java.util.Queue;

public class Java154538 {
    // 숫자 변환하기
    // courses/30/lessons/154538
    public int solution(int x, int y, int n) {
        if(x == y) {
            return 0;
        }
        int[] yCount = new int[y+1];

        Queue<Integer> index = new LinkedList<>();
        index.add(x);
        while(yCount[n] == 0 && !index.isEmpty()) {
            int startNum = index.poll();
            int startCount = yCount[startNum];
            int length = yCount.length;
            if(startNum * 3 < length && (yCount[startNum*3] == 0 || yCount[startNum*3] > startCount + 1)) {
                yCount[startNum*3] = startCount + 1;
                index.add(startNum*3);
            }
            if(startNum * 2 < length && (yCount[startNum*2] == 0 || yCount[startNum*2] > startCount + 1)) {
                yCount[startNum*2] = startCount + 1;
                index.add(startNum*2);
            }
            if(startNum + n < length && (yCount[startNum + n] == 0 || yCount[startNum + n] > startCount + 1)) {
                yCount[startNum + n] = startCount + 1;
                index.add(startNum + n);
            }
        }

        int answer = yCount[y] == 0 ? -1 : yCount[y];
        return answer;

    }
}
