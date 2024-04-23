package hello.javaLv2;

public class Java140107 {
    // 점  찍기
    // 이분탐색?
    public long solution(int k, int d) {
        long length = (long) d;
        long answer = 0;
        long height = (long) d/k;
        for(long i=0L; i*k<=d; i++) {
            while(height >=0) {
                if(i*i*k*k + height*height*k*k <= length*length) {
                    answer += height + 1;
                    break;
                } else {
                    height --;
                }
            }
        }
        return answer;
    }
}
