package 준석.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ15649 {
    static int N;
    static int M;

    static int[] array;
    static boolean[] visit;

    // 3 1 -> 1 2 3  ,4 2 -> 1 2 ,1 3, 1 4, 2 1 2 3 2 4 3 1 3 2 3 4 4 1 4 2 4 3 4 4
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        N = Integer.parseInt(data.split(" ")[0]);
        M = Integer.parseInt(data.split(" ")[1]);

        array = new int[M];
        visit = new boolean[N+1];

        findAnswer(N,M,0);

    }

    static void findAnswer(int n, int m, int index){

        if(index == M){
            for(int i : array){
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<=N; i++){
            if(!visit[i]){
                visit[i] = true;
                array[index] = i;
                findAnswer(N, M, index+1);
                visit[i] = false;
            }
        }
    }
}
