package 정민.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3273 {
    /*
     * 백준 3273
     * 두 수의 합
     */
    static int N, X;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        System.out.println(twoPointer());

    }

    public static int twoPointer() {
        int cnt = 0;
        int start = 0, end = N - 1;

        while (start < end) {
            if (arr[start] + arr[end] == X) {
                cnt++;
                start++;
                end--;
            } else if (arr[start] + arr[end] > X) {
                end--;
            } else
                start++;
        }

        return cnt;
    }
}
