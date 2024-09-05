package hello.basic;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int n = arr.length;
        int r = 3; // r개를 선택하여 순열 생성
        permute(arr, 0, n, r);
    }

    // 순열을 계산하는 메소드
    public static void permute(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1, n, r);
            swap(arr, depth, i); // 원상 복구
        }
    }

    // 배열 출력 메소드
    public static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 배열의 두 요소를 교환하는 메소드
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
