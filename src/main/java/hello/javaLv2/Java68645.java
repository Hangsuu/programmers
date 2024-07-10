package hello.javaLv2;

public class Java68645 {
    // 삼각 달팽이
    // courses/30/lessons/68645
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] snail = new int[n][n];

        boolean down = true;
        boolean right = false;
        boolean up = false;
        int count = 0;
        int row = 0;
        int col = 0;
        while(count < n*(n+1)/2) {
            count ++;
            if (down) {
                snail[row][col] = count;
                if(row == n-1 || snail[row+1][col] != 0) {
                    down = false;
                    right = true;
                    col++;
                } else {
                    row++;
                }
            } else if (right) {
                snail[row][col] = count;
                if(col == n-1 || snail[row][col+1] != 0) {
                    right = false;
                    up = true;
                    row--;
                    col--;
                } else {
                    col++;
                }
            } else if (up) {
                snail[row][col] = count;
                if(snail[row-1][col-1] != 0) {
                    up = false;
                    down = true;
                    row++;
                } else {
                    col--;
                    row--;
                }
            }
        }

        int index = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(snail[i][j] != 0) {
                    answer[index] = snail[i][j];
                    index++;
                }
            }
        }

        return answer;
    }
}
