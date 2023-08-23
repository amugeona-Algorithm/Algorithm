package Algorithm.지환.backjoon.w9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Back_14891 {

    /*
    백준 14891
    톱니바퀴

     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Gear> gears = new ArrayList<>();
    private static Queue<Gear> queue = new LinkedList<>();
    private static Queue<Integer> rotations = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            gears.add(new Gear(i, br.readLine()));
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            move(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }


        int result = 0;

        for (int i = 0; i < 4; i++) {
            if (gears.get(i).top() == 1) {
                result += Math.pow(2, i);
            }
        }
        System.out.println(result);

    }

    private static void move(int gearNumber, int rotation) {
        queue.offer(gears.get(gearNumber));
        rotations.offer(rotation);

        while (!queue.isEmpty()) {
            Gear curGear = queue.poll();
            int curRotation = rotations.poll();
            if (curRotation == -1) {
                curGear.turnLeft();
            } else {
                curGear.turnRight();
            }
            rotateSideGear(curGear.number, curRotation, curGear);
        }
    }

    private static void rotateSideGear(int gearNumber, int rotation, Gear curGear) {
        //왼쪽 기어 회전 유무 판단 후 돌리도록 큐 에 추가
        int curGearLeftPole = curGear.leftPole();
        //기어넘버가 0보다 크거나 같아야함(존재하고) + 서로 극이 다르면 회전
        int leftGearIndex = gearNumber - 1;
        if (leftGearIndex >= 0 && curGearLeftPole != gears.get(leftGearIndex).rightPole()) {
            queue.offer(gears.get(leftGearIndex));
            //반대방향으로 회전하도록 추가
            rotations.offer(rotation * -1);
        }
        //오른쪽 기어 회전 유무 판단 후 돌리도록 큐에 추가
        int curGearRightPole = curGear.rightPole();
        //기어넘버가 3보다 작거나 같아야함(존재여부) + 서로 극이 다르면 회전
        int rightGearIndex = gearNumber + 1;
        if (rightGearIndex <= 3 && curGearRightPole != gears.get(rightGearIndex).leftPole()) {
            queue.offer(gears.get(rightGearIndex));
            rotations.offer(rotation * -1);
        }
    }

    static class Gear {

        int number;
        List<Tooth> sawTooth;

        int top() {
            return sawTooth.get(0).pole;
        }

        int leftPole() {
            return sawTooth.get(6).pole;
        }

        int rightPole() {
            return sawTooth.get(2).pole;
        }

        void turnRight() {
            sawTooth.add(0, sawTooth.remove(7));
        }

        void turnLeft() {
            sawTooth.add(sawTooth.remove(0));
        }

        public Gear(int number, String line) {
            this.number = number;
            int[] array = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
            List<Tooth> objects = new ArrayList<>();
            for (int j : array) {
                objects.add(new Tooth(j));
            }

            this.sawTooth = objects;
        }
    }

    static class Tooth {
        int pole;

        public Tooth(int poleNumber) {
            this.pole = poleNumber;
        }
    }
}

