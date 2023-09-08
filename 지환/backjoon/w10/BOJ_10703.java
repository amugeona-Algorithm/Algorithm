package 지환.backjoon.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_10703 {
    /*
    백준 10703
    유성
    실버1
     */
    private static char[][] map;


    private static int R, S;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static List<Stone> stones = new ArrayList<>();
    static boolean isCrash;
    static int depth = 1;
    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = array[0];
        S = array[1];
        map = new char[R][S];


        for (int i = 0; i < R; i++) {
            char[] split = br.readLine().toCharArray();
            for (int j = 0; j < S; j++) {
                //맵초기화
                char tmp = split[j];
                map[i][j] = tmp;
                //만약에 운석이라면
                if (tmp == 'X') {
                    Stone stone = new Stone(i, j);
                    stones.add(stone);
                    map[i][j] = '.';
                }
            }
        }


        while (!isCrash) {
            down(depth);
            if(!isCrash) {
                depth++;
            }
        }

        for (Stone s : stones) {
            //충돌 시점의 depth 이니 -1 해줌
            map[s.r + depth-1][s.c] = 'X';
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void down(int depth) {
        for (Stone stone : stones) {
            //돌이 범위를 넘었거나 땅에 닿으면
            if (stone.r + depth >= R || map[stone.r + depth][stone.c] == '#') {
                isCrash = true;
                break;
            }
        }
    }

    static class Stone {
        int r, c;

        public Stone(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
