package 민호.DivideAndConquer;

import java.io.*;
import java.util.*;

public class BaekJoon_1074 {
    /**
     * 백준 1074
     * 분할과정복 - Z
     * Sliver 1
     */

    static int N, R, C;
    //static ArrayList<Integer>[] board;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        Z(0, 0, size);
    }

    static void Z(int sr, int sc, int size) {
        if (size > 2) {  //정사각형의 크기가 2가 될때까지 정사각형 나누기
            int halfSize = size / 2;
            Z(sr, sc, halfSize);    //1사분면
            Z(sr, sc + halfSize, halfSize);   //2사분면
            Z(sr + halfSize, sc, halfSize);   //3사분면
            Z(sr + halfSize, sc + halfSize, halfSize);  //4사분면
        } else {   //정사각형의 크기가 2가 되면 숫자 부여
            for (int i = sr; i < sr + size; i++) {
                for (int j = sc; j < sc + size; j++) {
                    count++;
                    if (i == R && j == C)
                        System.out.println(count - 1);
                }
            }
        }
    }
}
