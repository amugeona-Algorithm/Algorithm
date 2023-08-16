package 민호.TwoPointers;

import java.util.*;
import java.io.*;

public class BaekJoon_3273 {
    /**
     * 백준 3273
     * 투포인터 - 두 수의 합
     * Sliver 3
     */

    static int N, X; //수열의 크기, 자연수 X
    static int[] array;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        array = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());

        Arrays.sort(array);

        int leftP = 0;
        int rightP = N - 1;

        while (leftP < rightP) {
            int sum = array[leftP] + array[rightP];
            if (sum == X) {   //서로 다른 양의 정수의 수열이기에 만족하는 한 쌍이 나오면 해당 숫자로 다시 만족 X -> leftP++, rightP--
                count++;
                leftP++;
                rightP--;
            } else if (sum > X) {
                rightP--;
            } else
                leftP++;
        }

        System.out.println(count);
        /*int sum = 0;
        for(int i=0; i<N-1; i++){
            sum = array[i] + array[i+1];
            for(int j=i; j<N-2; j++){
                sum = sum - array[j+1] + array[j+2];
                if(sum == X)
                    count++;
            }
        }*/
    }
}
