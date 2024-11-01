package hello.javaLv2;

public class Java17687 {
    // n진수 게임
    // 2018 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/17687
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int num = 0;
        int currentCount = 0;
        while(answer.length() < t) {
            String changedNum = getNumber(n, num);
            for(int i=0; i<changedNum.length(); i++) {
                if( (currentCount + i) % m == p-1 ){
                    answer += String.valueOf(changedNum.charAt(i));
                }
                if(answer.length() == t) {
                    break;
                }
            }

            currentCount += changedNum.length();
            num++;
        }
        return answer;
    }

    private static String getNumber(int n, int num) {
        int currentNum = num;
        String changedNum = "";
        if(num == 0) {
            changedNum = "0";
        }

        while(currentNum > 0) {
            String dividedNum = String.valueOf(currentNum % n);
            if("10".equals(dividedNum)) {
                dividedNum = "A";
            } else if("11".equals(dividedNum)) {
                dividedNum = "B";
            } else if("12".equals(dividedNum)) {
                dividedNum = "C";
            } else if("13".equals(dividedNum)) {
                dividedNum = "D";
            } else if("14".equals(dividedNum)) {
                dividedNum = "E";
            } else if("15".equals(dividedNum)) {
                dividedNum = "F";
            }
            changedNum = dividedNum + changedNum;
            currentNum /= n;
        }

        return changedNum;
    }
}
