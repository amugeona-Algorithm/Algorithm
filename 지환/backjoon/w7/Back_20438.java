package 지환.backjoon.w7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_20438 {
    /*
    백준 20438
    출석 체크
    실버 2
     */

    private static int N;
    private static int K;

    private static int Q;
    private static int M;

    private static int S, E;

    private static int result;
    private static List<Integer> zzzStudents = new ArrayList<>();
    private static int[] visit = new int[6000];


    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 조는 학생들 입력
        for (int i = 0; i < K; i++) {
            zzzStudents.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            //출석 코드 부르는 q
            int q = Integer.parseInt(st.nextToken());
            if (zzzStudents.contains(q)) {

            } else {
                for (int j = q; j <= N + 3; j = j + q) {
                    // 배수 순회하면서, 자고 있는 학생 리스트에 배수가 없다면 방문처리를 함. 자고 있다면 출석 x
                    if (!zzzStudents.contains(j)) {
                        //출석 처리
                        visit[j] = 1;
                    }
                }

            }
        }

        //prefix 계산 및 생성, 앞칸 + 출석 횟수 = 뒷칸
        int[] prefix = new int[6000];
        for (int i = 3; i <= N + 2; i++) {
            prefix[i] = prefix[i - 1];
            if (visit[i] == 0) {
                prefix[i]++;
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            System.out.println(prefix[E ] - prefix[S - 1]);
        }

    }
}

