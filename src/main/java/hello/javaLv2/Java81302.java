package hello.javaLv2;

public class Java81302 {
    // 거리두기 확인하기
    // courses/30/lessons/81302
    // 2021 카카오 채용연계형 인턴십
    // DFS
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i=0; i<places.length; i++) {
            String[] waiting = places[i];
            int[] disableCount = new int[1];
            int pCount = 0;
            for(int j=0; j<waiting.length; j++) {
                for(int k=0; k<waiting[0].length(); k++) {
                    if(waiting[j].charAt(k) == 'P' && disableCount[0] == 0) {
                        pCount ++;
                        checkDistance(waiting, k, j, 0, disableCount, k, j);
                    }
                }
            }
            if(pCount == 0 || disableCount[0] == 0) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    private static void checkDistance(String[] waiting, int x, int y, int distance, int[] disableCount, int startX, int startY) {
        if(distance > 1) {
            return;
        }
        if(x-1 >= 0) {
            if(waiting[y].charAt(x-1) == 'P' && !(startX == x-1 && startY == y)) {
                disableCount[0] ++;
            } else if (waiting[y].charAt(x-1) == 'O') {
                checkDistance(waiting, x-1, y, distance+1, disableCount, startX, startY);
            }
        }
        if(y-1 >= 0) {
            if(waiting[y-1].charAt(x) == 'P' && !(startX == x && startY == y-1)) {
                disableCount[0] ++;
            } else if (waiting[y-1].charAt(x) == 'O') {
                checkDistance(waiting, x, y-1, distance+1, disableCount, startX, startY);
            }
        }
        if(x+1 < waiting[0].length()) {
            if(waiting[y].charAt(x+1) == 'P' && !(startX == x+1 && startY == y)) {
                disableCount[0] ++;
            } else if (waiting[y].charAt(x+1) == 'O') {
                checkDistance(waiting, x+1, y, distance+1, disableCount, startX, startY);
            }
        }
        if(y+1 < waiting.length) {
            if(waiting[y+1].charAt(x) == 'P' && !(startX == x && startY == y+1)) {
                disableCount[0] ++;
            } else if (waiting[y+1].charAt(x) == 'O') {
                checkDistance(waiting, x, y+1, distance+1, disableCount, startX, startY);
            }
        }
    }
}
