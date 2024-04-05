package hello.javaLv2;

public class Java160585 {
    // 혼자서 하는 틱택토
    // courses/30/lessons/160585#
    public int solution(String[] board) {
        String[][] boardArr = new String[3][3];
        int oCount = 0;
        int xCount = 0;
        for(int i = 0; i < 3; i++) {
            String[] s = board[i].split("");
            for(int j=0; j<3; j++) {
                boardArr[i][j] = s[j];
                if("O".equals(s[j])) {
                    oCount ++;
                } else if("X".equals(s[j])) {
                    xCount ++;
                }
            }
        }
        int answer = 1;
        if(oCount < xCount || oCount - xCount > 1) {
            return 0;
        }
        if(oCount <= 3 && xCount <= 2) {
            return 1;
        }
        if(oCount == xCount) {
            for(int i=0; i<3; i++) {
                int straightRow = 0;
                int straightCol = 0;
                for(int j=0; j<3; j++) {
                    if("O".equals(boardArr[i][j])) {
                        straightRow ++;
                    }
                    if("O".equals(boardArr[j][i])) {
                        straightCol ++;
                    }
                }
                if(straightRow == 3 || straightCol == 3) {
                    return 0;
                }
            }
            int crossRightCount = 0;
            int crossLeftCount = 0;
            for(int i=0; i<3; i++) {
                if("O".equals(boardArr[i][i])) {
                    crossRightCount ++;
                }
                if("O".equals(boardArr[i][2-i])) {
                    crossLeftCount ++;
                }
            }
            if(crossRightCount == 3 || crossLeftCount == 3) {
                return 0;
            }
        }
        if(oCount > xCount) {
            for(int i=0; i<3; i++) {
                int straightRow = 0;
                int straightCol = 0;
                for(int j=0; j<3; j++) {
                    if("X".equals(boardArr[i][j])) {
                        straightRow ++;
                    }
                    if("X".equals(boardArr[j][i])) {
                        straightCol ++;
                    }
                }
                if(straightRow == 3 || straightCol == 3) {
                    return 0;
                }
            }
            int crossRightCount = 0;
            int crossLeftCount = 0;
            for(int i=0; i<3; i++) {
                if("X".equals(boardArr[i][i])) {
                    crossRightCount ++;
                }
                if("X".equals(boardArr[i][2-i])) {
                    crossLeftCount ++;
                }
            }
            if(crossRightCount == 3 || crossLeftCount == 3) {
                return 0;
            }
        }
        return answer;
    }
}
