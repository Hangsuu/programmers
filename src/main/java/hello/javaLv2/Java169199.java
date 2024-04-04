package hello.javaLv2;

public class Java169199 {
    // 리코쳇 로봇
    // courses/30/lessons/169199#
    // bfs
    private static String [][] boardWay;
    private static int[][] answerWay;
    private static int x = 0;
    private static int y = 0;
    private static int startX = 0;
    private static int startY = 0;
    private static int endX = 0;
    private static int endY = 0;
    public int solution(String[] board) {
        x = board[0].length();
        y = board.length;
        boardWay = new String[y][x];
        answerWay = new int[y][x];

        for(int i=0; i<y; i++) {
            for(int j=0; j<x; j++) {
                answerWay[i][j] = -1;
            }
        }
        for(int i=0; i<y; i++) {
            String[] tempString = board[i].split("");
            for(int j=0; j<x; j++) {
                boardWay[i][j] = tempString[j];
                if(boardWay[i][j].equals("R")){
                    startX = j;
                    startY = i;
                } else if(boardWay[i][j].equals("G")) {
                    endX = j;
                    endY = i;
                }
            }
        }
        answerWay[startY][startX] = 0;
        bfs(startX, startY);

        int answer = answerWay[endY][endX];
        // for(int i=0; i<y; i++) {
        //     for(int j=0; j<x; j++) {
        //         System.out.print(answerWay[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        return answer;
    }

    private static void bfs(int xIndex, int yIndex) {
        int wayCount = answerWay[yIndex][xIndex] == -1 ? 0 : answerWay[yIndex][xIndex];
        if(xIndex-1 >= 0 && !boardWay[yIndex][xIndex-1].equals("D")) {
            int xEnd = checkLeftWay(xIndex, yIndex);
            if(answerWay[yIndex][xEnd] == -1 || answerWay[yIndex][xEnd] > wayCount + 1) {
                answerWay[yIndex][xEnd] = wayCount + 1;
                bfs(xEnd, yIndex);
            }
        }
        if (xIndex+1 < x && !boardWay[yIndex][xIndex+1].equals("D")) {
            int xEnd = checkRightWay(xIndex, yIndex);
            if(answerWay[yIndex][xEnd] == -1 || answerWay[yIndex][xEnd] > wayCount + 1) {
                answerWay[yIndex][xEnd] = wayCount + 1;
                bfs(xEnd, yIndex);
            }
        }
        if (yIndex-1 >= 0 && !boardWay[yIndex-1][xIndex].equals("D")) {
            int yEnd = checkUpWay(xIndex, yIndex);
            if(answerWay[yEnd][xIndex] == -1 || answerWay[yEnd][xIndex] > wayCount + 1) {
                answerWay[yEnd][xIndex] = wayCount + 1;
                bfs(xIndex, yEnd);
            }
        }
        if (yIndex+1 < y && !boardWay[yIndex+1][xIndex].equals("D")) {
            int yEnd = checkDownWay(xIndex, yIndex);
            if(answerWay[yEnd][xIndex] == -1 || answerWay[yEnd][xIndex] > wayCount + 1) {
                answerWay[yEnd][xIndex] = wayCount + 1;
                bfs(xIndex, yEnd);
            }
        }
    }
    private static int checkLeftWay(int xIndex, int yIndex) {
        int xEnd = 0;
        for(int i=xIndex-1; i>=0; i--) {
            if(boardWay[yIndex][i].equals("D")) {
                xEnd = i+1;
                break;
            }
        }
        return xEnd;
    }
    private static int checkRightWay(int xIndex, int yIndex) {
        int xEnd = x-1;
        for(int i=xIndex+1; i<x; i++) {
            if(boardWay[yIndex][i].equals("D")) {
                xEnd = i-1;
                break;
            }
        }
        return xEnd;
    }
    private static int checkUpWay(int xIndex, int yIndex) {
        int yEnd = 0;
        for(int i=yIndex-1; i>=0; i--) {
            if(boardWay[i][xIndex].equals("D")) {
                yEnd = i+1;
                break;
            }
        }
        return yEnd;
    }
    private static int checkDownWay(int xIndex, int yIndex) {
        int yEnd = y-1;
        for(int i=yIndex+1; i<y; i++) {
            if(boardWay[i][xIndex].equals("D")) {
                yEnd = i-1;
                break;
            }
        }
        return yEnd;
    }
}
