package 민호.PrefixSum;

import java.util.*;
import java.io.*;

public class BaekJoon_20438 {
    /**
     * 백준 20438
     * 누적 합 - 출석체크
     * Silver 2
     */

    static int N, K, Q, M; //학생 수, 졸고 있는 학생 수, 출석 코드를 보낼 학생 수, 주어질 구간 수
    static int S, E;
    static int[] student;
    static int[] sleeping;
    static int[] code;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        student = new int[N + 3];
        result = new int[N + 3];
        sleeping = new int[K];
        code = new int[Q];

        for (int i = 3; i < N + 3; i++) {
            student[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            sleeping[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            code[i] = Integer.parseInt(st.nextToken());
        }


        for (int value : code) {
            PS(value);
        }

        int[] prefix = new int[N+1];
        for (int i = 3; i < N + 3; i++) {
            prefix[i] = prefix[i - 1];
            if (result[i] == 0)
                prefix[i]++;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            System.out.println(prefix[E] - prefix[S - 1]);
        }

    }

    static void PS(int code) {
        for (int i = 3; i < result.length; i++) {
            if (student[i] % code == 0 && checkSleeping(student[i])) { //입장코드의 배수 학생 그리고 졸지 않는 학생인 경우
                result[i] = 1;
            }
        }
    }

    static boolean checkSleeping(int student) {
        for (int value : sleeping) {
            if (value == student)
                return false;   //조는 학생인 경우 false
        }
        return true;    //졸지 않은 학생인 경우 true
    }
}
