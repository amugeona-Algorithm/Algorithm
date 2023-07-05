package 민호.Implementation;

import java.util.*;
import java.io.*;

public class BaekJoon_2578 {
    /**
     * 백준 2578
     * 빙고 문제
     */

    static int[][] player = new int[5][5];
    static int[][] call = new int[5][5];
    static int countBingo;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int countBingo = 0;

        setArray(player, br);
        setArray(call, br);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                countBingo = 0;
                int callNum = call[i][j];
                checkNum(callNum);
                checkWidthBingo();
                checkLengthBingo();
                checkLeftToRightDiagonal();
                checkRightToLeftDiagonal();
                result++;

                if (countBingo >= 3) {  //한번에 2->4가 될수도 있기에 == 는 모든 테스트 케이스 만족X
                    System.out.println(result);
                    System.exit(0);
                }
            }
        }


    }

    public static void setArray(int[][] array, BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < array.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static void checkNum(int callNum) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (player[i][j] == callNum)
                    player[i][j] = 0;
            }
        }
    }

    public static void checkWidthBingo() {
        int checkBingo;

        for (int i = 0; i < 5; i++) {
            checkBingo = 0;
            for (int j = 0; j < 5; j++) {
                if (player[i][j] == 0)
                    checkBingo++;
                if (checkBingo == 5)
                    countBingo++;
            }
        }
    }

    public static void checkLengthBingo() {
        int checkBingo;

        for (int i = 0; i < 5; i++) {
            checkBingo = 0;
            for (int j = 0; j < 5; j++) {
                if (player[j][i] == 0) {
                    checkBingo++;
                }
                if (checkBingo == 5)
                    countBingo++;
            }
        }
    }

    public static void checkLeftToRightDiagonal() {
        int checkBingo = 0;

        for (int i = 0; i < 5; i++) {
            if (player[i][i] == 0)
                checkBingo++;
            if (checkBingo == 5)
                countBingo++;
        }
    }

    public static void checkRightToLeftDiagonal() {
        int checkBingo = 0;

        for(int i=0; i<5; i++){
            if(player[i][4-i] == 0)
                checkBingo++;
            if(checkBingo == 5)
                countBingo++;
        }
    }

}
