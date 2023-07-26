package 민호.BinarySearch;

import java.util.*;
import java.io.*;

public class BaekJoon_2805_before {
    /**
     * 백준 2805
     * 이분탐색 - 나무 자르기
     * Sliver 2
     */

    static int N, M;    //나무 수, 가져가는 나무 길이
    static int[] tree;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new ArrayList<>();

        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);  //배열 오름차순 정렬

        for (int i = tree[0]; i <= tree[N - 1]; i++) {
            BS(0, N - 1, i);
        }

        System.out.println(Collections.max(result));

    }

    static void BS(int start, int end, int searchValue) {
        int mid = (start + end) / 2;
        long sum = 0;

        if (searchValue == tree[mid]) {
            for (int i = mid; i <= end; i++)
                sum += tree[i] - searchValue;

            if (sum == M)
                result.add(searchValue);
            return;
        } else if (searchValue > tree[mid]) {
            if (searchValue >= tree[mid + 1])
                BS(mid + 1, end, searchValue);
            else {
                for (int i = mid + 1; i <= end; i++)
                    sum += tree[i] - searchValue;

                if (sum == M)
                    result.add(searchValue);
                return;
            }
        } else if (searchValue < tree[mid]) {
            if (searchValue <= tree[mid - 1])
                BS(start, mid - 1, searchValue);
            else {
                for (int i = mid; i <= end; i++)
                    sum += tree[i] - searchValue;

                if (sum == M)
                    result.add(searchValue);
                return;
            }
        }
    }
}