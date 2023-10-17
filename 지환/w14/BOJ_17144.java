package 지환.w14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144 {
      /*
    백준 17144
    미세먼지야 안녕!
    골드 4
    */

    private static int[][] A;
    private static int[][] A_c;
    private static int R;
    private static int C;
    private static int T;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        A = new int[R][C];
        int top = 0;
        int buttom = 0;
        boolean firstFlag = false;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == -1 && firstFlag) {
                    buttom = i;
                }
                if (temp == -1 && !firstFlag) {
                    top = i;
                    firstFlag = true;
                }
                A[i][j] = temp;
            }
        }

        for (int i = 0; i < T; i++) {
            diffusion();
            clean(top, buttom);
        }

        int result = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] != -1) {
                    result += A[i][j];
                }
            }
        }
        System.out.println(result);

    }

    static void clean(int top, int bottom) {
        //공기 청전기 기준 아래로 부는 바람
        for (int i = top - 1; i > 0; i--) {
            A[i][0] = A[i - 1][0];
        }
        // 왼쪽으로 부는 바람
        for (int i = 0; i < C - 1; i++) {
            A[0][i] = A[0][i + 1];
        }
        //위로
        for (int i = 0; i < top; i++) {
            A[i][C - 1] = A[i + 1][C - 1];
        }
        //오른쪽
        for (int i = C - 1; i > 1; i--) {
            A[top][i] = A[top][i - 1];
        }
        // 공기청정기 바로 앞칸은 깨끗한 공기라 0
        A[top][1] = 0;


        // 아래 쪽 공기 청정기
        //위로
        for (int i = bottom + 1; i < R - 1; i++) {
            A[i][0] = A[i + 1][0];
        }
        //왼쪽
        for (int i = 0; i < C - 1; i++) {
            A[R - 1][i] = A[R - 1][i + 1];
        }
//아래
        for (int i = R - 1; i > bottom; i--) {
            A[i][C - 1] = A[i - 1][C - 1];
        }

        for (int i = C - 1; i > 1; i--) {
            A[bottom][i] = A[bottom][i - 1];
        }
        A[bottom][1] = 0;

    }


    static void diffusion() {
        //복사
        A_c = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A_c[i][j] = A[i][j];
            }
        }

        int r = 0;
        int c = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                r = i;
                c = j;

                int diffusionAmount = A[r][c] / 5;
                int diffusionCount = 0;

                int[] dr = {-1, 1, 0, 0};
                int[] dc = {0, 0, -1, 1};

                for (int dir = 0; dir < 4; dir++) {
                    int nr = dr[dir] + r;
                    int nc = dc[dir] + c;
                    if (nr >= 0 && nc >= 0 && nr < R && nc < C && A[nr][nc] != -1) {
                        A_c[nr][nc] += diffusionAmount;
                        diffusionCount++;
                    }
                }
                A_c[r][c] -= diffusionCount * diffusionAmount;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                A[i][j] = A_c[i][j];
            }
        }
    }

}
