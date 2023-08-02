package 민호.DivideAndConquer;

import java.util.*;
import java.io.*;

public class BaekJoon_1992 {
    /**
     * 백준 1992
     * 분할과정복 - 쿼드트리
     * Silver 1
     */

    static int N;
    static int[][] array;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                array[i][j] = str.charAt(j) - '0';
            }
        }

        quadTree(0, 0, N);
        System.out.println(sb);

    }

    static void quadTree(int sr, int sc, int size) {
        int first = array[sr][sc];
        if (check(first, sr, sc, size)) { //N*N 배열의 값이 모두 동일한 경우
            if (first == 1)
                sb.append("1");
            else if (first == 0)
                sb.append("0");
        }
        else {
            sb.append("("); //N*N 배열의 값이 모두 동일하지 않아 N/2 크기로 나눌때 () 추가
            int halfSize = size / 2;
            quadTree(sr, sc, halfSize);
            quadTree(sr, sc + halfSize, halfSize);
            quadTree(sr + halfSize, sc, halfSize);
            quadTree(sr + halfSize, sc + halfSize, halfSize);
            sb.append(")");
        }


    }

    static boolean check(int first, int sr, int sc, int size) {
        for (int i = sr; i < sr + size; i++) {
            for (int j = sc; j < sc + size; j++) {
                if (array[i][j] != first)
                    return false;
            }
        }
        return true;
    }
}
