package 준석.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.acmicpc.net/problem/1966
public class BJ14425 {
    public List<String> addCollection(Scanner scanner, int number) {
        List<String> collection = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            collection.add(scanner.nextLine());
        }
        return collection;
    }

    public long countIncludedWords(List<String> collectionA, List<String> collectionB) {
        return collectionB.stream()
                .filter(word -> collectionA.contains(word))
                .count();
    }

    public static void main(String[] args) {
        BJ14425 collection = new BJ14425();

        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        String[] array = number.split(" ");
        System.out.println(collection.countIncludedWords(collection.addCollection(scanner, Integer.parseInt(array[0])), collection.addCollection(scanner, Integer.parseInt(array[1]))));
    }

}
