package hello.java;

import java.util.ArrayList;
import java.util.List;

public class Java258711 {
    // 도넛과 막대 그래프
    // 2024 KAKAO WINTER INTERNSHIP
    // 30/lessons/258711
    private static int donut = 0;
    private static int stick = 0;
    private static int eight = 0;
    private static int startNum = 0;
    private static boolean[][] way;
    public int[] solution(int[][] edges) {
        int maxNum = 0;
        startNum = edges[0][0];
        for(int i=0; i<edges.length; i++) {
            maxNum = Math.max(edges[i][0], maxNum);
            maxNum = Math.max(edges[i][1], maxNum);
        }
        way = new boolean[maxNum+1][maxNum+1];
        for(int i=0; i<edges.length; i++) {
            way[edges[i][0]][edges[i][1]] = true;
        }
        check(startNum, 0);

        int[] answer = new int[4];
        answer[0] = startNum;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        for(int i=0; i<4; i++) {
            System.out.print(answer[i] + " ");
        }
        return answer;
    }

    private static void check(int startFrom, int node) {
        List<Integer> wayList = new ArrayList<>();

        for(int i=1; i<way.length; i++) {
            if(way[startFrom][i]) {
                wayList.add(i);
            }
        }
        if (wayList.size() == 0 && startFrom != node) {
            stick ++;
        } else if (wayList.size() == 0 && startFrom == node){
            donut ++;
        } else if (wayList.size() == 1) {
            check(startFrom, wayList.get(0));
        } else if (wayList.size() == 2) {

        } else {
            for(int i=0; i<wayList.size(); i++) {
                check(node, wayList.get(i));
            }
        }
    }
}
