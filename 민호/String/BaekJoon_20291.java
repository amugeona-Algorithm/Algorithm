package 민호.String;

import java.util.*;
import java.io.*;

public class BaekJoon_20291 {
    /**
     * 백준 20291
     * 문자열 - 파일 정리
     * Sliver 3
     */

    static int N; //파일 개수
    static Map<String, Integer> map = new TreeMap<>();  //입력된 Key가 오름차순으로 출력되는 특징 - TreeMap

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String string = st.nextToken();

            int pointIndex = string.indexOf(".");
            String extension = string.substring(pointIndex + 1);

            if (map.containsKey(extension)) {
                int value = map.get(extension);
                map.replace(extension, value + 1);
            } else {
                map.put(extension, 1);
            }
        }

        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
