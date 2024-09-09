package hello.javaLv2;

public class Java60057 {
    // 문자열 압축
    // 2020 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/60057
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i < s.length(); i++) {
            int size = i;
            String temp = "";
            int currentSize =  s.length();
            int continuousCount = 1;
            boolean isContinue = false;
            for(int j = 0; j < s.length() / size; j++) {
                String currentString = s.substring(size*j, size*(j+1));
                if(temp.equals(currentString)) {
                    currentSize -= size;
                    continuousCount ++;
                    isContinue = true;
                } else {
                    temp = currentString;
                    isContinue = false;
                }
                if ((!isContinue || j == (s.length()/size) - 1) && continuousCount > 1) {
                    int countSize = 0;
                    while(continuousCount > 0) {
                        continuousCount /= 10;
                        countSize ++;
                    }
                    currentSize += countSize;
                    continuousCount = 1;
                }
            }
            answer = Math.min(answer, currentSize);
        }

        return answer;
    }
}
