package 정민.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_14425 {
    /*
     * 백준 14425
     * 문자열 집합
     * silver 3
     */

    static int N, M, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map.put(i, s);
        }

        for (int j = 0; j < M; j++) {
            String check = br.readLine();
            if (map.containsValue(check))
                res++;
        }
        System.out.println(res);
    }
}
