package hello.javaLv2;

import java.util.PriorityQueue;

public class Java42626 {
    // 더 맵게
    // 힙정렬, 우선순위 큐
    // courses/30/lessons/42626
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++) {
            pQ.add(scoville[i]);
        }

        int answer = 0;
        while(pQ.size() > 0 && pQ.peek() < K) {
            if(pQ.size() == 1) {
                answer = -1;
                break;
            }

            int newScoville = pQ.poll() + pQ.poll() * 2;
            pQ.add(newScoville);

            answer ++;
        }
        return answer;
    }
}
