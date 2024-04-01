package hello.javaLv2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Java250135 {
    // [PCCP 기출문제] 3번 / 아날로그 시계
    // /courses/30/lessons/250135
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;
        int different = endTime - startTime;

        int answer = 0;
        BigDecimal deivde120 = new BigDecimal("120");
        BigDecimal deivde10 = new BigDecimal("10");
        BigDecimal deivdeDot1 = new BigDecimal("0.1");
        BigDecimal deivde6 = new BigDecimal("6");
        BigDecimal remainder360 = new BigDecimal("360");
        for(int i=0; i<different; i++) {
            int currentTime = startTime + i;
            BigDecimal hNeedle = new BigDecimal(String.valueOf(currentTime));
            BigDecimal mNeedle = new BigDecimal(String.valueOf(currentTime));
            BigDecimal sNeedle = new BigDecimal(String.valueOf(currentTime));

            hNeedle = hNeedle.divide(deivde120, 4, RoundingMode.HALF_UP).remainder(remainder360);
            mNeedle = mNeedle.divide(deivde10, 1, RoundingMode.HALF_UP).remainder(remainder360);
            sNeedle = sNeedle.multiply(deivde6).remainder(remainder360);

            int nextTime = currentTime + 1;
            BigDecimal hNeedle2 = new BigDecimal(String.valueOf(nextTime))
                    .divide(deivde120, 4, RoundingMode.HALF_UP).remainder(remainder360);
            BigDecimal mNeedle2 = mNeedle.add(deivdeDot1);
            BigDecimal sNeedle2 = sNeedle.add(deivde6);
            if(hNeedle.compareTo(deivde120) == 1 && hNeedle2.compareTo(deivde120) <= 0) {
                hNeedle2 = hNeedle2.add(remainder360);
            }
            if(sNeedle2.compareTo(mNeedle2) != 0
                    && sNeedle.compareTo(mNeedle)*sNeedle2.compareTo(mNeedle2) <= 0){
                answer++;
            } else if(nextTime == endTime && sNeedle2.compareTo(mNeedle2) == 0) {
                answer++;
            }
            if(sNeedle2.compareTo(hNeedle2) != 0
                    && sNeedle.compareTo(hNeedle)*sNeedle2.compareTo(hNeedle2) <= 0){
                answer++;
            } else if(nextTime == endTime && sNeedle2.compareTo(hNeedle2) == 0) {
                answer++;
            }
            if(sNeedle.compareTo(hNeedle)==0 && hNeedle.compareTo(mNeedle)==0) {
                answer -= 1;
            } else if(nextTime == endTime
                    && sNeedle2.compareTo(hNeedle2)==0
                    && hNeedle2.compareTo(mNeedle2)==0) {
                answer -= 1;
            }
        }
        return answer;
    }
}
