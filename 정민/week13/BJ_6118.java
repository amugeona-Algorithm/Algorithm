package 정민.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6118 {
    /*
     * 백준 6118
     * 숨바꼭질
     * silver 1
     */
    static int N, M;
    static int[] dist;
    static int max, resId, cnt; // 최소값이 가장 작은
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        list = new ArrayList<>();
        resId = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>()); // 초기화
        }

        cnt = 1;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        findPath();

        System.out.println(resId + " " + max + " " + cnt);
    }

    public static void findPath() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1); // 1부터 시작

        while (!que.isEmpty()) {
            int n = que.poll();
            int size = list.get(n).size();

            for (int i = 0; i < size; i++) {
                int temp = list.get(n).get(i); // 방문 가능 숫자

                if (dist[temp] != 0 || temp == 1)
                    continue;

                dist[temp] = dist[n] + 1;
                que.add(temp);

                if (max < dist[temp]) {
                    max = dist[temp];
                    cnt = 1;
                    resId = temp;
                } else if (max == dist[temp]) {
                    if (resId > temp) {
                        resId = temp;
                    }
                    cnt++;
                }

            }
        }

    }
}
