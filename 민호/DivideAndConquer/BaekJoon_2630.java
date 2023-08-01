package 민호.DivideAndConquer;

import java.io.*;
import java.util.*;

public class BaekJoon_2630 {
    /**
     * 백준 2630
     * 분할과정복 - 색종이 만들기
     * Sliver 2
     */

    static int N;
    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DAC(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void DAC(int sr, int sc, int size) {
        int first = paper[sr][sc];  //탐색할 정사각형의 왼측상단(탐색 시작점)의 색

        if(check(sr,sc,size)){  //탐색한 정사각형의 색이 모두 동일한 경우
            if(first == 0)
                white++;
            else if (first == 1) {
                blue++;
            }
            return;
        }

        //탐색한 정사각형의 색이 모두 동일하지 않은 경우 -> 나누어진 정사각형의 탐색 시작점이 모두 다르기에 1,2,3,4분면으로 나누어 탐색
        DAC(sr, sc, size/2); //1사분면
        DAC(sr, sc+size/2, size/2); //2사분면
        DAC(sr+size/2, sc, size/2); //3사분면
        DAC(sr+size/2, sc+size/2, size/2); //4사분면
    }

    static boolean check(int sr, int sc, int size){
        int first = paper[sr][sc];

        for(int i=sr; i<sr+size; i++){
            for(int j=sc; j<sc+size; j++){
                if(paper[i][j] != first)
                    return false;
            }
        }
        return true;
    }
}
