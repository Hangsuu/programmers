package hello.javaLv2;

import java.util.Arrays;

public class Java147354 {
    // 테이블 해시 함수
    // courses/30/lessons/147354
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        int[] si = new int[row_end - row_begin + 1];

        Arrays.sort(data, (a, b) -> {
            if(a[col-1] != b[col-1]) {
                return a[col-1] - b[col-1];
            } else {
                return b[0] - a[0];
            }
        });
        int index = 0;
        for(int i=row_begin; i<=row_end; i++) {
            int siTemp = 0;
            for(int j=0; j<data[i-1].length; j++) {
                siTemp += data[i-1][j] % i;
            }
            si[index] = siTemp;
            index ++;
        }
        int answer = 0;
        for(int i=0; i<si.length; i++) {
            answer = answer ^ si[i];
        }
        return answer;
    }
}
