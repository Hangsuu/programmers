package hello.javaLv2;

import java.util.*;

public class Java250136 {
    // [PCCP 기출문제]2번 / 석유시추
    // courses/30/lessons/250136
    private static List<Integer> oilQuantity = new ArrayList<>();
    private static List<Set<Integer>> way = new ArrayList<>();
    private static int oilIndex = 2;
    private static int m = 0;
    private static int n = 0;
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        oilQuantity.add(0);
        oilQuantity.add(0);
        for(int i=0; i<m; i++) {
            way.add(new HashSet<Integer>());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(land[i][j] == 1) {
                    oilQuantity.add(0);
                    checkSameOil(land, i, j);
                    oilIndex ++;
                }
            }
        }

        int answer = 0;
        for(int i=0; i<m; i++) {
            int sum = 0;
            Set<Integer> wayOil = way.get(i);
            for(int wayOilIndex : wayOil) {
                sum += oilQuantity.get(wayOilIndex);
            }
            answer = Math.max(sum, answer);
        }

        return answer;
    }
    private static void checkSameOil(int[][] land, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x < 0 || x >= n || y < 0 || y >= m || land[x][y] != 1) {
                continue;
            }

            land[x][y] = oilIndex;
            oilQuantity.set(oilIndex, oilQuantity.get(oilIndex) + 1);
            way.get(y).add(oilIndex);

            queue.add(new int[]{x - 1, y});
            queue.add(new int[]{x + 1, y});
            queue.add(new int[]{x, y - 1});
            queue.add(new int[]{x, y + 1});
        }
    }
}
