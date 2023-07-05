package 정민.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 2578
 * 빙고
 * 구현
 */
public class BJ_2578 {
    static int[][] map, callNum;
    static int res;

    public static void main(String[] args) throws IOException {
        map = new int[5][5];
        callNum = new int[5][5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                callNum[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                res++;
                checkBingo(callNum[i][j]); // 숫자 지우기

                if (res < 5)
                    continue;

                if (isFinish()) {
                    System.out.println(res);
                    System.exit(0);
                }
            }
        }
    }

    public static void checkBingo(int n) {
        // 일단 빙고 지우기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == n) {
                    map[i][j] = -1;
                    return;
                }
            }
        }
    }

    public static boolean isFinish() {
        // 빙고 완성했는지 체크
        // 가로줄 완성?
        int line = 0;

        for (int i = 0; i < 5; i++) {
            int xCnt = 0, yCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == -1)
                    xCnt++;
                if (map[j][i] == -1)
                    yCnt++;
            }
            if (xCnt == 5)
                line++;
            if (yCnt == 5)
                line++;
        }

        if (map[0][0] == -1 && map[1][1] == -1 && map[2][2] == -1 && map[3][3] == -1 && map[4][4] == -1)
            line++;
        if (map[0][4] == -1 && map[1][3] == -1 && map[2][2] == -1 && map[3][1] == -1 && map[4][0] == -1)
            line++;

        if (line >= 3)
            return true;
        else
            return false;

    }
}