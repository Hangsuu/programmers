package hello.javaLv2;

public class Java49994 {
    // 방문 길이
    // courses/30/lessons/49994
    public int solution(String dirs) {
        // 0:U, 1:D, 2:R, 3:L
        boolean [][][] visited = new boolean[11][11][4];
        int row = 5;
        int col = 5;
        String[] seperatedDirs = dirs.split("");

        int answer = 0;
        for(int i=0; i<seperatedDirs.length; i++) {
            if(seperatedDirs[i].equals("U")) {
                //위로
                if (row+1 <= 10) {
                    if (!visited[row][col][0]) {
                        answer ++;
                        visited[row][col][0] = true;
                        visited[row+1][col][1] = true;
                    }
                    row ++;
                }
            } else if (seperatedDirs[i].equals("D")) {
                // 아래로
                if (row-1 >= 0) {
                    if(!visited[row][col][1]) {
                        answer ++;
                        visited[row][col][1] = true;
                        visited[row-1][col][0] = true;
                    }
                    row --;
                }
            } else if (seperatedDirs[i].equals("R")) {
                // 오른쪽으로
                if (col+1 <= 10) {
                    if(!visited[row][col][2]) {
                        answer ++;
                        visited[row][col][2] = true;
                        visited[row][col+1][3] = true;
                    }
                    col ++;
                }
            } else {
                // 왼쪽으로
                if (col-1 >= 0) {
                    if(!visited[row][col][3]) {
                        answer ++;
                        visited[row][col][3] = true;
                        visited[row][col-1][2] = true;
                    }
                    col --;
                }
            }
        }

        return answer;
    }
}
