package 준석.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//플로이드 워셜
public class BJ11403 {
    static int N;
    static int[][] array;

    static int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(data.split(" ")[j]);
            }
        }
        result = array.clone();

        play();

        for(int i = 0; i< N; i++){
            for(int j = 0; j<N; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    static void play() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (array[j][i] == 1 && array[i][k] == 1) {
                        result[j][k] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }
    }

}
