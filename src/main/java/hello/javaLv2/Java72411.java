package hello.javaLv2;

import java.util.*;

public class Java72411 {
    // 메뉴 리뉴얼
    // 조합
    // courses/30/lessons/72411
    public String[] solution(String[] orders, int[] course) {
        List<String> resultList = new ArrayList<>();

        for(int i=0; i<course.length; i++) {
            int courseCount = course[i];
            Map<String, Integer> menuMap = new HashMap<>();

            for(int j=0; j<orders.length; j++) {
                String[] orderArray = orders[j].split("");
                Arrays.sort(orderArray);
                boolean[] visited = new boolean[orderArray.length];
                if(orderArray.length < courseCount) {
                    continue;
                }
                getCombination(menuMap, orderArray, visited, 0, orderArray.length, courseCount);
            }

            List<String> menuList = new ArrayList<>(menuMap.keySet());

            int maxCount = 0;
            for(int k = 0; k < menuList.size(); k++) {
                maxCount = Math.max(maxCount, menuMap.get(menuList.get(k)));
            }

            if(maxCount < 2) {
                continue;
            }
            for(int k=0; k < menuList.size(); k++) {
                if(menuMap.get(menuList.get(k)) == maxCount) {
                    resultList.add(menuList.get(k));
                }
            }
        }

        String[] answer = new String[resultList.size()];
        Collections.sort(resultList);

        for(int i=0; i<resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }

    private void getCombination(Map<String, Integer> menuMap,
                                String[] orderArray, boolean[] visited,
                                int start, int n, int r) {
        if (r == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<visited.length; i++) {
                if(visited[i]) {
                    sb.append(orderArray[i]);
                }
            }

            String temp = sb.toString();
            menuMap.put(temp, menuMap.getOrDefault(temp, 0) + 1);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            getCombination(menuMap, orderArray, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
}
