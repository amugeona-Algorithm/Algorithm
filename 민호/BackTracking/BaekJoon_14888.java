package 민호.BackTracking;

import java.util.*;
import java.io.*;

public class BaekJoon_14888 {
    /**
     * 백준 14888
     * 백트래킹 - 연산자 끼워넣기
     * Sliver 1
     */

    static int N;
    static int[] numArray;              // 수열
    static int[] operatorArray;         // 연산자 조합 배열
    static int[] operator = new int[4]; // 각 연산자 갯수
    static int resultMax = Integer.MIN_VALUE;
    static int resultMin = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        numArray = new int[N];
        operatorArray = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }


        makeComb(0);
        System.out.println(resultMax);
        System.out.println(resultMin);

    }

    static void makeComb(int count) {
        if (count == N - 1) {
            int result = numArray[0];

            for (int i = 0; i < N - 1; i++) {
                if (operatorArray[i] == 0)
                    result = result + numArray[i + 1];
                else if (operatorArray[i] == 1)
                    result = result - numArray[i + 1];
                else if (operatorArray[i] == 2)
                    result = result * numArray[i + 1];
                else
                    result = result / numArray[i + 1];
            }

            resultMax = Math.max(resultMax, result);
            resultMin = Math.min(resultMin, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i] = operator[i] - 1;  //사용한 연산자 갯수 1개 감소 시키기
                operatorArray[count] = i;       //연산자 조합 배열에 연산자 저장
                makeComb(count + 1);
                operator[i] = operator[i] + 1;
            }
        }

    }
}
