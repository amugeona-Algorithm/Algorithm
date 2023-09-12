package 준석.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20055 {
    static int N, K;
    static int[] belt; //내구도
    static boolean[] robot; // 로봇 위치 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N];
        robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        while (K > 0) {
            rotateBelt();
            rotateRobot();
            moveRobot();

            //로봇 올리기
            if (belt[0] > 0) {
                robot[0] = true;
                belt[0]--;
                if (belt[0] == 0) K--;
            }
            result++;
        }
        System.out.println(result);
    }

    public static void rotateBelt() {
        int last = belt[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last; // 마지막 칸의 내구도를 첫번째 칸의 내구도로 옮김
    }

    public static void rotateRobot() {
        for (int i = N - 1; i > 0; i--) {
            //오른쪽으로 이동해야하니깐
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[N - 1] = false;
    }

    public static void moveRobot() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                robot[i] = false; //현재 위치 로봇 제거 후 다음위치로 이동
                robot[i + 1] = true;
                belt[i + 1]--; // 내구도 1 감소시킴
                if (belt[i + 1] == 0) K--; //내구도 0되면 K감소
            }
        }
        robot[N - 1] = false;
    }
}
