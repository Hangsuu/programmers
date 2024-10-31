package hello.javaLv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Java42890 {
    // 후보키
    // 2019 KAKAO BLIND RECRUITMENT
    // courses/30/lessons/42890
    public int solution(String[][] relation) {
        List<String> candidateKeys = new ArrayList<>();
        for(int i=0; i<Math.pow(2, relation[0].length); i++) {
            boolean[] selectedColumn = new boolean[relation[0].length];
            int iTemp = i;
            for(int j=0; j<selectedColumn.length; j++) {
                selectedColumn[j] = iTemp % 2 == 0;
                iTemp /= 2;
            }

            Set<String> columnSet = new HashSet<>();

            for(int j=0; j<relation.length; j++) {
                String tempString = "";
                for(int k=0; k<selectedColumn.length; k++) {
                    if(selectedColumn[k]) {
                        tempString += relation[j][k];
                    }
                }
                columnSet.add(tempString);
            }


            if(columnSet.size() == relation.length) {
                String candidateColumns = "";
                for(int j=0; j<selectedColumn.length; j++) {
                    if (selectedColumn[j]) {
                        candidateColumns += j+"";
                    }
                }
                candidateKeys.add(candidateColumns);
            }
        }

        candidateKeys.sort((a, b) -> {
            if(a.length() != b.length()) {
                return a.length() - b.length();
            } else {
                for(int i=0; i<a.length(); i++) {
                    if(a.charAt(i) != b.charAt(i)) {
                        return a.charAt(i) - b.charAt(i);
                    }
                }
                return 0;
            }
        });

        Set<String> answerSet = new HashSet<>();
        answerSet.add(candidateKeys.get(0));
        for(int i=1; i<candidateKeys.size(); i++) {
            boolean isNew = true;
            String[] keys = candidateKeys.get(i).split("");
            for(String answerString : answerSet) {
                int count = 0;
                for(int j=0; j<keys.length; j++) {
                    if(answerString.contains(keys[j])) {
                        count ++;
                    }
                }
                if (answerString.length() == count) {
                    isNew = false;
                }
            }
            if(isNew) {
                answerSet.add(candidateKeys.get(i));
            }
        }

        return answerSet.size();
    }
}
