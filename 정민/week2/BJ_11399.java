package 정민.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {
    /*
     * 백준 11399
     * ATM
     */
    static int res, N, before;
    static int time[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        time = new int[N];
        res = 0;
        before = 0;
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        for (int i = 0; i < N; i++) {
            res += time[i] + before;
            before += time[i];
        }
        System.out.println(res);
    }
}
