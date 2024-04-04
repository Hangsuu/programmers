package hello.javaLv2;

public class Java169198 {
    // 당구 연습
    // courses/30/lessons/169198#
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int ballCount = balls.length;
        int[] answer = new int[ballCount];
        for(int i=0; i<ballCount; i++) {
            int ballX = balls[i][0];
            int ballY = balls[i][1];

            int minRange = Integer.MAX_VALUE;
            if(startX <= ballX || ballY != startY) {
                minRange = Math.min(minRange, (int)(Math.pow(-ballX-startX, 2) + Math.pow(ballY-startY, 2)));
            }
            if(startY <= ballY || ballX != startX) {
                minRange = Math.min(minRange, (int)(Math.pow(ballX-startX, 2) + Math.pow(-ballY-startY, 2)));
            }
            if(startX >= ballX || ballY != startY) {
                minRange = Math.min(minRange, (int)(Math.pow(2*m-ballX-startX, 2) + Math.pow(ballY-startY, 2)));
            }
            if(startY >= ballY || ballX != startX) {
                minRange = Math.min(minRange, (int)(Math.pow(ballX-startX, 2) + Math.pow(2*n-ballY-startY, 2)));
            }
            if(startY/(double)startX == ballY/(double)ballX && startX < ballX) {
                minRange = Math.min(minRange, (int)(Math.pow(ballX, 2) + Math.pow(ballY, 2) + Math.pow(startX, 2) + Math.pow(startY, 2)));
            }
            if((startY-n)/(double)startX == (ballY-n)/(double)ballX && startX < ballX) {
                minRange = Math.min(minRange, (int)(Math.pow(ballX, 2) + Math.pow(ballY-n, 2) + Math.pow(startX, 2) + Math.pow(startY-n, 2)));
            }
            if((startY-n)/(double)(startX-m) == (ballY-n)/(double)(ballX-m) && startX > ballX) {
                minRange = Math.min(minRange, (int)(Math.pow(ballX-m, 2) + Math.pow(ballY-n, 2) + Math.pow(startX-m, 2) + Math.pow(startY-n, 2)));
            }
            if(startY/(double)(startX-m) == ballY/(double)(ballX-m) && startX > ballX) {
                minRange = Math.min(minRange, (int)(Math.pow(ballX-m, 2) + Math.pow(ballY, 2) + Math.pow(startX-m, 2) + Math.pow(startY, 2)));
            }
            answer[i] = minRange;
        }

        return answer;
    }
}
