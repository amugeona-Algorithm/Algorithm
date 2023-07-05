package 민호.Greedy;

import java.util.*;
import java.io.*;

public class BaekJoon_11399 {
    /**
     * 백준_1931
     * Greedy ATM 문제
     */

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ArrayList<Integer> pArray = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            pArray.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(pArray);
        int result = 0;

        for (int j = 0; j < pArray.size(); j++) {
            for(int k=0; k<=j; k++){
                result += pArray.get(k);
            }
        }

        System.out.println(result);
    }
}
