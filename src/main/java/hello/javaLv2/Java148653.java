package hello.javaLv2;

public class Java148653 {
    // 마법의 엘리베이터
    // courses/30/lessons/148653
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int lastNum = storey % 10;
            int secondNum = storey / 10 % 10;
            if(lastNum >=6) {
                answer += 10-lastNum;
                storey += 10;
            } else if(lastNum == 5 && secondNum >= 5) {
                answer += 10-lastNum;
                storey += 10;
            } else {
                answer += lastNum;
            }
            storey /= 10;
        }
        return answer;
    }
}
