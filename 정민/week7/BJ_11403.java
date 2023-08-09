package 정민.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403 {
    /*
     * 백준 11403
     * 경로 찾기
     */
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /*
         * 플로이드 워셜
         * - 모든 정점에서 모든 정점으로의 최단 경로를 구하는 알고리즘
         * - 인접 행렬을 이용하여 최단 거리를 계산
         * - 모든 정점에서 모든 정점으로 가는 최소 비용을 계산하기 위해 모든 정점마다 순차적으로 갱신하며 진행
         * 
         */
        /*
         * 문제 : 주어진 가중치 없는 그래프에 따라 i에서 j로 가는 경로가 있는가?
         */

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][k] == 1 && arr[k][j] == 1)
                        arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
