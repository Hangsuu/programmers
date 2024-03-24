package hello.java;

import java.util.HashMap;
import java.util.Map;

public class Java258712 {
    // 가장 많이 받은 선물
    // 2024 KAKAO WINTER INTERNSHIP
    // courses/30/lessons/258712
    public int solution(String[] friends, String[] gifts) {
        int friendsNum = friends.length;
        int [][] giftNum = new int[friendsNum][friendsNum];
        int [] result = new int[friendsNum];
        Map<String, int[]> giftSum = new HashMap<>();
        for(int i=0; i<friendsNum; i++) {
            int[] info = new int[3];
            info[0] = i;
            giftSum.put(friends[i], info);
        }

        for(int i=0; i<gifts.length; i++) {
            String[] s = gifts[i].split(" ");
            String sender = s[0];
            String getter = s[1];
            int[] senderInfo = giftSum.get(s[0]);
            senderInfo[1]++;

            int[] getterInfo = giftSum.get(s[1]);
            getterInfo[2]++;
            giftNum[senderInfo[0]][getterInfo[0]] ++;

        }

        for(int i=0; i<friendsNum; i++) {
            for(int j=0; j<friendsNum; j++) {
                if(giftNum[i][j] > giftNum[j][i]) {
                    result[i] ++;
                } else if(giftNum[i][j] == giftNum[j][i]) {
                    int[] firstInfo = giftSum.get(friends[i]);
                    int firstCount = firstInfo[1] - firstInfo[2];

                    int[] secondInfo = giftSum.get(friends[j]);
                    int secondCount = secondInfo[1] - secondInfo[2];
                    if(firstCount < secondCount) {
                        result[j] ++;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0; i<friendsNum; i++) {
            //System.out.println(result[i] +"");
            answer = Math.max(answer, result[i]);
        }
        // for(int i=0; i<friendsNum; i++) {
        //     for(int j=0; j<friendsNum; j++) {
        //         System.out.print(giftNum[i][j] + " ");
        //     }
        //     System.out.print("\n");
        // }
        // for(int i=0; i<friendsNum; i++) {
        //     int[] ans = giftSum.get(friends[i]);
        //     System.out.println(ans[1] + " " + ans[2]);
        // }
        return answer;
    }
}
