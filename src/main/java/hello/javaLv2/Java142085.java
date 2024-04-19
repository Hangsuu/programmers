package hello.javaLv2;

import java.util.PriorityQueue;

public class Java142085 {
    // 디펜스 게임
    // 그리디
    // courses/30/lessons/142085
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> kQ = new PriorityQueue<>();
        for(int i=0; i<enemy.length; i++) {
            if(kQ.size() < k) {
                kQ.add(enemy[i]);
                answer++;
                continue;
            }

            if(kQ.peek() < enemy[i] && n >= kQ.peek()) {
                n -= kQ.poll();
                kQ.add(enemy[i]);
                answer ++;
            } else if(n >= enemy[i]) {
                answer ++;
                n -= enemy[i];
            } else {
                i = enemy.length;
            }
        }
        return answer;
    }
}
