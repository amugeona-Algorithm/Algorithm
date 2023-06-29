import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());
        LinkedList<Integer> persons = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            persons.add(i);
        }

        StringJoiner sj = new StringJoiner(", ", "<", ">");
        while (!persons.isEmpty()) {
            for (int i = 1; i <= k - 1; i++) {
                persons.offer(persons.poll());
            }
            sj.add(String.valueOf(persons.poll()));
        }
        System.out.println(sj);
    }
}
