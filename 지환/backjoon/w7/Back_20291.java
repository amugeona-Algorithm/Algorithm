package 지환.backjoon.w7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back_20291 {
    /*
    백준 20291
    파일 정리
    실버 3
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static StringBuffer sb = new StringBuffer();
    private static StringTokenizer st;

    private static Map<String, Integer> map = new LinkedHashMap<>();

    private static int T;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split("\\.");
            String s =  split[1];

            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.naturalOrder());

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + map.get(list.get(i)));
        }
    }
}

