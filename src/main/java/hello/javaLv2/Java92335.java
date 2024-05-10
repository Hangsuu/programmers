package hello.javaLv2;

import java.util.HashSet;
import java.util.Set;

public class Java92335 {
    // k진수에서 소수 개수 구하기
    // courses/30/lessons/92335
    // 2022 KAKAO BLIND RECRUITMENT
    public int solution(int n, int k) {
        int answer = 0;

        String changedN = "";

        if(k != 10) {
            while(n > 0) {
                changedN = (n % k) + changedN;
                n /= k;
            }
        } else {
            changedN = String.valueOf(n);
        }

        String[] s = changedN.split("0");
        long[] checkNums = new long[s.length];
        for(int i=0; i<s.length; i++) {
            if(s[i].length() > 0) {
                long tempNum = Long.parseLong(s[i]);
                checkNums[i] = tempNum;
            }
        }

        Set<Long> primeSet = new HashSet<>();
        primeSet.add(2L);
        primeSet.add(3L);
        Set<Long> notPrimeSet = new HashSet<>();
        notPrimeSet.add(1L);
        notPrimeSet.add(4L);

        for(int i=0; i<checkNums.length; i++) {
            long tempNum = checkNums[i];
            if(primeSet.contains(tempNum)) {
                answer ++;
            } else if(!notPrimeSet.contains(tempNum)) {
                for(long j=2L; j <= (long)Math.sqrt(tempNum); j++) {
                    if(checkNums[i] % j == 0L) {
                        notPrimeSet.add(tempNum);
                        j = (long) Math.sqrt(tempNum) + 1L;
                    }
                    if(j==((long) Math.sqrt(tempNum))) {
                        answer ++;
                        primeSet.add(tempNum);
                    }
                }
            }
        }
        return answer;
    }
}
