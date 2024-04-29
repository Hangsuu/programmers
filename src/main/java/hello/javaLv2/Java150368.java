package hello.javaLv2;

public class Java150368 {
    // 이모티콘 할인행사
    // courses/30/lessons/150368
    // 2023 KAKAO BLIND RECRUITMENT
    public int[] solution(int[][] users, int[] emoticons) {
        int[] saleRate = new int[emoticons.length];
        int saleRateCase = (int) Math.pow(4, emoticons.length);
        int join = 0;
        int sum = 0;
        for(int i=0; i<saleRateCase; i++) {
            for(int j=0; j<saleRate.length; j++) {
                saleRate[j] = 10 * (1 + (i / (int) Math.pow(4, j)) % 4);
            }
            int userJoin = 0;
            int userSums = 0;
            for(int j=0; j<users.length; j++) {
                int userSum = 0;
                int userRate = users[j][0];
                for(int l=0; l<saleRate.length; l++) {
                    if(saleRate[l] >= userRate) {
                        userSum += (emoticons[l] * (100-saleRate[l])) / 100;
                    }
                }
                if(userSum >= users[j][1]) {
                    userJoin ++;
                } else {
                    userSums += userSum;
                }
            }
            if(userJoin == join) {
                join = userJoin;
                sum = Math.max(sum, userSums);
            } else if(userJoin > join) {
                join = userJoin;
                sum = userSums;
            }
        }
        int[] answer = {join, sum};
        return answer;
    }
}
