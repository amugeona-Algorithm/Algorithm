package Algorithm.지환.backjoon.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Back_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner stringJoiner = new StringJoiner("\n");
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            long result = lcm(stringTokenizer.nextToken(), stringTokenizer.nextToken());
            stringJoiner.add(String.valueOf(result));
        }
        System.out.println(stringJoiner);
    }

    private static long lcm(String ast, String bst) {

        long a = Long.parseLong(ast);
        long b = Long.parseLong(bst);
        long gcd = gcd(a, b);

        return a * b / gcd;
    }

    private static long gcd(long a, long b) {

        if (a > b) {

        } else if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        } else if (a == b) {
            return a;
        }

        long tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
