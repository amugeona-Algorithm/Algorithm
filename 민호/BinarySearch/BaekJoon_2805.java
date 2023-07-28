package 민호.BinarySearch;

import java.util.*;
import java.io.*;

public class BaekJoon_2805 {
    /**
     * 백준 2805
     * 이분탐색 - 나무 자르기
     * Sliver 2
     */

    static int N, M;    //나무 수, 가져가는 나무 길이
    static ArrayList<Integer> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree.add(Integer.parseInt(st.nextToken()));
        }

        int start = 0;
        int end = Collections.max(tree);

        int result = BS(start, end);

        System.out.println(result);

    }

    static int BS(int start, int end) {

        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for (int height : tree) {
                if (height > mid) {
                    sum += height - mid;
                }
            }

            if (sum >= M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}