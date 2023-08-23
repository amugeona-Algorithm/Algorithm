package 민호.Simulation;

import java.util.*;
import java.io.*;

public class BaekJoon_14891 {
    /**
     * 백준 14891
     * 시뮬레이션 - 톱니바퀴
     * Gold 5
     */

    static int K;           //회전 횟수
    static int[][] gear = new int[4][8];    //톱니바퀴 상태
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gear[i][j] = s.charAt(j) - '0';
            }
        }

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1; //톱니바퀴 번호
            int dir = Integer.parseInt(st.nextToken());     //회전 방향
            checkAndSpin(gearNum, dir);
        }

        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 0)
                result += 0;
            else if (gear[i][0] == 1) {
                result += Math.pow(2, i);
            }
        }

        System.out.println(result);
    }

    static void checkAndSpin(int gearNum, int dir) {
        checkLeft(gearNum - 1, -dir);
        checkRight(gearNum + 1, -dir);
        spinGear(gearNum, dir);
    }

    static void checkLeft(int gearNum, int dir) {
        if (gearNum < 0)
            return;
        if (gear[gearNum][2] == gear[gearNum + 1][6])
            return;
        checkLeft(gearNum - 1, -dir);
        spinGear(gearNum, dir);
    }

    static void checkRight(int gearNum, int dir) {
        if (gearNum > 3)
            return;
        if (gear[gearNum][6] == gear[gearNum - 1][2])
            return;
        checkRight(gearNum + 1, -dir);
        spinGear(gearNum, dir);
    }

    static void spinGear(int gearNum, int dir) {
        if (dir == 1) {     //시계방향 회전
            int temp = gear[gearNum][7];
            for (int i = 7; i > 0; i--) {
                gear[gearNum][i] = gear[gearNum][i - 1];
            }
            gear[gearNum][0] = temp;
        } else if (dir == -1) {     //반시계방향 회전
            int temp = gear[gearNum][0];
            for (int i = 0; i < 7; i++) {
                gear[gearNum][i] = gear[gearNum][i + 1];
            }
            gear[gearNum][7] = temp;
        }
    }
}
