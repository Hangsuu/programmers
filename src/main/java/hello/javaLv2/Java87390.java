package hello.javaLv2;

public class Java87390 {
    // n^2 배열 자르기
    // courses/30/lessons/87390
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        long startGroup = left/n + 1L;
        long startIndex = left%n;
        long endIndex = right%n;
        for(int i=0; i<answer.length; i++) {
            if((startIndex + i) % n < startGroup) {
                answer[i] = (int) startGroup;
            } else {
                answer[i] = (int)((startIndex + i) % n) + 1;
            }
            if((startIndex + i) % n == n-1) {
                startGroup ++;
            }
        }
        return answer;
    }
}
