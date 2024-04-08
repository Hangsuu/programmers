package hello.javaLv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java155651 {
    // 호텔 대실
    // courses/30/lessons/155651
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] bookTime = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] startTime = book_time[i][0].split(":");
            String[] endTime = book_time[i][1].split(":");
            bookTime[i][0] = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            bookTime[i][1] = Integer.parseInt(endTime[0]) * 60  + Integer.parseInt(endTime[1]);
        }
        Arrays.sort(bookTime, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        List<Integer> roomList = new ArrayList<>();
        roomList.add(bookTime[0][1]);
        for(int i=1; i<n; i++) {
            int roomListSize = roomList.size();
            boolean findEmptyRoom = false;
            for(int j=0; j<roomListSize; j++) {
                if(bookTime[i][0] >= roomList.get(j) + 10) {
                    roomList.set(j, bookTime[i][1]);
                    findEmptyRoom = true;
                    j = roomListSize;
                }
            }
            if(!findEmptyRoom) {
                roomList.add(bookTime[i][1]);
            }
        }
        int answer = roomList.size();
        return answer;
    }
}
