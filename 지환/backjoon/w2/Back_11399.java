package Algorithm.지환.backjoon.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Back_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> numbers = new ArrayList<>();
        StringTokenizer input = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(input.nextToken()));
        }
        Collections.sort(numbers);
        int tmp = 0;
        int result = 0;
        for (int number : numbers) {
            tmp = tmp + number;
            result = tmp + result;
        }
        System.out.print(result);
    }
}
