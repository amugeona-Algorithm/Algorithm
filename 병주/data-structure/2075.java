import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            List<Integer> num = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            numbers.addAll(num);
        }
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println(numbers.get(n - 1));
    }
}

