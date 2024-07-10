package hello.javaLv2;

public class Java70129 {
    // 이진 변환 반복하기
    // courses/30/lessons/70129
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(true) {
            if("1".equals(s)) {
                break;
            }
            String[] temp = s.split("");
            int count = 0;
            for(int i=0; i<temp.length; i++) {
                if ("1".equals(temp[i])) {
                    count ++;
                } else {
                    answer[1] += 1;
                }
            }

            s = "";
            while(count != 0) {
                if (count % 2 == 1) {
                    s = "1" + s;
                } else {
                    s = "0" + s;
                }
                count /= 2;
            }
            answer[0] += 1;
        }
        return answer;
    }
}
