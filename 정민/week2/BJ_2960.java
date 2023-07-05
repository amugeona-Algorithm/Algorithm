package 정민.week2;

import java.util.Scanner;

public class BJ_2960 {
    /*
     * 백준 2960
     * 에라토스테네스의 체
     * math
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        boolean[] prime = new boolean[n + 1];
        int check = 0;
        prime[0] = prime[1] = true;
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                continue;
            for (int j = i; j <= n; j += i) {
                if (!prime[j]) {

                    prime[j] = true;
                    check++;
                }
                if (check == k) {
                    System.out.println(j);
                    System.exit(0);
                }
            }
        }
    }

}
