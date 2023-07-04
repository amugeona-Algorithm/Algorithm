package 준석.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/2075
public class BJ2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> copyString = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            Collections.addAll(copyString, br.readLine().split(" "));
        }
        List<Integer> a = copyString.stream()
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(a.get(size - 1));
    }
}
