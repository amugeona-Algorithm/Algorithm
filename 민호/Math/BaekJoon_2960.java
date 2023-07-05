package 민호.Math;

import java.util.*;
import java.io.*;

public class BaekJoon_2960 {
    /**
     * 백준_2960
     * 수학 에라토스테네스 문제
     * 다른 방법 찾아서 다시 풀어보기
     */

    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int deleteCount = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            list.add(i);
        }

        Collections.sort(list);

        for (int l : list) {
            setPrime(l, primeList);
        }

        Collections.sort(primeList);

        for (int i = 0; i < primeList.size(); i++) {
            int prime = primeList.get(i);

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) != 0) {
                    if (list.get(j) % prime == 0) {
                        deleteCount++;
                        if (deleteCount == K)
                            System.out.println(list.get(j));
                        list.set(j, 0);
                    }
                }
            }
        }


    }

    public static void setPrime(int num, ArrayList<Integer> primeList) {
        int count;

        if (num == 2) {
            primeList.add(num);
        } else {
            count = 0;
            for (int i = 2; i < num; i++) {
                if (num % i == 0)
                    count++;
            }
            if (count == 0)
                primeList.add(num);
        }
    }
}
