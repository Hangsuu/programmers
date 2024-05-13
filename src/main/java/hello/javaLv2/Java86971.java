package hello.javaLv2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Java86971 {
    // 전력망을 둘로 나누기
    // courses/30/lessons/86971
    private static int answer = 0;
    private static Map<Integer, Set<Integer>> treeMap = new HashMap<>();

    public int solution(int n, int[][] wires) {
        answer = n;
        if(n==2) return 0;

        for(int i=0; i<wires.length; i++) {
            int first = wires[i][0];
            int last = wires[i][1];
            if(treeMap.containsKey(first)) {
                Set<Integer> tempSet = treeMap.get(first);
                tempSet.add(last);
                treeMap.put(first, tempSet);
            } else {
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(last);
                treeMap.put(first, tempSet);
            }
            if(treeMap.containsKey(last)) {
                Set<Integer> tempSet = treeMap.get(last);
                tempSet.add(first);
                treeMap.put(last, tempSet);
            } else {
                Set<Integer> tempSet = new HashSet<>();
                tempSet.add(first);
                treeMap.put(last, tempSet);
            }
        }

        for(int i=0; i<wires.length; i++) {
            int banFirst = wires[i][0];
            int banLast = wires[i][1];
            boolean[] visited = new boolean[n+1];
            int checkIndex = (i+1) % wires.length;

            checkRoute(visited, checkIndex+1, banFirst, banLast);

            int linked = 0;
            for(int j=1; j<n+1; j++) {
                if(visited[j]) {
                    linked ++;
                }
            }

            int tempAnswer = n-linked*2 < 0 ? linked*2 - n : n - linked*2;

            answer = Math.min(tempAnswer, answer);

        }
        return answer;
    }

    private static void checkRoute (boolean[] visited, int start, int banFirst, int banLast) {
        if(!treeMap.containsKey(start)) {
            return;
        }
        for(int index : treeMap.get(start)) {
            if(start == banFirst && index == banLast) {
                continue;
            }
            if(index == banFirst && start == banLast) {
                continue;
            }
            if(!visited[index]) {
                visited[index] = true;
                checkRoute(visited, index, banFirst, banLast);
            }
        }
    }
}
