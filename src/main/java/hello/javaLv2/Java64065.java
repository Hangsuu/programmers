package hello.javaLv2;

import java.util.ArrayList;
import java.util.List;

public class Java64065 {
    // 튜플
    // courses/30/lessons/64065
    public int[] solution(String s) {
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] tuples = s.split("\\},\\{");

        List<Long> tuplesList = new ArrayList<>();
        List<Integer> tuplesSize = new ArrayList<>();
        for(int i=0; i<tuples.length; i++) {
            String[] stringTemp = tuples[i].split(",");
            long sum = 0L;
            for(int j=0; j<stringTemp.length; j++) {
                sum += Long.parseLong(stringTemp[j]);
            }
            tuplesList.add(sum);
            tuplesSize.add(stringTemp.length);
        }

        int count = 1;
        long sum = 0L;
        int[] answer = new int[tuplesList.size()];
        for(int i=0; i<tuples.length; i++) {
            int index = tuplesSize.indexOf(count);
            answer[i] = (int) (tuplesList.get(index) - sum);
            sum += answer[i];
            count++;
        }

        return answer;
    }
}
