package 지환.backjoon.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Back_2960 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> ks = new ArrayList<>();

        List<Integer> numbers = IntStream.rangeClosed(2, n).boxed().collect(Collectors.toList());

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j = j + i) {
                if (numbers.contains(j)) {
                    numbers.remove(Integer.valueOf(j));
                    ks.add(j);
                }
            }
        }

        System.out.print(ks.get(k - 1));
    }
}
