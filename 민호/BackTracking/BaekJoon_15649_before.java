package 민호.BackTracking;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class BaekJoon_15649_before {
    /**
     * 백준 15649
     * 백트래킹 - N과 M(1)
     * Silver 3
     * 조합으로 해결 -> 시간 초과 -> Dfs로 풀어보기
     */

    static int N, M;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        BT(M, 0, 1);
    }

    static void BT(int num, int count, int start) {
        if (count == num) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i]);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            int tmp = i;
            if (!IntStream.of(result).anyMatch(x -> x == tmp)) {  //배열 전체를 순회하며 값이 존재하는지 찾는다 -> 시간 초과 원인?
                result[count] = i;
                BT(num, count + 1, start);
            }
            result[count] = 0;
        }
    }
}
