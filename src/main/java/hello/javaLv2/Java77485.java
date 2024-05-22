package hello.javaLv2;

public class Java77485 {
    // 행렬 테두리 회전하기
    // courses/30/lessons/77485
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] matrix = new int[rows][columns];
        int matrixNum = 1;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = matrixNum;
                matrixNum ++;
            }
        }
        int[] answer = new int[queries.length];
        for(int i=0; i<queries.length; i++) {
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            int start = matrix[x1][y1];
            int minValue = start;
            for(int j=1; j <= y2-y1; j++) {
                int temp = matrix[x1][y1+j];
                matrix[x1][y1+j] = start;
                start = temp;
                minValue = Math.min(minValue, start);
            }
            for(int j=1; j<= x2-x1; j++) {
                int temp = matrix[x1+j][y2];
                matrix[x1+j][y2] = start;
                start = temp;
                minValue = Math.min(minValue, start);
            }
            for(int j=1; j <= y2-y1; j++) {
                int temp = matrix[x2][y2-j];
                matrix[x2][y2-j] = start;
                start = temp;
                minValue = Math.min(minValue, start);
            }
            for(int j=1; j<= x2-x1; j++) {
                int temp = matrix[x2-j][y1];
                matrix[x2-j][y1] = start;
                start = temp;
                minValue = Math.min(minValue, start);
            }
            answer[i] = minValue;
        }
        return answer;
    }
}
