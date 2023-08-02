package 준석.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.IntPredicate;

public class BJ1992 {
    static int N;

    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            String[] value = data.split("");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(value[j]);
            }
        }
        System.out.println(play(0, 0, N));
    }

    static String play(int x, int y, int size) {

        if (isSameValue(x,y,size)){
            return String.valueOf(array[x][y]);
        }
            int divideNumber = size / 2;
            return "("+ play(x, y, divideNumber)+
            play(x, y + divideNumber, divideNumber)+
            play(x + divideNumber, y, divideNumber)+
            play(x + divideNumber, y + divideNumber, divideNumber) + ")";
    }

    static boolean isSameValue(int x, int y, int size) {
        for(int i = x; i< x+size; i++){
            for(int j = y; j < y+size; j++){
                if(array[i][j] != array[x][y])
                    return false;
            }
        }
        return true;
    }
}
