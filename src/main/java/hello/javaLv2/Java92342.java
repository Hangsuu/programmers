package hello.javaLv2;

public class Java92342 {
    // 양궁대회
    // courses/30/lessons/92342
    // 2022 KAKAO BLIND RECRUITMENT
    public int[] solution(int n, int[] info) {
        int[] answerTemp = new int[11];
        int sumDifference = 0;
        int[] answer = new int[11];

        for(int i=3; i<Math.pow(2, 11); i++) {
            int tempN = 0;
            int powTemp = 2;
            for(int j=9; j>=0; j--) {
                if((i / powTemp) % 2 == 1) {
                    answerTemp[j] = info[j] +1;
                    tempN += info[j]+1;
                } else {
                    answerTemp[j] = 0;
                }
                powTemp *= 2;
            }

            if(tempN > n) {
                continue;
            } else {
                answerTemp[10] = n - tempN;
            }
            int apeachSum = 0;
            int lionSum = 0;
            for(int j=0; j<11; j++) {
                if(answerTemp[j] > info[j]) {
                    lionSum += 10-j;
                } else if(info[j] != 0 && info[j] >= answerTemp[j]) {
                    apeachSum += 10-j;
                }
            }
            if(lionSum > apeachSum && sumDifference < lionSum-apeachSum) {
                sumDifference = lionSum-apeachSum;
                for(int j=0; j<11; j++) {
                    answer[j] = answerTemp[j];
                }
            } else if(lionSum > apeachSum && sumDifference == lionSum-apeachSum) {
                boolean lowScore = false;
                for(int j=10; j>=0; j--) {
                    if(answer[j] == answerTemp[j]) {
                        continue;
                    } else if(answerTemp[j] > answer[j]) {
                        for(int l=0; l<11; l++) {
                            answer[l] = answerTemp[l];
                        }
                        j = -1;
                    } else {
                        j = -1;
                    }
                }
            }
        }
        if(sumDifference == 0) {
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}
