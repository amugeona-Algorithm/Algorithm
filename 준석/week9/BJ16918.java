package 준석.week9;

import java.util.Scanner;

public class BJ16918 {
    static int R;
    static int C;
    static int N;

    static char[][] grid;
    static int[][] time;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        N = sc.nextInt();
        grid = new char[R][C];
        time = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'O') {
                    time[i][j] = 0;
                }
            }
        }

        for (int t = 1; t <= N; t++) {
            char[][] newGrid = new char[R][C];
            int[][] newTime = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    newGrid[i][j] = grid[i][j];
                    newTime[i][j] = time[i][j] + 1;
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (grid[i][j] == 'O' && time[i][j] == 3) {
                        newGrid[i][j] = '.';
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d], ny = j + dy[d];
                            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                                newGrid[nx][ny] = '.';
                            }
                        }
                    }
                    if (t % 2 == 0 && grid[i][j] == '.') {
                        newGrid[i][j] = 'O';
                        newTime[i][j] = 0;
                    }
                }
            }

            grid = newGrid;
            time = newTime;
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}