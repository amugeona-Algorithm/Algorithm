package 지환.week.w8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back_21921 {

    /*
    백준 21921
    블로그
    실버 3
     */
    static int M;
    static int X;

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = array[0];
        X = array[1];

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;

        //초기 구간 합 구하기
        for (int i = 0; i < X; i++) {
            sum += numbers[i];
        }

        int max = sum;
        //처음 구간 카운트
        int count = 1;

        // 윈도우를 이동 할 시 추가할 다음 인덱스 값은 X 가 됨
        for (int i = X; i < numbers.length; i++) {
            //numbers[i - X] 는 기존 윈도우 맨 앞값을 의미, numbers[i]는 새로운 X를 의미
            sum = sum - numbers[i - X] + numbers[i];
            if (sum == max) {
                count++;
            } else if (sum > max) {
                max = sum;
                count = 1;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}

