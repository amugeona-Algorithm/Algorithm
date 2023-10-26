package 지환.week.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Back_15661 {
    /*
    백준 15661
    링크와 스타트
     */
    static int N;
    static int[][] S;
    static int[] visit;
    static int result = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visit = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N - 1; i++) {
            combi(i, 0, 0);
        }
        System.out.println(result);
    }

    static void combi(int teamNumber, int start, int count) {
        if (count == teamNumber) {
            calculateLevel();
            return;
        }
        for (int i = start; i < N; i++) {
            visit[i] = 1;
            combi(teamNumber, start + 1, count + 1);
            visit[i] = 0;
        }
    }

    static void calculateLevel() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visit[i] == 1 && visit[j] == 1) {
                    startTeam = startTeam + S[i][j];
                } else if (visit[i] == 0 && visit[j] == 0) {
                    linkTeam = linkTeam + S[i][j];
                }
            }
        }

        int temp = Math.abs(linkTeam - startTeam);

        if (temp == 0) {
            System.out.println(temp);
            System.exit(0);
        }

        if (temp < result) {
            result = temp;
        }
    }
}
