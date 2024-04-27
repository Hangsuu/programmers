package hello.javaLv2;

import java.util.ArrayList;
import java.util.List;

public class Java134239 {
    // 우박수열 정적분
    // courses/30/lessons/134239
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Double> sum = new ArrayList<>();
        sum.add(0.0);
        int index = 0;
        while(k > 1) {
            int tempK = k;
            int temp = 0;
            double area = 0;
            if(k%2 ==0) {
                temp = k/2;
                area = (tempK - temp) / 2.0 + temp;
                k = temp;
            } else {
                temp = k*3 + 1;
                area = (temp - tempK) / 2.0 + tempK;
                k = temp;
            }
            index ++;

            sum.add(sum.get(index-1) + area);
        }
        int length = sum.size();
        for(int i=0; i<ranges.length; i++) {
            if(length-1 + ranges[i][1] < ranges[i][0]) {
                answer[i] = -1.0;
            } else {
                answer[i] = sum.get(length-1 + ranges[i][1]) - sum.get(ranges[i][0]);
            }
        }

        return answer;
    }
}
