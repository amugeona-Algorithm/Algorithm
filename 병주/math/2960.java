package hello;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int k = Integer.parseInt(input.split(" ")[1]);

        Set<Integer> numbers = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            int number = i;
            for (int j = number; j <= n; j += number) {
                numbers.add(j);
                if (numbers.size() == k) {
                    System.out.println(j);
                    break;
                }
            }
            if (numbers.size() == k) {
                break;
            }
        }
    }
}




