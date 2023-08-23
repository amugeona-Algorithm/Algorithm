package 준석.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7576 {
    static int M;
    static int N;

    static int[][] array;

    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,-1,1};
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().split(" ");

        M = Integer.parseInt(data[0]);
        N = Integer.parseInt(data[1]);

        array = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] value = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(value[j]);
                if (array[i][j] == 1) {
                    queue.add(new Pair(i, j));
                    //큐에다가 좌표 저장
                }
            }
        }

        System.out.println(play());
    }

    public static int play() {
        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i]; //상하좌우 판단하기 위해
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                } //경계 벗어났는지

                if (array[nextX][nextY] == 0) {
                    array[nextX][nextY] = array[current.x][current.y] + 1;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] == 0) {
                    return -1;
                }
                max = Math.max(max, array[i][j]);
            }
        }
        return max - 1; // 시작일이 1이므로 최종 결과에서 1을 뺍니다.
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

