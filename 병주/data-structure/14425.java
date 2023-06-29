import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int m = Integer.parseInt(input.split(" ")[1]);

        Set<String> a = new HashSet<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextLine());
        }
        List<String> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(scanner.nextLine());
        }
        int before = b.size();
        b.removeAll(a);
        int after = b.size();
        System.out.println(before - after);
    }
}

