package 준석.week1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//https://www.acmicpc.net/problem/2075
public class BJ2075 {
    public void sortArray(Integer[] array) {
        Arrays.sort(array, Collections.reverseOrder());
    }

    public Integer[] makeArray(Scanner scanner, int size) {
        int arraySize = size * size;
        Integer[] array = new Integer[arraySize];

        for (int i = 0; i < size; i++) {
            array[i] = Integer.valueOf(splitInputNumber(scanner, size)[i]);
        }
        return array;
    }

    public String[] splitInputNumber(Scanner scanner, int size) {
        String[] array = new String[size];

        for (int i = 0; i < size; i++) {
            String stringValue = scanner.nextLine();
            array = stringValue.split(" ");
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber = scanner.nextInt();

        BJ2075 result = new BJ2075();
        Integer[] array = result.makeArray(scanner, inputNumber);

        result.sortArray(array);
        System.out.println(array[inputNumber - 1]);
    }

}
