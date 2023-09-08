package 지환.backjoon.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_15686 {

    /*
    백준 15686
    치킨 배달
    골드 5
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;

    private static List<Positon> ch = new ArrayList<>();
    private static List<Positon> ho = new ArrayList<>();

    private static boolean[] visited = new boolean[20];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        List<String> collect = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
        N = Integer.parseInt(collect.get(0));
        M = Integer.parseInt(collect.get(1));
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    ho.add(new Positon(i, j, num, Integer.MAX_VALUE));
                }
                if (num == 2) {
                    ch.add(new Positon(i, j, num, Integer.MAX_VALUE));
                }
            }
        }
        combi(0, 0, M);
        System.out.println(result);
    }

    private static void combi(int start, int count, int M) {
        if (count == M) {
            List<Positon> tempChs = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    tempChs.add(ch.get(i));
                }
            }

            //기존 최단 거리들 모두 초기화 -> 앞에서 구한 거리가 영향을 끼치지 않게하기 위함
            ho.forEach(ho -> ho.distance = Integer.MAX_VALUE);

            //각 집에서 치킨집 까지의 거리 최단 거리 구하기.
            ho.forEach(home -> tempChs.forEach(home::updateShortestDistance));
            int sum = ho.stream().mapToInt(ho -> ho.distance).sum();
            result = Math.min(sum, result);
            return;
        }
        for (int i = start; i < ch.size(); i++) {
            visited[i] = true;
            combi(i + 1, count + 1, M);
            visited[i] = false;
        }
    }

    static class Positon {
        int r;
        int c;

        int number;

        int distance;

        public Positon(int r, int c, int number, int distance) {
            this.r = r;
            this.c = c;
            this.number = number;
            this.distance = distance;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        //현재 위치에서 입력받은 위치까지의 최단 경로 업데이트, 기존 길이가 더 작으면 그냥 냅둠
        public void updateShortestDistance(Positon p) {
            this.distance = Math.min(this.distance, Math.abs(p.getC() - this.c) + Math.abs(p.getR() - this.r));
        }
    }

}