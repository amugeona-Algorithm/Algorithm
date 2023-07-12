package 정민.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loca {
    int r;
    int c;

    Loca(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class BJ_16234_before {
    /*
     * 백준 인구 이동
     * 16234
     */
    static int N, L, R, day;
    static boolean isMove = false;
    static int[][] ppl;
    static boolean[][] visited; // 방문체크 배열
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
    static ArrayList<Loca> moving = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); // L명 이상
        R = Integer.parseInt(st.nextToken()); // R명 이하
        day = 0;

        ppl = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ppl[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 곳을 방문해야하니 bfs 탐색인가?
        // 1. 모든 좌표에 대해 bfs 탐색
        // 2. 조건을 만족하면 방문처리
        // 3. arraylist를 사용하여 방문한 좌표값을 기록
        // 4. bfs 탐색이 끝나면 list애 있는 좌표값으로 인구수를 조정한다
        // 5. 움직인 나라가 없을때까지 반복한다.
        move();
        System.out.println(day); // 결과 출력

    }

    public static void move() {
        // 방문 체크
        while (true) {
            isMove = false;
            visited = new boolean[N][N]; // 새로 탐색할떄마다 초기화
            // bfs 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        bfs(i, j);
                    }
                }
            }
            if (isMove)
                day++;
            else
                break;
        }
    }

    public static void bfs(int x, int y) {
        // bfs 탐색을 위한 queue
        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(x, y));
        moving.add(new Loca(x, y)); // 인구이동 좌표에도 넣어야함

        while (!que.isEmpty()) {
            Loca temp = que.poll();
            // int r = temp.r;
            // int c = temp.c;

            for (int d = 0; d < 4; d++) {
                x = temp.r;
                y = temp.c;
                int nr = x + dr[d];
                int nc = y + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]
                        && Math.abs(ppl[nr][nc] - ppl[x][y]) >= L
                        && Math.abs(ppl[nr][nc] - ppl[x][y]) <= R) {
                    // 조건을 만족하면
                    que.add(new Loca(nr, nc));
                    visited[nr][nc] = true;
                    moving.add(new Loca(nr, nc));
                    isMove = true;

                }
            }
        }

        // bfs 탐색을 모두 마치면 인구이동 결과를 맵에 재정비
        int sum = 0;
        for (int i = 0; i < moving.size(); i++) {
            Loca loca = moving.get(i);
            sum += ppl[loca.r][loca.c];
        }
        int temp = sum / moving.size();
        for (int i = 0; i < moving.size(); i++) {
            Loca loca = moving.get(i);
            ppl[loca.r][loca.c] = temp;
        }

        moving.removeAll(moving); // 싹다 지워야 다음 인구이동 가능
    }
}
