package 민호.BruteForce;

import java.util.*;
import java.io.*;

public class BaekJoon_15661 {
    /**
     * 백준 15561
     * 완전탐색(재귀함수) - 링크와 스타트
     * Sliver 1
     */

    static int N;
    static int point[][];
    static int team[];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        point = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                point[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        team = new int[N + 1]; //어느 팀인지 확인하기 위한 배열

        for (int i = 1; i < N; i++) {
            makeTeam(i, 0, 1);
        }

        System.out.println(result);
    }

    static void makeTeam(int memberNum, int count, int start) { //두 팀의 인원수가 같지 않고 한명 이상이기에 memberNum 매개변수로 받기
        if (count == memberNum) {
            diffMin();
            return;
        }

        for (int i = start; i < N + 1; i++) {
            if (team[start] != 1) {
                team[start] = 1; //그래프 탐색에서와 같이 방문 or 비방문으로 어느 팀인지 확인
                makeTeam(memberNum, count + 1, i + 1);
                team[start] = 0;
            }
        }
    }

    static void diffMin() {
        int teamSum1 = 0;
        int teamSum2 = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (team[i] == 1 && team[j] == 1) {
                    teamSum1 += point[i][j];
                } else if (team[i] == 0 && team[j] == 0) {
                    teamSum2 += point[i][j];
                }
            }
        }

        result = Math.min(Math.abs(teamSum1 - teamSum2), result);
    }
}
