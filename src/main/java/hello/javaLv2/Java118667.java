package hello.javaLv2;

public class Java118667 {
    // 두 큐 합 같게 만들기
    // courses/30/lessons/118667
    // 2022 KAKAO TECH INTERNSHIP
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum = 0L;
        long sum1 = 0L;
        for(int i=0; i<queue1.length; i++) {
            sum += queue1[i];
            sum1 += queue1[i];
            sum += queue2[i];
        }
        long goalSum = sum/2L;
        if(goalSum*2 != sum) {
            return -1;
        }
        int index1 = 0;
        int index2 = 0;
        while(sum1 != goalSum) {
            if(sum1 < goalSum) {
                if(index2 < queue2.length) {
                    sum1 += queue2[index2];
                } else {
                    sum1 += queue1[index2%queue1.length];
                }
                index2 ++;
            } else {
                if(index1 < queue1.length) {
                    sum1 -= queue1[index1];
                } else {
                    sum1 -= queue2[index1%queue2.length];
                }
                index1 ++;
            }

            answer ++;
            if(answer > queue1.length*3) {
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
