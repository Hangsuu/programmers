package hello.javaLv2;

import java.util.LinkedList;
import java.util.Queue;

public class Java159993 {
    // 미로 탈출
    // bfs
    // courses/30/lessons/159993
    public int solution(String[] maps) {
        int y = maps.length;
        int x = maps[0].length();
        int[][] leverCount = new int[y][x];
        int[][] exitCount = new int[y][x];
        String[][] mapArray = new String[y][x];
        int startX = 0;
        int startY = 0;
        int exitX = 0;
        int exitY = 0;
        int leverX = 0;
        int leverY = 0;
        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                leverCount[i][j] = -1;
                exitCount[i][j] = -1;
            }
        }
        for(int i=0; i<y; i++) {
            String [] temp = maps[i].split("");
            for(int j=0; j<x; j++) {
                mapArray[i][j] = temp[j];
                if("S".equals(mapArray[i][j])) {
                    startX = j;
                    startY = i;
                }
                if("E".equals(mapArray[i][j])) {
                    exitX = j;
                    exitY = i;
                }
                if("L".equals(mapArray[i][j])) {
                    leverX = j;
                    leverY = i;
                }
            }
        }
        leverCount[startY][startX] = 0;
        exitCount[leverY][leverX] = 0;
        bfs(leverCount, mapArray, startX, startY);
        bfs(exitCount, mapArray, leverX, leverY);
        // for(int i=0; i<y; i++) {
        //     for(int j=0; j<x; j++) {
        //         System.out.print(leverCount[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        // System.out.println("---------------");
        // for(int i=0; i<y; i++) {
        //     for(int j=0; j<x; j++) {
        //         System.out.print(exitCount[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        if(leverCount[leverY][leverX] == -1 || exitCount[exitY][exitX] == -1) {
            return -1;
        } else {
            return leverCount[leverY][leverX] + exitCount[exitY][exitX];
        }
    }

    private static void bfs(int[][] countArr, String[][] mapArray, int inputX, int inputY) {
        Queue<int[]> wayQ = new LinkedList<>();
        wayQ.add(new int[]{inputX, inputY});
        while(!wayQ.isEmpty()) {
            int[] temp = wayQ.poll();
            int x = temp[0];
            int y = temp[1];
            int wayCount = countArr[y][x] == -1 ? 0 : countArr[y][x];
            if(x-1 >= 0
                    && (countArr[y][x-1] == -1 || countArr[y][x-1] > wayCount + 1)
                    && !"X".equals(mapArray[y][x-1])) {
                countArr[y][x-1] = wayCount + 1;
                wayQ.add(new int[]{x-1, y});
            }
            if(y-1 >= 0
                    && (countArr[y-1][x] == -1 || countArr[y-1][x] > wayCount + 1)
                    && !"X".equals(mapArray[y-1][x])) {
                countArr[y-1][x] = wayCount + 1;
                wayQ.add(new int[]{x, y-1});
            }
            if(x+1 < mapArray[0].length
                    && (countArr[y][x+1] == -1 || countArr[y][x+1] > wayCount + 1)
                    && !"X".equals(mapArray[y][x+1])) {
                countArr[y][x+1] = wayCount + 1;
                wayQ.add(new int[]{x+1, y});
            }
            if(y+1 < mapArray.length
                    && (countArr[y+1][x] == -1 || countArr[y+1][x] > wayCount + 1)
                    && !"X".equals(mapArray[y+1][x])) {
                countArr[y+1][x] = wayCount + 1;
                wayQ.add(new int[]{x, y+1});
            }
        }
    }
}
