package hello.javaLv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Java131130 {
    // 혼자 놀기의 달인
    // courses/30/lessons/131130
    public int solution(int[] cards) {
        List<Integer> box = new ArrayList<>();
        boolean[] checked = new boolean[cards.length];
        for(int i=0; i<cards.length; i++){
            if(checked[i]) {
                continue;
            }
            checked[i] = true;
            int count = 1;
            int boxIndex = cards[i] - 1;
            while(true) {
                if(checked[boxIndex]) {
                    break;
                } else {
                    checked[boxIndex] = true;
                    boxIndex = cards[boxIndex] -1;
                    count ++;
                }
            }
            box.add(count);
        }
        Collections.sort(box, Collections.reverseOrder());
        if(box.size() < 2) {
            return 0;
        } else {
            return box.get(0) * box.get(1);
        }
    }
}
