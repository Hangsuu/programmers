package hello.javaLv2;

public class Java77885 {
    // 2개 이하로 다른 비트
    // courses/30/lessons/77885
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            long number = numbers[i];
            String bitNum = "";
            boolean hasZero = false;
            int numberIndex = 0;
            int maxZeroIndex = 0;
            while(number>0L) {
                if(number%2L == 1L) {
                    bitNum = "1" + bitNum;
                } else {
                    bitNum = "0" + bitNum;
                    if(!hasZero) {
                        hasZero = true;
                        maxZeroIndex = numberIndex;
                    }
                }
                numberIndex ++;
                number /= 2L;
            }
            if(hasZero && maxZeroIndex != 0) {
                answer[i] = numbers[i] + pow(maxZeroIndex-1);
            } else if(hasZero) {
                answer[i] = numbers[i] + 1;
            } else {
                answer[i] = numbers[i] + pow(bitNum.length()-1);
            }
        }
        return answer;
    }

    private static long pow(int cnt) {
        long answer = 1L;
        for(int i=0; i<cnt; i++) {
            answer *= 2L;
        }
        return answer;
    }
}
