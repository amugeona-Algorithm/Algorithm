package 민호.TwoPointers;

import java.util.*;
import java.io.*;

public class BaekJoon_21921 {
    /**
     * 백준 21921
     * 투포인터 - 블로그
     * Sliver 3
     */

    static int N, X; //시작 일수, 확인 일수
    static int[] visitNum;
    //static int startP, endP;
    static int count = 1;
    static int sum = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitNum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitNum[i] = Integer.parseInt(st.nextToken());
        }

        /*for (int i = 0; i <= N - X; i++) {
            int sum = 0;
            startP = i;
            endP = i + X - 1;
            for(int j=startP; j<=endP; j++){
                sum += visitNum[j];
            }

            if(max == sum)
                count++;
            else if (max < sum) {
                max = sum;
                count = 1;
            }
        }*/

        for (int i = 0; i < X; i++) {
            sum += visitNum[i];
        }

        max = sum;
        for (int i = X; i < N; i++) {
            sum += visitNum[i] - visitNum[i - X];
            if (sum == max)
                count++;
            if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        if (max > 0) {
            System.out.println(max);
            System.out.println(count);
        } else
            System.out.println("SAD");
    }
}
