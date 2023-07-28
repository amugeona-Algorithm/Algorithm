package 민호.BruteForce;

import java.util.*;
import java.io.*;

public class BaekJoon_1969 {
    /**
     * 백준 1969
     * 완전탐색 - DNA
     * Silver 4
     * 해결 X, 가능한 DNA가 여러 개 있을때 사전순으로 출력하는 것 해결하기
     */

    static int N, M;
    static char dna[][];
    static int resultCount;
    static StringBuilder result = new StringBuilder();
    //static ArrayList<Character> list[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dna = new char[N][M];
        /*list = new ArrayList[M];

        for(int i=0; i<M; i++){
            list[i] = new ArrayList<>();
        }*/

        for(int i=0; i<N; i++){
            char tmp[] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                dna[i][j] = tmp[j];
            }
        }

        for(int i=0; i<M; i++){
            getHammingDistance(i);
        }

        for(int i=0; i<M; i++){
            getDiffCount(i);
        }

        System.out.println(result);
        System.out.println(resultCount);
    }

    static void getDiffCount(int idx){
        for(int i=0; i<N; i++){
            if(dna[i][idx] != result.charAt(idx))
                resultCount++;
        }
    }

    static void getHammingDistance(int idx){
        int countA = 0;
        int countT = 0;
        int countG = 0;
        int countC = 0;
        int max;

        for(int i=0; i<N; i++){
            if(dna[i][idx] == 'A')
                countA++;
            else if (dna[i][idx] == 'T')
                countT++;
            else if (dna[i][idx] == 'G')
                countG++;
            else if (dna[i][idx] == 'C')
                countC++;
        }

        max = Math.max(countA, Math.max(countT, Math.max(countG, countC)));

        if(countA == max)
            result.append('A');
        else if (countT == max)
            result.append('T');
        else if (countG == max)
            result.append('G');
        else if (countC == max)
            result.append('C');
    }
}
