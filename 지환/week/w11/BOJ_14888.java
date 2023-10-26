package 지환.week.w11;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14888 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] numbers;
    private static int[] symbols;

    static boolean[] isNumberUsed;
    static boolean[] isSymbolUsed;

    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;


    private static int N;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        symbols = new int[N - 1];

        isNumberUsed = new boolean[N];
        isSymbolUsed = new boolean[N - 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        symbols = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // 다음 숫자 인덱스인 1 부터 시작
        dfs(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int num, int numberIndex) {
        //모든숫자가 N 개면, 이미 N-1 시점에 모든 연산이 끝났기에 재귀 끝.
        if (numberIndex == N) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        //연산자 4개라 4번 반복
        for (int i = 0; i < 4; i++) {

            //해당하는 기회가 있으면
            if (symbols[i] > 0) {
                //감소
                symbols[i]--;
                //심볼의 연산을  찾고 각 연산 실행 후, 다음 숫자 인덱스를 재귀해서 넘겨줌.
                int symbol = i;
                if (symbol == 0) {
                    dfs(num + numbers[numberIndex], numberIndex + 1);
                }
                if (symbol == 1) {
                    dfs(num - numbers[numberIndex], numberIndex + 1);
                }
                if (symbol== 2) {
                    dfs(num * numbers[numberIndex], numberIndex + 1);
                }
                if (symbol == 3) {
                    dfs(num / numbers[numberIndex], numberIndex + 1);
                }
                symbols[i]++;
            }
        }

    }

}
