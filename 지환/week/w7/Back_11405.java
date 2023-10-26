package 지환.week.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back_11405 {
    /*
    백준 11405
    경로 찾기
    실버 1
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuffer sb = new StringBuffer();
    private static StringTokenizer st;

    private static int[][] graph;

    private static int N;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] == 1 & graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf(graph[i][j] + " ");
            }
            System.out.println();
        }



    }
}

