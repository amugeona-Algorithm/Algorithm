package 준석.week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15663 {
    static int N;
    static int M;

    static boolean[] visited;
    static int[] array;
    static int[] value;

    //linkedHashSet -> 입력순으로 정렬됨
    static LinkedHashSet<String> set;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        N = Integer.parseInt(data.split(" ")[0]);
        M = Integer.parseInt(data.split(" ")[1]);

        set = new LinkedHashSet<>();
        array = new int[N];
        data = br.readLine();
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(data.split(" ")[i]);
        }
        value = new int[M];
        Arrays.sort(array);
        visited = new boolean[N];
        play(N, M, 0);

        for(String s: set){
            System.out.println(s);
        }
    }

    static void play(int n, int m, int index) {
        if (index == M) {
            sb= new StringBuilder();
            for (int i : value) {
                sb.append(i).append(' ');
            }
            set.add(sb.toString());
            return;
        }
        /*
        방문처리 안된경우 -> 방문처리 -> value에 값을 넣고 재귀 -> 방문처리된걸로 -> 그다음 i값
         */
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                value[index] = array[i];
                play(N, M, index + 1);
                visited[i] = false;

            }
        }
    }
}
