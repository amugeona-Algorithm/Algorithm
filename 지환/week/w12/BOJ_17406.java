package 지환.week.w12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17406 {
    /*
    백준 17406
    배열돌리기
    골드4
     */

    private static int result = Integer.MAX_VALUE;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int[][] copyMap;
    private static StringTokenizer st;
    private static int N, M, K;
    private static Spin[] spins;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        copyMap = new int[N + 1][M + 1];
        spins = new Spin[K];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            spins[i] = new Spin(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        per(spins, 0, K, K);

        System.out.println(result);
    }

    static void per(Spin[] spinArr, int depth, int n, int r) {
        if (depth == r) {
            //카피맵
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    copyMap[i][j] = map[i][j];
                }
            }

            for (Spin spin : spinArr) {
                spin(spin);
            }
            int min = getMin();
            result = Math.min(min, result);
        }
        for (int i = depth; i < K; i++) {
            swap(spinArr, depth, i);
            per(spinArr, depth + 1, n, r);
            swap(spinArr, depth, i);
        }

    }

    static int getMin() {
        int sum = 0;
        int arrMin = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += copyMap[i][j];
            }
            arrMin = Math.min(sum, arrMin);
        }
        return arrMin;
    }

    static void swap(Spin[] spinArr, int depth, int i) {
        Spin temp = spinArr[depth];
        spinArr[depth] = spinArr[i];
        spinArr[i] = temp;
    }

    static void spin(Spin spin) {
        int r = spin.r;
        int c = spin.c;
        int s = spin.s;
        int startR = r - s;
        int startC = c - s;
        int endR = r + s;
        int endC = c + s;
        while (startR!=endR && startC!=endC) {
            //모서리 값 저장
            int temp1 = copyMap[startR][startC];
            int temp2 = copyMap[startR][endC];
            int temp3 = copyMap[endR][endC];
            int temp4 = copyMap[endR][startC];
            for (int i = endC; i >= startC; i--) {
                copyMap[startR][i] = copyMap[startR][i - 1];
            }
            for (int i = endR; i > startR; i--) {
                copyMap[i][endC] = copyMap[i - 1][endC];
            }
            for (int i = startC; i < endC - 1; i++) {
                copyMap[endR][i] = copyMap[endR][i + 1];
            }

            for (int i = startR; i < endR - 1; i++) {
                copyMap[i][startC] = copyMap[i + 1][startC];
            }
            copyMap[startR][startC + 1] = temp1;
            copyMap[startR + 1][endC] = temp2;
            copyMap[endR][endC - 1] = temp3;
            copyMap[endR-1][startC] = temp4;

            startR++;
            startC++;
            endR--;
            endC--;
        }
    }

    static class Spin {
        int r;
        int c;
        int s;

        public Spin(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

}
