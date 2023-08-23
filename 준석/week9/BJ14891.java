package 준석.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ14891 {
    static int[][] array;
    //회전횟수
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        array = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String value = br.readLine();
            String[] valueArray = value.split("");
            for (int j = 0; j < 8; j++) {
                array[i][j] = Integer.parseInt(valueArray[j]);
            }
        }
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] data = br.readLine().split(" ");
            int gearNumber = Integer.parseInt(data[0]) - 1;
            int direction = Integer.parseInt(data[1]);

            rotate(gearNumber, direction);
        }

        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (array[i][0] == 1) {
                score += (int) Math.pow(2, i);
            }
        }

        System.out.println(score);
    }

    static void rotate(int gearNumber, int direction) {
        //톱니바퀴가 회전할때 옆 톱니바퀴가 어떻게 회전하는 지
        int[] directions = new int[4];
        //direction[i] -> 1이면 direction[i-1] -> -1임 (시계 반시계)
        directions[gearNumber] = direction;

        // 왼쪽 기어 체크
        //[][6] -> 왼쪽 ,[][2] -> 오른쪽 -> N S 혹은 S N 일경우  왼쪽기어를 반대방향으로 돌림
        for (int i = gearNumber; i > 0; i--) {
            if (array[i][6] != array[i-1][2]) {
                directions[i-1] = -directions[i];
            } else {
                break;
            }
        }

        // 오른쪽 기어 체크
        // 반대로 오른쪽기어를 반대방향으로 돌림
        for (int i = gearNumber; i < 3; i++) {
            if (array[i][2] != array[i+1][6]) {
                directions[i+1] = -directions[i];
            } else {
                break;
            }
        }

        // 실제 기어 돌림
        for (int i = 0; i < 4; i++) {
            if (directions[i] != 0) {
                rotateGear(i, directions[i]);
            }
        }
    }

    static void rotateGear(int gearNumber, int direction) {
        if (direction == 1) { //시계방향일때
            int temp = array[gearNumber][7];
            for (int i = 7; i > 0; i--) {
                array[gearNumber][i] = array[gearNumber][i-1]; //시계방향으로 값을 한칸씩 이동시킴
            }
            array[gearNumber][0] = temp;
        } else { //반시계방향일 때
            int temp = array[gearNumber][0];
            for (int i = 0; i < 7; i++) {
                array[gearNumber][i] = array[gearNumber][i+1]; //반시계방향으로 값을 한칸씩 이동시킴
            }
            array[gearNumber][7] = temp;
        }
    }
}