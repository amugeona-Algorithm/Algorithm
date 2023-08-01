package 준석.준석.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1182 {
    static int N;
    static int S;
    static int[] array;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        N = Integer.parseInt(data.split(" ")[0]);
        S = Integer.parseInt(data.split(" ")[1]);

        String value = br.readLine();
        String[] valueArray = value.split(" ");

        List<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            valueList.add(Integer.parseInt(valueArray[i]));
        }

        array = new int[N];


        dfs(0, 0);

        System.out.println(count);
    }

    static void dfs(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }
        sum += array[index];

        dfs(index + 1, sum+array[index]);

        dfs(index + 1, sum);
    }
}