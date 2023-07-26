package 정민.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1182 {
    /*
     * 백준 1182
     * 부분수열의 합
     */
    static int n, s, input[], res;
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken(" "));
        s = Integer.parseInt(st.nextToken(" "));

        input = new int[n];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken(" "));
        }

        subset(0);
        System.out.println(res);

    }

    public static void subset(int cnt) {
        if (cnt == n) {
            int sum = 0;
            int use = 0;
            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    sum += input[i];
                    use++;
                }
            }
            if (sum == s && use != 0)
                res++; // 경우의 수 세기
            return;
        }

        check[cnt] = true;
        subset(cnt + 1);
        check[cnt] = false;
        subset(cnt + 1);
    }
}
