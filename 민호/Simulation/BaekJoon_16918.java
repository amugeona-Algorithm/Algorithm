package 민호.Simulation;

import java.util.*;
import java.io.*;

public class BaekJoon_16918 {
    /**
     * 백준 16918
     * 시뮬레이션 - 봄버맨
     * Sliver 1
     */

    static int R, C, N; //세로길이, 가로길이, N초 후
    static int time = 1;
    static char[][] board;
    static char[][] beforeBoard;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        beforeBoard = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        while (true) {
            if (time == N) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        System.out.print(board[i][j]);
                    }
                    System.out.println();
                }
                break;
            }

            time++;
            if (time % 2 == 0) {            //2초 4초 ... 2의 배수일때 빈 곳 폭탄 추가
                for (int i = 0; i < beforeBoard.length; i++) {
                    System.arraycopy(board[i], 0, beforeBoard[i], 0, board[i].length);  //2차원 배열 깊은 복사 -> 폭탄 추가하기 전 상태를 저장해두기
                }
                addBomb();

            } else if (time % 2 == 1) {     //2의 배수가 아닐때 3초전 폭탄 폭발
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        Bomb(i, j);
                    }
                }
            }
        }
    }

    static void addBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '.')
                    board[i][j] = 'O';
            }
        }
    }

    static void Bomb(int r, int c) {
        if (beforeBoard[r][c] == 'O') {         //이전에 저장한 3초전 상태(폭탄 추가 전)에서 폭탄이었던 곳
            board[r][c] = '.';                  //폭탄 폭발
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C)
                    board[nr][nc] = '.';        //board 범위 내 연쇄 폭발
            }
        }
    }
}
