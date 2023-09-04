package 지환.backjoon.w5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1920 {
    static int[] a ;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            sb.append(biSearch(Integer.parseInt(st1.nextToken()), n)).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static int biSearch(int target, int n) {
        int st = 0;
        int en = n - 1;

        while (st <= en) {
            int mid = (st + en) / 2;
            if (a[mid] < target) {
                st = mid + 1;
            } else if (a[mid] > target) {
                en = mid - 1;
            } else
                return 1;
        }
        return 0;
    }
}
