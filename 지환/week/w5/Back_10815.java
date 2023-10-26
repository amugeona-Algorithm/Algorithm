package 지환.week.w5;

import java.io.*;
import java.util.*;

public class Back_10815 {
    /*
    백준 10815
    숫자 카드
     */

    private static int N;
    private static int M;
    static int[] numbers;
    static int[] targets;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(numbers);

        M = Integer.parseInt(br.readLine());

        targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            sb.append(biSearch(targets[i])).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int biSearch(int target) {
        int st;
        int en;
        int mid;
        st = 0;
        en = N - 1;
        while (st <= en) {
            mid = (st + en) / 2;

            if (numbers[mid] < target) {
                st = mid + 1;
            } else if (numbers[mid] > target) {
                en = mid - 1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}

