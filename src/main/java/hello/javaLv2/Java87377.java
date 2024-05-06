package hello.javaLv2;

import java.util.ArrayList;
import java.util.List;

public class Java87377 {
    // 교점에 별 만들기
    // courses/30/lessons/87377
    public String[] solution(int[][] line) {
        long minX = 20000000000L;
        long minY = 20000000000L;
        long maxX = -20000000000L;
        long maxY = -20000000000L;

        List<List<Long>> xy = new ArrayList<>();

        for(int i=0; i<line.length; i++) {
            for(int j=i+1; j<line.length; j++) {
                long a = line[i][0] + 0L;
                long b = line[i][1] + 0L;
                long e = line[i][2] + 0L;
                long c = line[j][0] + 0L;
                long d = line[j][1] + 0L;
                long f = line[j][2] + 0L;
                if(a*d == b*c) {
                    continue;
                }
                if((b*f - e*d) % (a*d - b*c) == 0 && (e*c - a*f) % (a*d - b*c) == 0) {
                    List<Long> temp = new ArrayList<>();
                    long x = (b*f - e*d) / (a*d - b*c);
                    long y = (e*c - a*f) / (a*d - b*c);
                    temp.add(x);
                    temp.add(y);

                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);

                    xy.add(temp);
                }
            }
        }

        String[][] stars = new String[(int)(maxY-minY+1)][(int)(maxX-minX+1)];
        for(int i=0; i<xy.size(); i++) {
            long x = xy.get(i).get(0);
            long y = xy.get(i).get(1);

            stars[(int)(y - minY)][(int)(x - minX)] = "*";
        }

        String[] answer = new String[(int)(maxY-minY+1)];
        for(int i=(int)(maxY-minY); i>=0; i--) {
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<(int)(maxX-minX+1); j++) {
                if("*".equals(stars[i][j])) {
                    sb.append("*");
                } else {
                    sb.append(".");
                }
            }
            answer[answer.length -1 - i] = sb.toString();
        }

        return answer;
    }
}
