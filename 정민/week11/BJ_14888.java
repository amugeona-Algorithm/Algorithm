package 정민.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14888 {
    /*
     * 백준 14888
     * 연산자 끼워넣기
     * silver 1
     */
    static int max, min, N;
    static int[] num, operator, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        num = new int[N];
        operator = new int[5]; // 1 : 덧셈, 2 : 뺄셈, 3 : 곱셈, 4 : 나눗셈
        res = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        choosePlus(0, 0);

        System.out.println(max);
        System.out.println(min);

    }

    public static void choosePlus(int cnt, int start) {
        if (cnt == operator[1]) {
            // - 배치하러 가기
            chooseMinus(0, 0);
            return;
        }

        for (int i = start; i < N - 1; i++) {
            res[i] = 1; // 1은 플러스
            choosePlus(cnt + 1, i + 1);
            res[i] = 0;

        }
    }

    public static void chooseMinus(int cnt, int start) {
        if (cnt == operator[2]) {
            // * 배치하러 가기
            chooseMultify(0, 0);
            return;
        }

        for (int i = start; i < N - 1; i++) {
            if (res[i] == 0) {
                res[i] = 2;
                chooseMinus(cnt + 1, i + 1);
                res[i] = 0;
            }
        }
    }

    public static void chooseMultify(int cnt, int start) {
        if (cnt == operator[3]) {
            calc();
            return;
        }
        for (int i = start; i < N - 1; i++) {
            if (res[i] == 0) {
                res[i] = 3;
                chooseMultify(cnt + 1, i + 1);
                res[i] = 0;
            }
        }
    }

    public static void calc() {
        int sum = num[0];
        for (int i = 0; i < N - 1; i++) {
            if (res[i] == 1) {
                sum += num[i + 1];
            } else if (res[i] == 2) {
                sum -= num[i + 1];
            } else if (res[i] == 3) {
                sum *= num[i + 1];
            } else {
                if (sum < 0) {
                    int temp = sum * (-1);
                    temp /= num[i + 1];
                    sum = temp * (-1);

                } else if (sum == 0) {
                    sum = 0;
                } else {
                    sum /= num[i + 1];
                }
            }
        }

        min = Math.min(min, sum);
        max = Math.max(max, sum);

        return;
    }

}
