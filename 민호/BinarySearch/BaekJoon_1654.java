package 민호.BinarySearch;

import java.util.*;
import java.io.*;

public class BaekJoon_1654 {
    /**
     * 백준 1654
     * 이분탐색 - 랜선 자르기
     * Sliver 2
     */

    static int K, N; //랜선의 개수, 필요한 랜선의 개수
    static ArrayList<Long> line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        line = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            line.add(Long.parseLong(st.nextToken()));
        }

        long start = 1;
        long end = Collections.max(line);

        long result = BS(start, end);
        System.out.println(result);
    }

    static long BS(long start, long end) {
        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (long height : line) {
                count += height / mid;
            }

            if (count < N)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return (start + end) / 2;
    }
}
