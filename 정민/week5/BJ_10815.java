package 정민.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_10815 {
    /*
     * 백준 10815
     * 숫자 카드
     * silver 5
     * 이분탐색 풀이
     */
    static int N, M; // 상근이가 가진 카드 수, 확인해야할 카드 수

    static ArrayList<Integer> card;
    static int start, end, middle;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        card = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            card.add(temp);
        }

        Collections.sort(card);

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (hasCard(temp))
                sb.append("1 ");
            else
                sb.append("0 ");
        }

        System.out.println(sb);

    }

    public static boolean hasCard(int n) {
        start = 0;
        end = card.size() - 1;

        while (start <= end) {
            middle = (start + end) / 2;
            int temp = card.get(middle);

            if (temp > n) {
                end = middle - 1;
            } else if (temp < n) {
                start = middle + 1;
            } else
                return true;
        }

        return false;
    }
}
