package hello.javaLv2;

public class Java181187 {
    // 두 원 사이의 정수 쌍
    // courses/30/lessons/181187
    public long solution(int r1, int r2) {
        long answer = 0;
        long r22 = (long)r2 * (long)r2;
        long r12 = (long)r1 * (long)r1;
        for(int i=0; i<=r2; i++) {
            if(i < r1) {
                answer += Math.floor(Math.sqrt(r22 - (long)i * i)) -
                        Math.ceil(Math.sqrt(r12 - (long)i * i))+1;
            } else {
                answer += Math.floor(Math.sqrt(r22 - (long)i * i));
            }
        }

        return answer * 4;
    }
}
