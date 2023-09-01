package 준석.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ15686 {
    static int N;
    static int M;

    static int[][] chicken;

    static List<MapList> chickenList = new ArrayList<>();

    static List<MapList> houseList = new ArrayList<>();

    static MapList[] selectedChicken;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        N = Integer.parseInt(data.split(" ")[0]);
        M = Integer.parseInt(data.split(" ")[1]);

        chicken = new int[N][N];
        selectedChicken = new MapList[M];

        for (int i = 0; i < N; i++) {
            String[] value = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                chicken[i][j] = Integer.parseInt(value[j]);
                if (chicken[i][j] == 1) {
                    houseList.add(new MapList(i, j));
                }
                if (chicken[i][j] == 2) {
                    chickenList.add(new MapList(i, j));
                }
            }
        }

        selectChicken(0,0);
        System.out.println(result);
    }

    //depth가 M이 될때까지 가능한 치킨집 조합
    //selectedchicken에 선택된 치킨집에 좌표를 저장
    static void selectChicken(int start, int depth) {
        if (depth == M) {
            calculate(); //현재 선택된 조합으로 거리 계산
            return;
        }
        for (int i = start; i < chickenList.size(); i++) {
            selectedChicken[depth] = chickenList.get(i);
            selectChicken(i + 1, depth + 1);
        }
    }

    static void calculate() {
        int totalDist = 0;
        for (MapList house : houseList) {
            int minDistance = Integer.MAX_VALUE;
            for (MapList chicken : selectedChicken) {
                //치킨집까지 거리 계산해서 최솟값 갱신
                int distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                minDistance = Math.min(minDistance, distance);
            }
            totalDist += minDistance;
        }
        result = Math.min(result, totalDist);
    }
}

class MapList {
    int x;
    int y;

    public MapList(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

