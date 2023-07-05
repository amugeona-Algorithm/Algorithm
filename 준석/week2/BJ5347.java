package 준석.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

//https://www.acmicpc.net/problem/5347
public class BJ5347 {

    public static void main(String[] args) throws IOException {
        int N;
        long A, B;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> resultList = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            A = Long.parseLong(data.split(" ")[0]);
            B = Long.parseLong(data.split(" ")[1]);
            long minimum;
            if (A > B) {
                minimum = play(A, B);
            } else {
                minimum = play(B, A);
            }
            resultList.add(A * B / minimum);
        }
        for (Long aLong : resultList) {
            System.out.println(aLong);
        }
        br.close();
    }

    static long play(long a, long b) {
        while (b != 0) { //24 18
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
