package 민호.BinarySearch;

import java.util.*;
import java.io.*;

public class BaekJoon_10815 {
    /**
     * 백준 10815
     * 이분탐색 - 숫자 카드
     * Sliver 5
     */

    static int N;   //숫자 카드 개수
    static int M;   //비교 숫자 개수
    static int[] havingList;    //이진 탐색 배열은 오름차순 정렬!!
    static int[] searchList;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        havingList = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            havingList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(havingList); //오름차순 정렬

        M = Integer.parseInt(br.readLine());
        searchList = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            searchList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            BS(0, N - 1, i);  //재귀함수 이진탐색
        }

        System.out.println(sb);
    }

    static void BS(int start, int end, int searchIndex) {
        int mid = (start + end) / 2;
        int searchValue = searchList[searchIndex];

        if (start > end) {
            sb.append(0).append(" ");
            return;
        }

        if (havingList[mid] == searchValue) {
            sb.append(1).append(" ");
            return;
        } else if (havingList[mid] < searchValue) {
            BS(mid + 1, end, searchIndex);
        } else if (havingList[mid] > searchValue) {
            BS(0, mid - 1, searchIndex);
        }
    }
}
