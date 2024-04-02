package hello.javaLv2;

public class Java178870 {
    // 연속된 부분 수열의 합
    // 투포인터
    // courses/30/lessons/178870
    public int[] solution(int[] sequence, int k) {
        int size = sequence.length;
        int[] sequenceSum = new int[size+1];
        int start = size-1;
        int end = size;

        for(int i=1; i<=size; i++) {
            sequenceSum [i] = sequenceSum[i-1] + sequence[i-1];
        }

        int sum = 0;
        while(sum != k) {
            sum = sequenceSum[end] - sequenceSum[start];
            if(sum > k) {
                end --;
                if(start >= end) {
                    start = end - 1;
                }
            } else if(sum < k) {
                start --;
            } else {
                while(true) {
                    int checkMinEnd = end-1;
                    int checkMinStart = start -1;

                    if(checkMinEnd >= 0 && checkMinStart >= 0
                            && sequenceSum[checkMinEnd] - sequenceSum[checkMinStart] == k) {
                        end --;
                        start --;
                    } else {
                        break;
                    }
                }
            }
        }

        int[] answer = {start, end-1};
        return answer;
    }
}
