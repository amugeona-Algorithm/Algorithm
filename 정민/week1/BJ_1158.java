package 정민.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1158 {
    /*
     * 백준 1158
     * 요세푸스 문제
     * silver 4
     */

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> circle = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            circle.add(i);
        }

        int start = 0;

        while (!circle.isEmpty()) {
            int idx = (start + (K - 1)) % circle.size();
            int now = circle.get(idx);

            circle.remove(idx); // 해당 번호 지우기
            start = idx;

            if (circle.isEmpty()) {
                sb.append(now + ">");
                break;
            } else {
                sb.append(now + ", ");
            }

        }

        System.out.println(sb);
    }
}
