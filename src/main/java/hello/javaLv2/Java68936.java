package hello.javaLv2;

public class Java68936 {
    // 쿼드압축 후 개수 세기
    // courses/30/lessons/68936
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        int length = arr.length;
        int pow = 0;
        while(length > 1) {
            length /= 2;
            pow ++;
        }

        boolean [][] visited = new boolean[arr.length][arr.length];
        for(int i=0; i<=pow; i++) {
            int squre = (int) Math.pow(2, pow-i);
            for(int j=0; j < arr.length/squre; j++) {
                for(int k=0; k < arr.length/squre; k++) {
                    checkNumber(arr, answer, visited, j*squre, k*squre, squre);
                }
            }
        }

        return answer;
    }

    private void checkNumber(int[][] arr, int[] answer, boolean[][] visited, int startRow, int startCol, int size) {
        int one = 0;
        int zero = 0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(visited[startRow+i][startCol+j]) {
                    return;
                }
                if(arr[startRow+i][startCol+j] == 1) {
                    one++;
                } else {
                    zero++;
                }
            }
        }
        if(one == size * size) {
            answer[1] += 1;
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    visited[startRow+i][startCol+j] = true;
                }
            }
        } else if(zero == size*size) {
            answer[0] += 1;
            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    visited[startRow+i][startCol+j] = true;
                }
            }
        }
    }
}
