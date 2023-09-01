package 민호.Simulation;

import java.util.*;
import java.io.*;

public class BaekJoon_10703 {
    /**
     * 백준 10703
     * 시뮬레이션 - 유성
     * Silver 1
     */

    static int R, S; //사진 세로, 사진 가로 길이
    static char[][] beforePhoto;
    static char[][] afterPhoto;
    static int[] dis;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        beforePhoto = new char[R][S];
        afterPhoto = new char[R][S];
        dis = new int[S];

        for (int i = 0; i < R; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < S; j++) {
                beforePhoto[i][j] = tmp[j];
                if (beforePhoto[i][j] == '#')
                    afterPhoto[i][j] = '#';
                else
                    afterPhoto[i][j] = '.';
            }
        }

        for (int j = 0; j < S; j++) {
            int top = Integer.MIN_VALUE;
            int bot = Integer.MAX_VALUE;
            for (int i = 0; i < R; i++) {

                if (beforePhoto[i][j] == 'X') {
                    top = Math.max(top, i); //같은 열 가장 아래있는 유성 위치
                } else if (beforePhoto[i][j] == '#') {
                    bot = Math.min(bot, i); //같은 열 가장 높이있는 땅 위치
                }
                dis[j] = bot - top - 1;
                if (dis[j] < 0)
                    dis[j] = Integer.MAX_VALUE;
            }
        }

        int shortDis = Arrays.stream(dis).min().getAsInt(); //유성과 땅 사이 최소 거리 -> 유성 이동 가능 거리

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                if (i + shortDis < R && beforePhoto[i][j] == 'X') {
                    afterPhoto[i + shortDis][j] = 'X';
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                sb.append(afterPhoto[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
