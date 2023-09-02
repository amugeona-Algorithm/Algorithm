package 정민.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Loca {
    int x;
    int y;

    public Loca(int x, int y) { // 생성자 함수
        this.x = x;
        this.y = y;
    }
}

public class BJ_15686 {
    /*
     * 백준 15686
     * 치킨 배달
     */
    static int[][] city;
    static int N, M, min;
    static ArrayList<Loca> house, chicken;
    static boolean[] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 2)
                    chicken.add(new Loca(i, j));
                else if (city[i][j] == 1)
                    house.add(new Loca(i, j));
            }
        }

        combi = new boolean[chicken.size()];
        dfs(0, 0);

        // 결과 출력
        System.out.println(min);
    }

    public static void dfs(int cnt, int start) {
        if (M == cnt) {
            int sum = 0;

            for (int j = 0; j < house.size(); j++) {
                int temp = Integer.MAX_VALUE;
                for (int k = 0; k < chicken.size(); k++) {
                    if (combi[k]) {
                        int d = Math.abs(chicken.get(k).x - house.get(j).x)
                                + Math.abs(chicken.get(k).y - house.get(j).y);

                        temp = Math.min(temp, d);
                    }
                }
                sum += temp;
            }
            min = Math.min(sum, min);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!combi[i]) {
                combi[i] = true;
                dfs(cnt + 1, i + 1);
                combi[i] = false;
            }
        }

    }
}
