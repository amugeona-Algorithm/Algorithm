package 준석.준석.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2630 {

    static int N;

    static int[][] array;

    static int whiteCount;

    static int blueCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        for (int i = 0; i < N; i++) {
            String value = br.readLine();
            String[] valueArray = value.split(" ");
            for (int j = 0; j < N; j++) {
                array[j][i] = Integer.parseInt(valueArray[j]);
            }
        }
        conquer(0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    static void conquer(int x, int y, int n) {
        //종이를 돌고 하나로 아니면 2분의1로가름

        if(isSameColor(x,y,n)){
            if(array[x][y] == 1){
                blueCount++;
            }
            else{
                whiteCount++;
            }
            return;
        }

        int dividedNumber = n / 2;


        conquer(x, y, dividedNumber);
        conquer(x + dividedNumber, y, dividedNumber);
        conquer(x, y + dividedNumber, dividedNumber);
        conquer(x + dividedNumber, y + dividedNumber, dividedNumber);
    }

    static boolean isSameColor(int x, int y, int n) {
        int color = array[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (array[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}