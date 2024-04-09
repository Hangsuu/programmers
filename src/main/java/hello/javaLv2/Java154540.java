package hello.javaLv2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Java154540 {
    // 무인도 여행
    // courses/30/lessons/154540
    // bfs
    public int[] solution(String[] maps) {
        int y = maps.length;
        int x = maps[0].length();
        int[][] mapsNum = new int[y][x];
        boolean[][] visited = new boolean[y][x];
        boolean noIsland = true;
        for(int i=0; i<y; i++) {
            String[] temp = maps[i].split("");
            for(int j=0; j<x; j++) {
                if("X".equals(temp[j])) {
                    mapsNum[i][j] = 0;
                } else {
                    mapsNum[i][j] = Integer.parseInt(temp[j]);
                    visited[i][j] = true;
                    noIsland = false;
                }
            }
        }
        if(noIsland) {
            return new int[]{-1};
        }
        List<Integer> daysList = new ArrayList<>();
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                if(visited[i][j]) {
                    visited[i][j] = false;
                    getDays(mapsNum, visited, i, j, i, j);
                    daysList.add(mapsNum[i][j]);
                }
            }
        }
        daysList.sort(Comparator.naturalOrder());

        int[] answer = new int[daysList.size()];
        for(int i=0; i<daysList.size(); i++) {
            answer[i] = daysList.get(i);
        }
        return answer;
    }
    private static void getDays(int[][] mapNum, boolean[][] visited, int startI, int startJ, int i, int j) {
        if(i-1 >= 0 && visited[i-1][j]) {
            visited[i-1][j] = false;
            mapNum[startI][startJ] += mapNum[i-1][j];
            getDays(mapNum, visited, startI, startJ, i-1, j);
        }
        if(j-1 >= 0 && visited[i][j-1]) {
            visited[i][j-1] = false;
            mapNum[startI][startJ] += mapNum[i][j-1];
            getDays(mapNum, visited, startI, startJ, i, j-1);
        }
        if(i+1 < mapNum.length && visited[i+1][j]) {
            visited[i+1][j] = false;
            mapNum[startI][startJ] += mapNum[i+1][j];
            getDays(mapNum, visited, startI, startJ, i+1, j);
        }
        if(j+1 < mapNum[0].length && visited[i][j+1]) {
            visited[i][j+1] = false;
            mapNum[startI][startJ] += mapNum[i][j+1];
            getDays(mapNum, visited, startI, startJ, i, j+1);
        }
    }
}
