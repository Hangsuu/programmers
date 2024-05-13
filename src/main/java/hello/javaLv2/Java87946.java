package hello.javaLv2;

public class Java87946 {
    // 피로도
    // 순열(Permutation)
    // courses/30/lessons/87946
    private static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int[] index = new int[dungeons.length];
        boolean[] visited = new boolean[dungeons.length];

        permutation(visited, index, 0, dungeons.length, dungeons, k);



        return answer;
    }

    public static void permutation(boolean[] visited, int[] index ,int depth, int r, int[][] dungeons, int k) {
        if(depth == r) {
            int answerTemp = 0;
            int indexTemp = 0;
            int kTemp = k;
            while(indexTemp < r && dungeons[index[indexTemp]][0] <= kTemp) {
                answerTemp ++;
                kTemp -= dungeons[index[indexTemp]][1];
                indexTemp ++;
            }
            answer = Math.max(answer, answerTemp);
        }

        for(int i=0; i<index.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                index[depth] = i;
                permutation(visited, index, depth+1, r, dungeons, k);
                visited[i] = false;
            }
        }
    }
}
