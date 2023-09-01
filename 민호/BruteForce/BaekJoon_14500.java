package 민호.BruteForce;

import java.util.*;
import java.io.*;

public class BaekJoon_14500 {
    /**
     * 백준 14500
     * 완전 탐색 - 테트로미노
     * Gold 4
     */

    static int N, M;     //세로, 가로
    static int[][] paper;
    static int[][] visit;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};
    static int result = Integer.MIN_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        visit = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = 1;    //시작점은 모든 케이스를 확인하는 동안 고정
                dfs(i, j, 1, paper[i][j]);
                visit[i][j] = 0;
            }
        }

        System.out.println(result);
    }


    static void dfs(int r, int c, int count, int point) {
        if (count == 4) {
            result = Math.max(result, point);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && visit[nr][nc] == 0) {

                if(count == 2){     //분홍색 도형은 다른 도형과 다르게 2번째에서 2가지 선택을 해야함
                    visit[nr][nc] = 1;
                    dfs(r, c, count+1, point+paper[nr][nc]);
                    visit[nr][nc] = 0;
                }

                visit[nr][nc] = 1;
                dfs(nr, nc, count + 1, point+paper[nr][nc]);
                visit[nr][nc] = 0;
            }
        }

    }
}
