package hello.javaLv2;

public class Java42842 {
    // 완전탐색 카펫
    // courses/30/lessons/42842
    public int[] solution(int brown, int yellow) {

        int width = 0;
        int length = 0;
        for (int i=1; i<=yellow; i++) {
            if(yellow % i != 0) {
                continue;
            }
            int yellowWidth = i;
            int yellowLength = yellow / i;
            if(yellowWidth * 2 + yellowLength * 2 + 4 == brown) {
                width = yellowWidth + 2;
                length = yellowLength + 2;
                i = yellow+1;
            }
        }

        int[] answer = {length, width};
        return answer;
    }
}
