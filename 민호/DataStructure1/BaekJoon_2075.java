package 민호.DataStructure1;

import java.io.*;
import java.util.*;

public class BaekJoon_2075 {
    /*
    * 시간 복잡도
    * Scanner 대신 BufferedReader, StringTokenizer 사용
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> sortList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sortList.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(sortList, Collections.reverseOrder());
        System.out.println(sortList.get(n - 1));
    }
}
