package 정민.week2;

import java.util.Scanner;

public class BJ_5347 {
    /*
     * 백준 5347
     * LCM
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {

            long a = sc.nextLong();
            long b = sc.nextLong();
            // 유클리드 호제법 : 2개의 자연수 또는 정식의 최대 공약수를 구하는 알고리즘
            // 호제법 : 두수가 서로 상대방의 수를 나누어서 원하는 수를 얻는 알고리즘
            long GCD = gcd(Math.max(a, b), Math.min(a, b)); // 최대 공약수
            long lcm = a * b / GCD; // 최소 공배수

            System.out.println(lcm);
        }
    }

    private static long gcd(long a, long b) {
        // a가 큰수, b가 작은수
        // gcd : 최대 공약수, lcm : 최소 공배수
        /*
         * gcd 공식
         * 두 수를 공약수로 계속 나누고 공약수를 나눈 몫
         */

        while (b != 0) {
            long r = a % b; // 나머지
            // a와 b의 최대 공약수는 b와 r의 최대 공약수와 같다
            // 나머지가 0이 되었을때 나누는 수가 최대 공약수
            a = b;
            b = r;
        }
        return a;
    }
}
