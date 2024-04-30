package hello.javaLv2;

public class Java148652 {
    // 유사 칸토어 비트열
    // courses/30/lessons/148652
    public int solution(int n, long l, long r) {
        int answer = 0;
        int[] kan = {1, 1, 0, 1, 1};
        long[][] indexDept = new long[n][4];
        indexDept[0][0] = (l-1) / 5L;
        indexDept[0][1] = (l-1) % 5L;
        indexDept[0][2] = (r-1) / 5L;
        indexDept[0][3] = (r-1) % 5L;

        boolean startIsOne = true;
        boolean endIsOne = true;

        for(int i=1; i<n; i++) {
            indexDept[i][0] = indexDept[i-1][0] / 5L;
            indexDept[i][1] = indexDept[i-1][0] % 5L;
            indexDept[i][2] = indexDept[i-1][2] / 5L;
            indexDept[i][3] = indexDept[i-1][2] % 5L;
        }

        for(int i=0; i<n; i++) {
            if(indexDept[n-i-1][0] == indexDept[n-i-1][2]
                    && startIsOne
                    && endIsOne
                    && indexDept[n-i-1][1] != indexDept[n-i-1][3] && answer == 0) {
                for(int j=(int)indexDept[n-i-1][1]; j<=(int)indexDept[n-i-1][3]; j++) {
                    if(kan[j] == 1) {
                        answer ++;
                    }
                }
                startIsOne = kan[(int)indexDept[n-i-1][1]] == 1;
                endIsOne = kan[(int)indexDept[n-i-1][3]] == 1;
            } else if(indexDept[n-i-1][0] == indexDept[n-i-1][2]
                    && indexDept[n-i-1][1] == indexDept[n-i-1][3]) {
                startIsOne = kan[(int)indexDept[n-i-1][1]] == 1;
                endIsOne = kan[(int)indexDept[n-i-1][3]] == 1;
                if(i == n-1) {
                    if(indexDept[n-i-1][1] != 2L) {
                        answer++;
                    }
                }
            } else {
                answer *= 4;
                if(startIsOne) {
                    if(indexDept[n-i-1][1] == 0) {
                    } else if(indexDept[n-i-1][1] == 1) {
                        answer -= 1;
                    } else if(indexDept[n-i-1][1] == 2) {
                        answer -= 2;
                        startIsOne = false;
                    } else if(indexDept[n-i-1][1] == 3) {
                        answer -= 2;
                    } else if(indexDept[n-i-1][1] == 4) {
                        answer -= 3;
                    }
                }
                if(endIsOne) {
                    if(indexDept[n-i-1][3] == 0) {
                        answer -= 3;
                    } else if(indexDept[n-i-1][3] == 1) {
                        answer -= 2;
                    } else if(indexDept[n-i-1][3] == 2) {
                        answer -= 2;
                        endIsOne = false;
                    } else if(indexDept[n-i-1][3] == 3) {
                        answer -= 1;
                    } else if(indexDept[n-i-1][3] == 4) {
                    }
                }
            }
        }
        return answer;
    }
}
