package hello;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> result = new ArrayList<>();
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            long firstNumber = Long.parseLong(input.split(" ")[0]);
            long secondNumber = Long.parseLong(input.split(" ")[1]);
            long minDiv = minDiv(firstNumber, secondNumber);
            result.add((firstNumber * secondNumber) / minDiv);
        }
        result.forEach(System.out::println);
        scanner.close();
    }

    private static long minDiv(long a, long b) {
        if (b == 0) {
            return a;
        }
        return minDiv(b, a % b);
    }
}



