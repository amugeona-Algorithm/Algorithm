package 지환.backjoon.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Back_2075 {
    public static void main(String[] args) throws IOException {
        List<List<Integer>> ns = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            List<Integer> oneLine = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            ns.add(oneLine);
        }
        List<Integer> allNumber = new ArrayList<>();
        //평탄화
        ns.forEach(allNumber::addAll);
        //정렬
        allNumber.sort(Comparator.naturalOrder());
        System.out.println(allNumber.get((number * number) - number));
    }
}
