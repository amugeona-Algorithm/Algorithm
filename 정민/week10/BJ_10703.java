package 정민.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10703 {
    // 백준 10703
    // 유성

    static char[][] map, res;
    static int R, S;
    static int[] topGround;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new char[R][S];
        res = new char[R][S];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        topGround = new int[S];

        // 최소거리 계산
        for (int i = 0; i < S; i++) {
            int temp = minDis(i);
            if (temp != 0 && temp < min)
                min = temp;
        }
        min--; // 움직여야할 거리

        moveMap();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if (res[i][j] != 'X' & res[i][j] != '#')
                    sb.append('.');
                else
                    sb.append(res[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static int minDis(int n) {
        int endStar = -1; // 땅에 제일 가까운 유성
        int startGround = 3001; // 유성에 제일 가까운 땅
        for (int i = 0; i < R; i++) {
            if (map[i][n] == 'X')
                endStar = i;
            else if (startGround == 3001 && map[i][n] == '#') {
                startGround = i;
                topGround[n] = i;

                if (endStar == -1)
                    return 0;
            }
        }

        return Math.abs(startGround - endStar);
    }

    public static void moveMap() {
        for (int j = 0; j < S; j++) {
            int top = topGround[j];
            for (int i = top - 1; i - min >= 0; i--) {
                res[i][j] = map[i - min][j];
            }
            for (int i = top; i < R; i++) { // 땅 그림은 같음
                res[i][j] = map[i][j];
            }
        }
    }

}