package hello.javaLv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Java258711 {
    // 도넛과 막대 그래프
    // 2024 KAKAO WINTER INTERNSHIP
    // 30/lessons/258711
    private static int maxNum = 0;
    private static List<List<Integer>> graph = new ArrayList<>();
    private static List<Integer> entranceCount = new ArrayList<>();
    private static boolean[] visited;
    public int[] solution(int[][] edges) {
        int donut = 0;
        int stick = 0;
        int eight = 0;
        for(int i=0; i<edges.length; i++) {
            maxNum = Math.max(maxNum, Math.max(edges[i][0], edges[i][1]));
        }
        visited = new boolean[maxNum+1];

        // 초기화
        for(int i=0; i<=maxNum; i++) {
            graph.add(new ArrayList<>());
            entranceCount.add(0);
        }

        for(int i=0; i<edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            entranceCount.set(edges[i][1], entranceCount.get(edges[i][1]) +1);
        }

        int startNum = findStartNum();

        List<Integer> startWay = graph.get(startNum);
        // 정점에서 가는 길의 개수를 없애줌
        for(int i=0; i<startWay.size(); i++) {
            entranceCount.set(startWay.get(i), entranceCount.get(startWay.get(i)) -1);
        }

        for(int i=0; i<startWay.size(); i++) {
            int node = startWay.get(i);
            Queue<Integer> numQ = new LinkedList<>();
            // visited[node] = true;
            while(true) {
                if(graph.get(node).size() == 2 && entranceCount.get(node) == 2) {
                    eight ++;
                    break;
                } else if(graph.get(node).size() == 0) {
                    stick ++;
                    break;
                } else {
                    for(int j=0; j<graph.get(node).size(); j++) {
                        if(!visited[graph.get(node).get(j)]) {
                            numQ.add(graph.get(node).get(j));
                            visited[graph.get(node).get(j)] = true;
                        }
                    }
                    if(numQ.size() > 0) {
                        node = numQ.poll();
                    } else {
                        donut ++;
                        break;
                    }
                }
            }
        }

        int[] answer = new int[4];
        answer[0] = startNum;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        return answer;
    }

    private static int findStartNum() {
        int index = -1;
        for(int i=1; i<=maxNum; i++) {
            if(graph.get(i).size() >= 2 && entranceCount.get(i) == 0) {
                index = i;
                break;
            }
        }
        return index;
    }
}
