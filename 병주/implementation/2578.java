//package hello;
//
//import java.util.*;
//
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[][] numbers = new int[5][5];
//        for (int i = 0; i < 5; i++) {
//            String[] inputs = scanner.nextLine().split(" ");
//            for (int j = 0; j < 5; j++) {
//                numbers[i][j] = Integer.parseInt(inputs[j]);
//            }
//        }
//
//        List<Integer> answers = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            String[] inputs = scanner.nextLine().split(" ");
//            for (String input : inputs) {
//                answers.add(Integer.parseInt(input));
//            }
//        }
//        for (int answer : answers) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    if (numbers[i][j] == answer) {
//                        numbers[i][j] = 0;
//                    }
//                }
//            }
//            if (count(numbers) >= 3) {
//                System.out.println(answers.indexOf(answer) + 1);
//                return;
//            }
//        }
//    }
//
//    private static int count(int[][] numbers) {
//        return countRow(numbers) + countColumn(numbers) + countX(numbers);
//    }
//
//    private static int countRow(int[][] numbers) {
//        int count = 0;
//        for (int i = 0; i < 5; i++) {
//            int a = 0;
//            for (int j = 0; j < 5; j++) {
//                if (numbers[i][j] == 0) {
//                    a++;
//                }
//            }
//            if (a == 5) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private static int countColumn(int[][] numbers) {
//        int count = 0;
//        for (int i = 0; i < 5; i++) {
//            int a = 0;
//            for (int j = 0; j < 5; j++) {
//                if (numbers[j][i] == 0) {
//                    a++;
//                }
//            }
//            if (a == 5) {
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private static int countX(int[][] numbers) {
//        int count = 0;
//        int left = 0;
//        int right = 0;
//        for (int i = 0; i < 5; i++) {
//            if (numbers[i][i] == 0) {
//                left++;
//            }
//            if (numbers[i][4 - i] == 0) {
//                right++;
//            }
//        }
//        if (left == 5) {
//            count++;
//        }
//        if(right == 5) {
//            count++;
//        }
//        return count;
//    }
//}
//
