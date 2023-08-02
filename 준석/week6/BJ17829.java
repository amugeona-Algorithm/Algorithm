package 준석.week6;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ17829 {

    static int N;

    static int[][] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[N][N];

        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            String[] value = data.split(" ");
            for (int j = 0; j < value.length; j++) {
                array[i][j] = Integer.parseInt(value[j]);
            }
        }
        System.out.println(play(0, 0, N));
    }

    static int play(int x, int y, int n) {
        //size가 2가되면 2*2배열로 나뉜거이므로 copy배열에 넣고 findvalue실행
        if (n == 2) {
            int[] copy = new int[4];
            int index = 0;
            for (int i = x; i <= x + 1; i++) {
                for (int j = y; j <= y + 1; j++) {
                    copy[index] = array[i][j];
                    index++;
                }
            }
            return findValue(copy);
        } else {
            int[] arr = new int[4];
            int divideNumber = n / 2;

            arr[0] = play(x, y, divideNumber);
            arr[1] =play(x, y + divideNumber, divideNumber);
            arr[2]= play(x + divideNumber, y, divideNumber);
            arr[3] =play(x + divideNumber, y + divideNumber, divideNumber);

            return findValue(arr);
        }
    }

    //정렬해서 두번째로 큰값
    static int findValue(int[] array) {

        Arrays.sort(array);

        return array[2];
    }

}
