package hello.basic;

public class Combination {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};  // 배열
        int n = arr.length;        // 배열의 길이
        int r = 2;                 // 선택할 원소의 개수
        boolean[] visited = new boolean[n];  // 방문 여부 체크

        combine(arr, visited, 0, n, r);
    }

    // 조합을 계산하는 메소드
    public static void combine(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combine(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 조합 결과를 출력하는 메소드
    public static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
