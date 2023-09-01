package 준석.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10703 {
    static int R;
    static int S;

    static char[][] picture;

    static int[] lowDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        R = Integer.parseInt(data.split(" ")[0]);
        S = Integer.parseInt(data.split(" ")[1]);

        picture = new char[R][S];
        lowDistance = new int[S];

        //S거리가 최대이므로 S로 초기화
        for (int i = 0; i < S; i++) {
            lowDistance[i] = R;
        }
        //하늘에서 최소길이 찾기
        for (int i = 0; i < R; i++) {
            String value = br.readLine();
            for (int j = 0; j < S; j++) {
                picture[i][j] = value.charAt(j);
                if (picture[i][j] == 'X') {
                    lowDistance[j] = Math.min(lowDistance[j], i);
                }
            }
        }// 0 1 1 2 1 0

        int dist = R;
        //지면에서 높이 찾기
        for (int i = 0; i < S; i++) {
            int ground = R;
            for (int j = R - 1; j >= 0; j--) {
                if (picture[j][i] == '#') {
                    ground = j;
                    break;
                }
            }
            if (lowDistance[i] < R) {
                dist = Math.min(dist, ground - lowDistance[i] - 1);
            }
        }
        //유성 이동
        for (int i = R - 1; i >= 0; i--) {
            for (int j = 0; j < S; j++) {
                if (picture[i][j] == 'X') {
                    picture[i][j] = '.';
                    if (i + dist < R) {
                        picture[i + dist][j] = 'X';
                    }
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                System.out.print(picture[i][j]);
            }
            System.out.println();
        }
    }
}
