package Algorithm.지환.backjoon.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Back_5212 {
    /*
    백준 5212
    지구 온난화
     */


    static String[][] map;
    static int R;
    static int C;
    static int[] dr = {0, 1, 0, -1};//우,하,좌,상
    static int[] dc = {1, 0, -1, 0};
    static String[][] newMap;

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new String[R][C];
        newMap = new String[R][C];

        for (int i = 0; i < R; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                map[i][j] = strings[j];
                newMap[i][j] = ".";
            }
        }

        //여기 까지가 맵 세팅


        //지도 출력 범위 지정
        int minR = 10;
        int maxR = 0;
        int minC = 10;
        int maxC = 0;

        //탐색
        for (int i = 0; i <R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("X")) {
                    cnt = 0;
                    countSea(i, j);
                    if (cnt < 3) { // 땅이 50년 후에 살아 남을 경우
                        newMap[i][j] = "X";
                        maxR = Math.max(maxR, i);
                        minR = Math.min(minR, i);
                        maxC = Math.max(maxC, j);
                        minC = Math.min(minC, j);
                    }
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                System.out.printf(newMap[i][j]);
            }
            System.out.println();
        }

    }

    static void countSea(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if (nextR == -1 || nextC <= -1 || nextC == C || nextR == R || map[nextR][nextC].equals(".")) {
                cnt++;
            }
        }
    }
}
