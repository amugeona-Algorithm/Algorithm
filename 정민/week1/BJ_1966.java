package 정민.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1966 {
    /*
     * 백준 1966
     * 프린터 큐
     * silver 3
     */
    static int T, N, M; // testcase, 문서의 개수, 궁금한 문서
    static Queue<Integer> que;
    static ArrayList<Integer> importance;
    static StringBuilder sb;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            importance = new ArrayList<>(); // 우선순위 저장
            que = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                que.add(temp);
                importance.add(temp);
            }

            Collections.sort(importance, Collections.reverseOrder()); // 우선순위 정렬, 내림차순
            checkImportance(M); // 우선순위 찾기

        }
        System.out.println(sb);

    }

    public static void checkImportance(int m) {
        int cnt = 0; // 인쇄 번호

        while (true) {

            int highest = importance.get(0); // 가장 높은 우선순위
            int num = que.poll(); // 비교 숫자

            if (highest > num) {
                que.add(num); // 제일 뒤에 추가
                if (m == 0) {
                    m = que.size() - 1;
                    continue;
                }
            } else {
                importance.remove(0); // 제일 높은 우선순위 지우기
                cnt++;
                if (m == 0) {
                    sb.append(cnt + "\n");
                    break;
                }
            }

            m--; // 한칸씩 앞으로 떙기기

        }

    }
}
