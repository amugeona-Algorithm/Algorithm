package 정민.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15661 {
    /*
     * 백준 15661
     * 링크와 스타트
     * 완전 탐색
     */
    static int N;
    static int min = Integer.MAX_VALUE; // 최솟값
    static boolean[] isTeamStart; // 조합 위함
    static int[][] stats;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        stats = new int[N + 1][N + 1];
        isTeamStart = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀꾸리기
        for (int i = 1; i <= N - 1; i++) {
            makeTeam(i, 1, 0);
        }

        System.out.println(min);
    }

    public static void makeTeam(int members, int start, int cnt) { // 뽑아야하는 멤버 수, 시작 번호, 몇명 뽑앗는지
        if (members == cnt) {
            calcStats();
            return;
        }

        for (int i = start; i <= N; i++) {
            isTeamStart[i] = true;
            makeTeam(members, i + 1, cnt + 1);
            isTeamStart[i] = false;
        }
    }

    public static void calcStats() {
        int teamS = 0;
        int teamL = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j)
                    continue;

                if (isTeamStart[i] == isTeamStart[j]) {
                    // 같은 팀이라면
                    if (isTeamStart[i])
                        teamS += stats[i][j];
                    else
                        teamL += stats[i][j];
                }
            }
        }
        min = Math.min(Math.abs(teamS - teamL), min);
        return;
    }
}
