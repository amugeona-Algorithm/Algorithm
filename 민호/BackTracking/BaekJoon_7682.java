package 민호.BackTracking;

import java.util.*;
import java.io.*;

public class BaekJoon_7682 {
    /**
     * 백준 7682
     * 백트래킹 - 틱택토
     * Gold 5
     */

    static char[][] board;
    static int countX;
    static int countO;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("end"))
                break;

            countX = 0;
            countO = 0;
            board = new char[3][3];

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = s.charAt(3 * i + j);
                    if (board[i][j] == 'X')
                        countX++;
                    else if (board[i][j] == 'O')
                        countO++;
                }
            }
            System.out.println(checkValid());

        }
    }

    static String checkValid() {
        if (countX > countO + 1 || countX < countO)    // X의 개수는 O와 동일하거나 1개 많다.
            return "invalid";

        if (countX + countO == 9 && countX - countO == 1 && !checkWin('X') && !checkWin('O'))    //승부가 나지 않은 경우
            return "valid";

        if (countX == countO + 1) {   //X의 승리
            if (checkWin('X') && !checkWin('O'))
                return "valid";
            else return "invalid";
        }

        if (countX == countO) {   //O의 승리
            if (!checkWin('X') && checkWin('O'))
                return "valid";
            else return "invalid";
        }

        return "invalid";
    }

    static boolean checkWin(char value) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == value && board[i][1] == value && board[i][2] == value)    //가로 검사
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == value && board[1][i] == value && board[2][i] == value)    //세로 검사
                return true;
        }

        if (board[0][0] == value && board[1][1] == value && board[2][2] == value)        //대각선 검사
            return true;
        if (board[0][2] == value && board[1][1] == value && board[2][0] == value)        //대각선 검사
            return true;

        return false;
    }
}
