package 준석.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/2960
public class BJ2960 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String value = br.readLine();
        N = Integer.parseInt(value.split(" ")[0]);
        K = Integer.parseInt(value.split(" ")[1]);

        int count = 0; // 카운트
        List<Integer> valueList = new ArrayList<>();
        List<Integer> removedValueList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            valueList.add(i);
        }
        List<Integer> remainList;
        while (count < K) {
            for (int i = 0; i < valueList.size(); i++) {
                if (valueList.get(i) % valueList.get(0) == 0) {
                    removedValueList.add(valueList.get(i));
                    count++;
                }
            }
            remainList = valueList.stream().filter(x -> !removedValueList.contains(x)).collect(Collectors.toList());
            valueList = remainList;

        }
        System.out.println(removedValueList.get(K - 1));
    }
}
