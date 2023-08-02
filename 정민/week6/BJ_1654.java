package 정민.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654 {
    /*
     * 백준 1654
     * 랜선 자르기
     * 이분 탐색
     */
    static int N, K; // res : n개를 만들 수 있는 랜선의 최대 길이
    static int[] line;
    static long end = Long.MIN_VALUE;
    static long start = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new int[K];
        for (int i = 0; i < K; i++) {
            line[i] = Integer.parseInt(br.readLine());
            end = Math.max(line[i], end); // 최댓값
        }

        binarySearch();
        System.out.println(start - 1);
    }

    public static void binarySearch() {
        long middle = 0;

        while (start <= end) {
            middle = (start + end) / 2;

            int cnt = cutLine(middle);

            if (cnt < N) { // 랜선 생성 불가능할 때
                end = middle - 1;
            } else {
                // 랜선 생성 가능 시
                start = middle + 1;
            }
        }

    }

    public static int cutLine(long size) {
        int cnt = 0;

        for (int i = 0; i < K; i++) {
            cnt += (line[i] / size);
        }

        return cnt;
    }
}
