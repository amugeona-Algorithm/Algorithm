package backjoon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class back_1158 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] argss = new String[2];
        argss[0] = scanner.next();
        argss[1] = scanner.next();

        int n = Integer.parseInt(argss[0]);
        int k = Integer.parseInt(argss[1]);

        Queue<Integer> objects = new LinkedList<>();

        IntStream.rangeClosed(1, n).forEach(objects::add);
        System.out.printf("<");
        List<Integer> result = new ArrayList<>();
        while (objects.size() > 0) {
            for (int i = 1; i < k; i++) {
                Integer poll = objects.poll();
                objects.add(poll);
            }
            result.add(objects.poll());
        }

        String collect = result.stream()
                .map(num -> String.valueOf(num))
                .collect(Collectors.joining(", "));

        System.out.printf(collect + ">");
    }

}
