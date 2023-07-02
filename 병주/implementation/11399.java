package hello;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> times = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += times.get(i) * (n - i);
        }
        System.out.println(sum);
    }
}




