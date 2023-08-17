package 정민.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2428 {
    /*
     * 백준 2428
     * 표절
     * 투포인터
     */
    static int N;
    static int[] file;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        file = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            file[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(file);
        cnt = 0;

        twoPointer();

        System.out.println(cnt);
    }

    public static void twoPointer() {
        int left = 0, right = 0;
        double size = 0;

        while (left < N) {
            while (right < N - 1) {
                size = 0.9 * file[right + 1];
                if (file[left] < size)
                    break;
                else
                    right++;
            }
            cnt += right - left;
            left++;
        }

    }
}
