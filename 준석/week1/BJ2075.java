package 준석.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/2075
public class BJ2075 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static List<Integer> splitInputNumber(int size) throws IOException {

        List<String> copyString = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Collections.addAll(copyString, br.readLine().split(" "));
        }
        return copyString.stream().map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {

        int size = Integer.parseInt(br.readLine());

        System.out.println(splitInputNumber(size).get(size - 1));
    }
}
