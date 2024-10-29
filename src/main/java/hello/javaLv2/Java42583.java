package hello.javaLv2;

import java.util.LinkedList;
import java.util.Queue;

public class Java42583 {
    // 스택/큐 다리를 지나는 트럭
    // courses/30/lessons/42583
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> onBridgeTime = new LinkedList<>();
        int answer = 0;
        int weightSum = 0;
        int index = 0;
        while(index < truck_weights.length) {
            answer ++;
            if(!onBridgeTime.isEmpty()
                    && onBridgeTime.peek()+bridge_length <= answer) {
                weightSum -= truck_weights[index - onBridgeTime.size()];
                onBridgeTime.poll();
            }
            if(onBridgeTime.size() < bridge_length
                    && weightSum + truck_weights[index] <= weight) {
                onBridgeTime.add(answer);
                weightSum += truck_weights[index];
                index ++;
            }
        }
        answer += bridge_length;

        return answer;
    }
}
