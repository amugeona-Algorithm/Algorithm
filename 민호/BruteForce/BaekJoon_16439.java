package 민호.BruteForce;

import java.util.*;
import java.io.*;

public class BaekJoon_16439 {
    /**
     * 백준 16439
     * 완전탐색(재귀함수) - 치킨치킨치킨
     * Silver 4
     */

    static int N; //회원 수
    static int M; //치킨 종류의 수
    static int chicken[][]; //선호도 배열
    static int comb[]; //치킨 조합
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                chicken[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb = new int[3]; //해당 문제에서 치킨 종류는 3<=M<=30, 치킨 선택은 최대 3개로 가능한 조합은 치킨 3개
        makeComb(0,0);

        System.out.println(result);

    }

    static void makeComb(int count, int start){
        if(count == 3){
            int sum = 0;
            for(int i=0; i<N; i++){
                sum += getMax(i);
            }
            if(sum > result)
                result = sum;
            return;
        }

        for(int i=start; i<M; i++){
            comb[count] = i;
            makeComb(count+1, start+1);
        }
    }

    static int getMax(int memberIndex){
        int max = 0;
        for(int i=0; i<3; i++){
            int tmp = chicken[memberIndex][comb[i]];
            if(tmp > max)
                max = tmp;
        }
        return max;
    }
}
