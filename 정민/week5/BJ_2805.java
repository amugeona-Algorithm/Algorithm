package 정민.week5;

import java.util.Scanner;

public class BJ_2805 {
    // 나무 자르기
    static int N, M; // 나무의 수, 집으로 가져가려는 나무의 길이
    static int[] tree; // 나무의 높이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        tree = new int[N]; // 나무의 높이 받기
        int max = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            max = Math.max(tree[i], max);
        }
        System.out.println(max);

        int res = 0;

        res = binarySearch(max);
        System.out.println(res);

    }

    public static int binarySearch(int high) {
        int low = 0; // 제일 작은 값은 0으로 초기화

        while (low < high) {
            int sum = 0;
            int mid = (low + high) / 2; // 반으로 이분탐색, 자를 높이
            System.out.println("mid : " + mid);
            for (int i = 0; i < N; i++) {
                if (tree[i] - mid > 0) {
                    sum += tree[i] - mid; // 음수면 저장하면 안되니까~
                }
            }
            System.out.println("sum : " + sum);
            if (sum < M) {
                high = mid;
            } else if (sum >= M) { // 높이 반 자르기
                low = mid + 1;
            }
        }

        return low - 1;
    }
}
