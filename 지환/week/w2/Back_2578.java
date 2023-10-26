package 지환.week.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2578 {
    static int[][] bingGoMap = new int[5][5];
    static int bingCount = 0;
    static int turn = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingGoMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int inputNum = Integer.parseInt(st.nextToken());
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (bingGoMap[k][l] == inputNum) {
                            bingGoMap[k][l] = -1;
                        }
                    }
                }
                rowCheck();
                colCheck();
                rightDiagonalCheck();
                leftDiagonalCheck();
                if (bingCount >= 3) {
                    System.out.println(turn + 1);
                    System.exit(0);
                }
                bingCount = 0;
                turn++;
            }
        }
    }

    static void rowCheck() {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingGoMap[i][j] == -1) {
                    count++;
                }
            }

            if (count == 5) {
                bingCount++;
            }
        }
    }

    static void colCheck() {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (bingGoMap[j][i] == -1) {
                    count++;
                }
            }

            if (count == 5) {
                bingCount++;
            }
        }
    }

    static void rightDiagonalCheck() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (bingGoMap[i][i] == -1) {
                count++;
            }
        }
        if (count == 5) {
            bingCount++;
        }
    }

    static void leftDiagonalCheck() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (bingGoMap[i][4 - i] == -1) {
                count++;
            }
        }
        if (count == 5) {
            bingCount++;
        }
    }

}
