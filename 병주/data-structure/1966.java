import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static class Number {
        int index;
        int value;

        public Number(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testcaseNumber = Integer.parseInt(scanner.nextLine());
        List<String> firstLines = new ArrayList<>();
        List<String> secondLines = new ArrayList<>();

        for (int i = 0; i < testcaseNumber; i++) {
            firstLines.add(scanner.nextLine());
            secondLines.add(scanner.nextLine());
        }

        for (int i = 0; i < testcaseNumber; i++) {
            handle(firstLines.get(i), secondLines.get(i));
        }
    }

    private static void handle(String firstLine, String secondLine) {
        int countOfNumbers = Integer.parseInt(firstLine.split(" ")[0]);
        int targetIndex = Integer.parseInt(firstLine.split(" ")[1]);
        String[] weigths = secondLine.split(" ");
        List<Number> originals = new ArrayList<>();
        for (int i = 0; i < countOfNumbers; i++) {
            originals.add(new Number(i, Integer.parseInt(weigths[i])));
        }
        List<Number> numbers = new ArrayList<>(originals);
        List<Number> result = new ArrayList<>();
        while (!numbers.isEmpty()) {
            Number number = numbers.get(0);
            boolean flag = false;
            for (int i = 1; i < numbers.size(); i++) {
                if (numbers.get(i).value > number.value) {
                    flag = true;
                    break;
                }
            }
            numbers.remove(0);
            if (flag) {
                numbers.add(number);
            } else {
                result.add(number);
            }
        }


        for (Number number : result) {
            if (number.index == targetIndex) {
                System.out.println(result.indexOf(number) + 1);
            }
        }
    }
}

