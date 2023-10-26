package 지환.week.w11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20055 {
    /*

    백준
    20055
    컨베이어 벨트
    골드5
     */
    private static List<Belt> belts = new ArrayList<>();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int result = 0;
    private static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belts.add(new Belt(Integer.parseInt(st.nextToken())));
        }
        int count = 0;

        while (count < K) {
            result++;
            lastRobotDown();
            moveBelts();
            lastRobotDown();
            moveRobots();
            upRobotToFirstBelt();
            count = countAllBeltState();
        }
        System.out.println(result);
    }

    static int countAllBeltState() {
        return (int) belts.stream().filter(x -> x.state == 0).count();
    }

    static void upRobotToFirstBelt() {
        Belt firstBelt = belts.get(0);
        if (firstBelt.hasState() && !firstBelt.hasRobot) {
            firstBelt.upRobot();
            firstBelt.state--;
        }
    }

    static void moveBelts() {
        Belt remove = belts.remove(belts.size() - 1);
        belts.add(0, remove);
    }

    static void moveRobots() {
        //1~N-1 번째의 벨트에서 로봇 움직임 확인 및 움직임
        for (int i = N-2; i >=0; i--) {
            Belt belt = belts.get(i);
            Belt nextBelt = belts.get(i + 1);
            if (belt.hasRobot && !nextBelt.hasRobot && nextBelt.hasState()) {
                belt.downRobot();
                nextBelt.upRobot();
                nextBelt.state--;
            }
        }
        //마지막칸 로봇 다운
        lastRobotDown();
    }

    private static void lastRobotDown() {
        belts.get(N-1).downRobot();
    }

    static class Belt {
        int state;
        boolean hasRobot;

        public Belt(int state) {
            this.state = state;
            this.hasRobot = false;
        }

        public void upRobot() {
            hasRobot = true;
        }

        public void downRobot() {
            hasRobot = false;
        }

        public boolean hasState() {
            return state > 0;
        }
    }
}
