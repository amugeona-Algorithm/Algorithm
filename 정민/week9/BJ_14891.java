package 정민.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14891 {
    /*
     * 백준 14891
     * 톱니바퀴
     */
    static public int res, K;
    static public StringTokenizer st;
    static public ArrayList<ArrayList<Character>> gears;

    static public class Gear {
        int num;
        int d;

        public Gear(int num, int d) {
            this.num = num;
            this.d = d;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        // 1. 서로 맞닿은 극이 다르면 반대방향으로 회전
        // 2. 맞닿은 극이 같다면 회전 X

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        res = 0;
        gears = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            gears.add(new ArrayList<>());
        }

        for (int i = 0; i < 4; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears.get(i).add(temp.charAt(j));
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            startTurn(num - 1, dir);
        }

        calc();
        System.out.println(res);

    }

    public static void startTurn(int n, int dir) {

        // 시계방향은 1, 반시계는 -1
        Queue<Gear> que = new LinkedList<>();

        que.add(new Gear(n, dir));

        if (n == 0) {
            if (gears.get(0).get(2) != gears.get(1).get(6)) {
                que.add(new Gear(1, -dir));
                if (gears.get(1).get(2) != gears.get(2).get(6)) {
                    que.add(new Gear(2, dir));
                    if (gears.get(2).get(2) != gears.get(3).get(6))
                        que.add(new Gear(3, -dir));
                }
            }
        } else if (n == 3) {
            if (gears.get(3).get(6) != gears.get(2).get(2)) {
                que.add(new Gear(2, -dir));
                if (gears.get(2).get(6) != gears.get(1).get(2)) {
                    que.add(new Gear(1, dir));
                    if (gears.get(1).get(6) != gears.get(0).get(2))
                        que.add(new Gear(0, -dir));
                }
            }

        } else if (n == 1) {
            if (gears.get(1).get(6) != gears.get(0).get(2)) {
                que.add(new Gear(0, -dir));
            }

            if (gears.get(1).get(2) != gears.get(2).get(6)) {
                que.add(new Gear(2, -dir));
                if (gears.get(2).get(2) != gears.get(3).get(6))
                    que.add(new Gear(3, dir));
            }
        } else if (n == 2) {
            if (gears.get(2).get(2) != gears.get(3).get(6)) {
                que.add(new Gear(3, -dir));
            }
            if (gears.get(2).get(6) != gears.get(1).get(2)) {
                que.add(new Gear(1, -dir));
                if (gears.get(1).get(6) != gears.get(0).get(2))
                    que.add(new Gear(0, dir));
            }
        }

        turn(que);
    }

    public static void turn(Queue<Gear> que) {
        while (!que.isEmpty()) {
            Gear gear = que.poll();
            if (gear.d == -1) { // 반시계 회전
                gears.get(gear.num).add(gears.get(gear.num).get(0));
                gears.get(gear.num).remove(0);
            } else {
                // 시계방향 회전
                gears.get(gear.num).add(0, gears.get(gear.num).get(7));
                gears.get(gear.num).remove(8);
            }
        }
    }

    public static void calc() {
        for (int i = 0; i < 4; i++) {
            if (gears.get(i).get(0) == '1') { // n은 0, s는 1
                switch (i) {
                    case 0:
                        res += 1;
                        break;
                    case 1:
                        res += 2;
                        break;
                    case 2:
                        res += 4;
                        break;
                    case 3:
                        res += 8;
                        break;
                }
            }
        }
    }
}
