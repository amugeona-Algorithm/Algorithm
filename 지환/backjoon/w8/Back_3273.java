package 지환.backjoon.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back_3273 {

    /*
    백준 3273
    블로그
    실버 3
     */
    static int N;

    static int X;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        X = Integer.parseInt(br.readLine());
        int count = 0;

        for (int st = 0; st < N; st++) {
            for (int i = st; i < N - 1; i++) {
                if (X == numbers[st] + numbers[i + 1]) {
                    count++;
                    //정렬을 한번 해주었기 때문에 그 뒤에 애들은 볼 필요가 없음
                    break;
                }
            }
        }
        System.out.println(count);
    }
}

