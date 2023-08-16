package 민호.TwoPointers;

import java.util.*;
import java.io.*;

public class BaekJoon_2428 {
    /**
     * 백준 2428
     * 투포인터 - 표절
     * Sliver 3
     */

    static int N; //솔루션 개수
    static int[] fileSize;
    static long count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        fileSize = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fileSize[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(fileSize);

        int leftP = 0;
        int rightP = 0;

        while (leftP < N) {
            while (true) {
                if (rightP >= N - 1) //rightPoint가 배열 오른쪽 끝이라면 배열의 모든 쌍이 조건 만족으로 break;
                    break;

                int leftValue = fileSize[leftP];
                int rightValue = fileSize[rightP + 1];
                if (leftValue < 0.9 * rightValue)
                    break;
                else
                    rightP++;
            }
            count += rightP - leftP;
            leftP++;
        }
        System.out.println(count);


       /*for(int i=0; i<N; i++){
            int leftP = i, rightP = N - 1;
            while (leftP < rightP) {
                if(fileSize[leftP] >= 0.9 * fileSize[rightP]){
                    count++;
                    rightP--;
                }
                else
                    rightP--;
            }
        }*/
    }
}
