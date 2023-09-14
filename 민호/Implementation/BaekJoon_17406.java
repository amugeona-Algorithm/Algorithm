package 민호.Implementation;

import java.util.*;
import java.io.*;

public class BaekJoon_17406 {
    /**
     * 백준 17406
     * 구현 - 배열 돌리기4
     * Gold4
     */

    static int N, M, K;
    static int[][] array;
    static int[][] spin;
    static int[] visit; //회전 연산 사용 여부
    static int[] comb;  //회전 연산 순서 조합
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        array = new int[N + 1][M + 1];
        spin = new int[K][3];
        comb = new int[K];
        visit = new int[K];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            spin[i][0] = Integer.parseInt(st.nextToken());
            spin[i][1] = Integer.parseInt(st.nextToken());
            spin[i][2] = Integer.parseInt(st.nextToken());
        }

        makeComb(0);
        System.out.println(result);

    }

    static void makeComb(int count) {
        if (count == K) {
            spinArray();
            return;
        }

        for (int i = 0; i < K; i++) {
            if (visit[i] != 1) {
                visit[i] = 1;
                comb[count] = i;
                makeComb(count + 1);
                visit[i] = 0;
            }
        }
    }

    static void spinArray() {
        int[][] tempArray = copyArray();

        for (int i = 0; i < K; i++) {
            int spinNum = comb[i];
            int R = spin[spinNum][0];
            int C = spin[spinNum][1];
            int S = spin[spinNum][2];

            for (int s = 1; s <= S; s++) {
                //윗줄 이동
                int tempTop = tempArray[R - s][C + s];
                for (int k = C + s; k > C - s; k--) {
                    tempArray[R - s][k] = tempArray[R - s][k - 1];  //tempArray[r-s][c-s]값은 아직 바뀌지 않음
                }

                //오른쪽 줄 이동
                int tempRight = tempArray[R+s][C+s];
                for(int k=R+s; k>R-s; k--){
                    tempArray[k][C+s] = tempArray[k-1][C+s];
                }
                tempArray[R-s+1][C+s] = tempTop;

                //아랫줄 이동
                int tempBot = tempArray[R+s][C-s];
                for(int k=C-s; k<C+s; k++){
                    tempArray[R+s][k] = tempArray[R+s][k+1];
                }
                tempArray[R+s][C+s-1] = tempRight;

                //왼쪽 줄 이동
                for(int k=R-s; k<R+s; k++){
                    tempArray[k][C-s] = tempArray[k+1][C-s];
                }
                tempArray[R+s-1][C-s] = tempBot;
            }
        }
        operation(tempArray);
    }

    static int[][] copyArray() {
        int[][] tempArray = new int[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                tempArray[i][j] = array[i][j];
            }
        }
        return tempArray;
    }


    static void operation(int[][] tempArray){
        int tempResult = Integer.MAX_VALUE;

        for(int i=1; i<N+1; i++){
            int sum = 0;
            for(int j=1; j<M+1; j++){
                sum += tempArray[i][j];
            }
            tempResult = Math.min(tempResult, sum);
        }
            result = Math.min(tempResult, result);
    }
}
