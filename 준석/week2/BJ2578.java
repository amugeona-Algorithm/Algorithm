package 준석.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2578 {
    static int[][] playerBingo = new int[5][5];
    static int[][] refereeBingo = new int[5][5];
    static int count;
    static int bingoCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String value = br.readLine();
            for (int j = 0; j < 5; j++) {
                playerBingo[i][j] = Integer.parseInt(value.split(" ")[j]);
            }

        }
        for (int i = 0; i < 5; i++) {
            String value = br.readLine();
            for (int j = 0; j < 5; j++) {
                refereeBingo[i][j] = Integer.parseInt(value.split(" ")[j]);
            }
        }
        int selectedNumber;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                selectedNumber = refereeBingo[i][j];
                bingoCount++;
                findPlayerBingo(selectedNumber);

                if (count >= 3) {
                    System.out.println(bingoCount);
                    System.exit(0);
                }
            }
        }
    }

    public static void findPlayerBingo(int selectedNumber) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (playerBingo[row][col] == selectedNumber) {
                    playerBingo[row][col] = 0;
                    count = 0;
                    checkWidthBingo();
                    checkLengthBingo();
                    checkLeftDiagonalBingo();
                    checkRightDiagonalBingo();
                }
            }
        }
    }

    public static void checkWidthBingo() {
        for (int i = 0; i < 5; i++) {
            int bingoReferee = 0;
            for (int j = 0; j < 5; j++) {
                if (playerBingo[i][j] == 0) {
                    bingoReferee++;
                }
            }
            if (bingoReferee == 5) {
                count++;
            } else {
                bingoReferee = 0;
            }
        }
    }

    public static void checkLengthBingo() {
        for (int i = 0; i < 5; i++) {
            int bingoReferee = 0;
            for (int j = 0; j < 5; j++) {
                if (playerBingo[j][i] == 0) {
                    bingoReferee++;
                }
            }
            if (bingoReferee == 5) {
                count++;
            } else {
                bingoReferee = 0;
            }
        }

    }

    public static void checkLeftDiagonalBingo() {
        int bingoReferee = 0;

        for (int i = 0; i < 5; i++) {
            if (playerBingo[i][i] == 0) {
                bingoReferee++;
            }
            if (bingoReferee == 5) {
                count++;
            }
        }
    }

    public static void checkRightDiagonalBingo() {
        int bingoReferee = 0;
        for (int i = 0; i < 5; i++) {
            if (playerBingo[i][4 - i] == 0) {
                bingoReferee++;
            }
            if (bingoReferee == 5) {
                count++;
            }
        }
    }
}
