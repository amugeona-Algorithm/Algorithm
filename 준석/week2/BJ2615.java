package 준석.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2615 {
    static int[][] concave = new int[19][19];
    static int[][] d = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 19; i++) {
            String value = br.readLine();
            for (int j = 0; j < 19; j++) {
                concave[i][j] = Integer.parseInt(value.split(" ")[j]);
            }
        }
        findLengthConcave();
    }

    public static void findLengthConcave() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (concave[i][j] == 1 || concave[i][j] == 2) {
                    for (int k = 0; k < 4; k++) {
                        int x = i;
                        int y = j;
                        int count = 1;

                        while (true) {
                            x += d[k][0];
                            y += d[k][1];
                            if (0 <= x && x < 19 & 0 <= y && y < 19) {
                                if (concave[i][j] == concave[x][y]) {
                                    count++;
                                } else {
                                    break;
                                }
                            } else {
                                break;

                            }
                        }
                        x = i;
                        y = j;

                        while (true) {
                            x -= d[k][0];
                            y -= d[k][1];
                            if (0 <= x && x < 19 && 0 <= y && y < 19) {
                                if (concave[i][j] == concave[x][y]) {
                                    count++;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        if (count == 5) {
                            System.out.println(concave[i][j]);
                            System.out.println((i + 1) + "" + (j + 1));
                            return;
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}
