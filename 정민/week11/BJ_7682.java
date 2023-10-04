package 정민.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_7682 {
    static char[][] game;
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            str = br.readLine();
            game = new char[3][3];

            int x = 0; // x 카운트
            int o = 0; // ㅇ 카운트

            if (str.equals("end"))
                System.exit(0); // end일 경우 종료

            for (int i = 0; i < str.length(); i++) {
                if (i < 3)
                    game[0][(i % 3)] = str.charAt(i);
                else {
                    game[i / 3][(i % 3)] = str.charAt(i);
                }

                if (str.charAt(i) == 'X')
                    x++;
                else if (str.charAt(i) == 'O')
                    o++;
            }

            if (x == o || (x - 1) == o) {
                if (x < 3) {
                    System.out.println("invalid");
                    continue;
                }
                if (canFinish(x, o)) {
                    System.out.println("valid");
                } else {
                    System.out.println("invalid");
                }

            } else {
                System.out.println("invalid");
                continue;
            }

        }

    }

    public static boolean canFinish(int x, int o) {
        int winX = 0;
        int winO = 0;
        // 가로 세로 일치? 성공한 경우
        for (int i = 0; i < 3; i++) {
            if (game[i][0] == game[i][1] && game[i][1] == game[i][2] && game[i][0] == game[i][2]) {
                if (game[i][0] == 'X') {
                    winX++;
                } else if (game[i][0] == 'O') {
                    winO++;
                }
            }
            if (game[0][i] == game[1][i] && game[1][i] == game[2][i] && game[0][i] == game[2][i]) {
                if (game[0][i] == 'X') {
                    winX++;
                } else if (game[0][i] == 'O') {
                    winO++;
                }
            }
        }

        // 대각선 일치?
        if (game[0][0] == game[1][1] && game[0][0] == game[2][2] && game[1][1] == game[2][2]) {
            if (game[0][0] == 'X')
                winX++;
            else if (game[0][0] == 'O')
                winO++;
        }
        if (game[0][2] == game[1][1] && game[0][2] == game[2][0] && game[1][1] == game[2][0]) {
            if (game[0][2] == 'X')
                winX++;
            else if (game[0][2] == 'O')
                winO++;
        }

        if (winX > 0) {
            if (winO > 0) // 이미 두번째 사람이 이겨 끝나야 하므로
                return false;
            else {
                if (x - 1 == o)
                    return true;
                else
                    return false;
            }
        }
        if (winO > 0) {
            if (x == o)
                return true;
            else
                return false;
        } else {
            if (x + o == 9)
                return true;
            else
                return false;
        }

    }
}
