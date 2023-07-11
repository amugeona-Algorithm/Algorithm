package 정민.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16439 {
    /*
     * 백준 16439
     * 치킨치킨치킨
     * 완전탐색
     */
    static int N, M, max, sum;
    static int[][] likeInfo;
    static int[] chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        likeInfo = new int[N][M];
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                likeInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 3; i++) {
            // 최대 3가지 종류의 치킨 고를 수 있음-> 1, 2, 3가지 종류 조합
            chicken = new int[i];
            combi(i, 0, 0);
        }

        System.out.println(max); // 최댓값 출력

    }

    public static void combi(int pick, int cnt, int start) {
        if (cnt == pick) {
            // 치킨 선호도 계산 로직
            sumLike(pick);
            return;
        }

        for (int i = start; i < M; i++) {
            chicken[cnt] = i; // 몇번쨰 치킨이 선택되었는가?
            combi(pick, cnt + 1, i + 1);
        }
    }

    public static void sumLike(int pick) {
        sum = 0;

        for (int i = 0; i < N; i++) {
            int temp = 0;
            for (int j = 0; j < pick; j++) {
                int chiNum = chicken[j];
                temp = Math.max(temp, likeInfo[i][chiNum]);
            }
            sum += temp;
        }

        max = Math.max(max, sum);
        return;
    }

}
