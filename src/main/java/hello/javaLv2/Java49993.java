package hello.javaLv2;

import java.util.HashMap;
import java.util.Map;

public class Java49993 {
    // 스킬트리
    // courses/30/lessons/49993
    public int solution(String skill, String[] skill_trees) {
        String[] seperatedSkill = skill.split("");
        Map<String, Integer> skillMap = new HashMap<>();
        for(int i=0; i<seperatedSkill.length; i++) {
            skillMap.put(seperatedSkill[i], i);
        }
        int answer = 0;
        for(int i=0; i<skill_trees.length; i++) {
            int currentSkill = -1;
            boolean correct = true;
            String[] skillTree = skill_trees[i].split("");
            for(int j=0; j<skillTree.length; j++) {
                if (skillMap.containsKey(skillTree[j])
                        && skillMap.get(skillTree[j]) != currentSkill + 1) {
                    correct = false;
                } else if (skillMap.containsKey(skillTree[j])) {
                    currentSkill ++;
                }
            }

            if (correct) {
                answer++;
            }
        }

        return answer;
    }
}
