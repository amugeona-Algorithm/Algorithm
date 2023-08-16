package 정민.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BJ_20291 {
    /*
     * 백준 20291
     * 파일 정리
     * 문자열
     */

    static int N;
    static HashMap<String, Integer> file;
    static ArrayList<String> list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        file = new HashMap<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] name = br.readLine().split("\\."); // escape 문자 활용, "."은 정규식에서 모든 문자와 매칭되는 특별한 의미의 문자이기 때문

            if (file.containsKey(name[1])) {
                file.put(name[1], file.get(name[1]) + 1);
            } else {
                file.put(name[1], 1);
                list.add(name[1]);
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + file.get(list.get(i)));
        }

    }
}