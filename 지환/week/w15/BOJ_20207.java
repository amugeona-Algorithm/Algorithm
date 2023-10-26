package 지환.week.w15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20207 {
    /*
    BOJ 20207
    달력

     */

    private static int[] counts = new int[367];

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static int n;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            inputScheduleCount();
        }

        int w = 0;
        int h = 0;
        int result = 0;
        for (int i = 1; i <= 366; i++) {
            if (counts[i] > 0) {
                w++;
                h = Math.max(counts[i], h);
            } else {
                result += w * h;
                w =0;
                h = 0;
            }
        }
        System.out.println(result);


    }

    private static void inputScheduleCount() throws IOException {
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        for (int i = start; i <= end; i++) {
            counts[i] = counts[i] + 1;
        }
    }
}
