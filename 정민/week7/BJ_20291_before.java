package 정민.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BJ_20291_before {
    /*
     * 백준 20291
     * 파일 정리
     * before
     */
    static int N; // 파일의 개수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            // String name = br.readLine().split(".");
            String[] temp = br.readLine().split("\\.");
            if (map.containsKey(temp[1]))
                map.put(temp[1], map.get(temp[1]) + 1);
            else
                map.put(temp[1], 1);
        }

        // hashmap key 기준으로 정렬하는 방법
        // ** map의 keySet을 이용하여 정렬
        // Collection.sort()

        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        // 출력!
        for (String key : keySet) {
            System.out.println(key + " " + map.get(key));
        }

    }
}
