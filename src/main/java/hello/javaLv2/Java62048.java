package hello.javaLv2;

public class Java62048 {
    // 멀쩡한 사각형
    // courses/30/lessons/62048
    public long solution(int w, int h) {
        long answer = 0;
        for(int i = 0; i < w; i++) {
            double y1 = ((double) h * i) / (double) w;
            double y2 = ((double) h * (i+1)) / (double) w;
            int y1Count = (int) y1;
            int y2Count = (int) Math.ceil(y2);

            long count = y2Count - y1Count + 0L;
            answer += count;
        }
        return ((long)w * (long)h) - answer;
    }
}
