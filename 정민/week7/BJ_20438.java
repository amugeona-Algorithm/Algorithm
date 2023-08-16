package 정민.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20438 {
    /*
     * 백준 20438
     * 출석체크
     * 누적합
     */

    // 제한시간 0.1초

    static boolean[] isSleeping, students;
    static int[] sum;
    static int N, K, Q, M, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 졸고 있는 학생수
        Q = Integer.parseInt(st.nextToken()); //
        M = Integer.parseInt(st.nextToken());

        students = new boolean[N + 3];
        sum = new int[N + 3];
        isSleeping = new boolean[N + 3];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < K; i++) { // 졸고있는 학생 입장 번호
            int n = Integer.parseInt(st.nextToken());
            isSleeping[n] = true;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; i++) {
            int n = Integer.parseInt(st.nextToken()); // 출석 코드를 받은 입장 번호
            if (!isSleeping[n])
                sendCode(n);
        }

        // 누적합 계산 - 출석코드를 못받은 학생 학생
        for (int i = 3; i <= N + 2; i++) {
            if (students[i])
                sum[i] = sum[i - 1];
            else
                sum[i] = sum[i - 1] + 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            System.out.println(calcAbsent(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

    }

    public static void sendCode(int start) {
        // 출석 코드 보내기, 출석했다면 t, 아니라면 f
        for (int i = start; i <= N + 2; i += start) {
            if (!isSleeping[i])
                students[i] = true;
        }
    }

    public static int calcAbsent(int start, int end) {
        return sum[end] - sum[start - 1];
    }
}