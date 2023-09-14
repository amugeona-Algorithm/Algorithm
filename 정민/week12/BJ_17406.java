package 정민.week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_17406 {
    /*
     * 백준 17406
     * 배열돌리기 4
     */
    static int N, M, K;
    static int min = Integer.MAX_VALUE;
    static int[][] map, copy;
    static ArrayList<Info> list;
    static boolean[] visited; // 방문 정보 저장
    static int[] nums; // 순열 정보 저장

    static class Info {
        int r;
        int c;
        int s;

        public Info(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        // 순열 만들기
        visited = new boolean[K];
        nums = new int[K];

        permu(0);

        System.out.println(min);

    }

    public static void permu(int cnt) {
        if (cnt == K) {
            copycopy(); // 배열 돌리기
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                nums[cnt] = i;
                permu(cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void copycopy() {
        // 돌리기 돌리기 -> 우선 초기화
        copy = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            copy[i] = map[i].clone();
        }

        for (int i = 0; i < K; i++) {
            // 배열 돌리기
            Info info = list.get(nums[i]);

            for (int j = info.s; j >= 1; j--) {
                int x1 = info.r - j; // 시작 r
                int y1 = info.c - j; // 시작 c
                int x2 = info.r + j; // 마지막 r
                int y2 = info.c + j; // 마지막 c
                turnturn(x1, y1, x2, y2);
            }
        }

        checkMin();

    }

    public static void turnturn(int x1, int y1, int x2, int y2) {
        int temp, oldTemp;
        temp = copy[x1][y2];

        // 위
        for (int i = y2; i > y1; i--) {
            copy[x1][i] = copy[x1][i - 1];
        }

        // 오른쪽
        oldTemp = temp;
        temp = copy[x2][y2];

        for (int i = x2; i > x1; i--) {
            if (i == x1 + 1) {
                copy[i][y2] = oldTemp;
                continue;
            }
            copy[i][y2] = copy[i - 1][y2];
        }

        // 아래
        oldTemp = temp;
        temp = copy[x2][y1];

        for (int i = y1; i < y2; i++) {
            if (i == y2 - 1) {
                copy[x2][i] = oldTemp;
                continue;
            }
            copy[x2][i] = copy[x2][i + 1];
        }

        // 왼쪽
        oldTemp = temp;
        for (int i = x1; i < x2; i++) {
            if (i == x2 - 1) {
                copy[i][y1] = oldTemp;
                continue;
            }
            copy[i][y1] = copy[i + 1][y1];
        }
        return;

    }

    public static void checkMin() {
        int sum;

        for (int i = 1; i <= N; i++) {
            sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += copy[i][j];
            }
            min = Math.min(min, sum);
        }

    }
}
