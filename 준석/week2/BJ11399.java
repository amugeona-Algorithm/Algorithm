package 준석.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/11399
public class BJ11399 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        String time = br.readLine();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(time.split(" ")[i]));
        }
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());

        int sum = 0;
        for (int j = 0; j < sortedList.size(); j++) {
            sum += sortedList.get(j) * (sortedList.size() - j);
        }
        System.out.println(sum);
    }
}
