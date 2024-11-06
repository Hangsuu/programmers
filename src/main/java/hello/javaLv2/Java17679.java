package hello.javaLv2;

import java.util.LinkedList;
import java.util.Queue;

public class Java17679 {
    // 프렌즈4블록
    // 2018 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/17679
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        String[][] boardArray = new String[m][n];
        boolean[][] checked = new boolean[m][n];
        for(int i=0; i<m; i++) {
            String[] tempArray = board[i].split("");
            for(int j=0; j<n; j++) {
                boardArray[i][j] = tempArray[j];
            }
        }

        int added = -1;
        while(added != 0) {
            added = getRemovedCount(boardArray, checked);
            answer += added;
            for(int i=0; i<n; i++) {
                Queue<String> newBlock = new LinkedList<>();
                for(int j=0; j<m; j++) {
                    if(!checked[j][i]) {
                        newBlock.add(boardArray[j][i]);
                    }
                }
                int remainCount = newBlock.size();
                for(int j=0; j<m; j++) {
                    if(m-remainCount > j) {
                        boardArray[j][i] = "#";
                    } else {
                        boardArray[j][i] = newBlock.poll();
                    }
                }
            }
            checked = new boolean[m][n];
        }
        return answer;
    }
    private int getRemovedCount(String[][] boardArray, boolean[][] checked) {
        int added = 0;
        for(int i=0; i<boardArray.length-1; i++) {
            for(int j=0; j<boardArray[0].length-1; j++) {
                String currentString = boardArray[i][j];
                if(!"#".equals(currentString)
                        && currentString.equals(boardArray[i+1][j])
                        && currentString.equals(boardArray[i][j+1])
                        && currentString.equals(boardArray[i+1][j+1])) {
                    if(!checked[i][j]) {
                        added ++;
                        checked[i][j] = true;
                    }
                    if(!checked[i+1][j]) {
                        added ++;
                        checked[i+1][j] = true;
                    }
                    if(!checked[i][j+1]) {
                        added ++;
                        checked[i][j+1] = true;
                    }
                    if(!checked[i+1][j+1]) {
                        added ++;
                        checked[i+1][j+1] = true;
                    }
                }
            }
        }
        return added;
    }
}
