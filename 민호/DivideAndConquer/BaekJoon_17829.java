package 민호.DivideAndConquer;

import java.util.*;
import java.io.*;

public class BaekJoon_17829 {
    /**
     * 백준 17829
     * 분할과정복 - 222풀링
     * Sliver 2
     */

    static int N;
    static ArrayList<Integer>[] arrayLists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrayLists[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        polling(N);
        System.out.println(arrayLists[0].get(0));
    }

    static void polling(int size) {
        if (size == 1) {
            return;
        }

        for (int sr = 0; sr < size; sr += 2) {
            for (int sc = 0; sc < size; sc += 2) {
                int tmp[] = {arrayLists[sr].get(sc), arrayLists[sr].get(sc + 1), arrayLists[sr + 1].get(sc), arrayLists[sr + 1].get(sc + 1)};
                Arrays.sort(tmp);
                arrayLists[sr / 2].set(sc / 2, tmp[2]);
            }
        }
        polling(size / 2);
    }
}
