package 민호.BackTracking;

import java.util.*;
import java.io.*;

public class BaekJoon_15663 {
    /**
     * 백준 15663
     * 백트래킹 - N과 M(9)
     * Sliver 2
     */

    static int N, M;
    static int[] array;
    static int[] result;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N];
        result = new int[M];
        visit = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        dfs(0);
    }

    static void dfs(int count) {
        if (count == M) {
            for (int value : result) {
                System.out.print(value + " ");
            }
            System.out.println();
            return;
        }

        int check = 0; //이전에 뽑은 값
        for (int i = 0; i < N; i++) {
            if (visit[i] != 1 && array[i] != check) { //방문하지 않고, 이전에 넣지 않은 값인 경우
                visit[i] = 1;
                check = array[i];
                result[count] = array[i];
                dfs(count + 1);
                visit[i] = 0;
            }

        }

    }

}
