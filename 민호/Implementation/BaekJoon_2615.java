package 민호.Implementation;

import java.util.*;
import java.io.*;

public class BaekJoon_2615 {
    /**
     * 백준 2615
     * 오목
     */
    static int[][] board = new int[19][19];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 1 || board[i][j] == 2) {
                    if (j <= 14)
                        checkRight(i, j);
                    if (i <= 14)
                        checkDown(i, j);
                    if (i <= 14 && j <= 14)
                        checkRightDown(i, j);
                    if (i <= 14 && j >= 4)
                        checkLeftDown(i, j);
                }
            }
        }
        System.out.println(0);
    }

    public static void checkRight(int i, int j) {
        int color = board[i][j];
        int count = 0;

        for (int k = 1; k < 5; k++) {
            if (board[i][j + k] == color)
                count++;
            if (count == 4) {
                System.out.println(color);
                System.out.print(i + 1);
                System.out.print(" ");
                System.out.print(j + 1);
                System.exit(0);
            }
        }
    }

    public static void checkDown(int i, int j) {
        int color = board[i][j];
        int count = 0;

        for (int k = 1; k < 5; k++) {
            if (board[i + k][j] == color)
                count++;
            if (count == 4) {
                System.out.println(color);
                System.out.print(i + 1);
                System.out.print(" ");
                System.out.print(j + 1);
                System.exit(0);
            }
        }
    }

    public static void checkRightDown(int i, int j) {
        int color = board[i][j];
        int count = 0;

        for (int k = 1; k < 5; k++) {
            if (board[i + k][j + k] == color)
                count++;
            if (count == 4) {
                System.out.println(color);
                System.out.print(i + 1);
                System.out.print(" ");
                System.out.print(j + 1);
                System.exit(0);
            }
        }
    }

    public static void checkLeftDown(int i, int j) {
        int color = board[i][j];
        int count = 0;

        for (int k = 1; k < 5; k++) {
            if (board[i + k][j - k] == color)
                count++;
            if (count == 4) {
                System.out.println(color);
                System.out.print(i + 5);
                System.out.print(" ");
                System.out.print(j - 3);
                System.exit(0);
            }
        }
    }

}
