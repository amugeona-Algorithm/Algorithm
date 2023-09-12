package 민호.Simulation;

import java.util.*;
import java.io.*;

public class BaekJoon_20055 {
    /**
     * 백준 20055
     * 시뮬레이션 - 컨베이어 벨트 위의 로봇
     * Gold 5
     */

    static int N, K; //컨베이어 벨트 길이, 내구도 0의 개수
    static int[] belt;
    static boolean[] robot;
    static int level = 1;
    static int checkZero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[2 * N + 1];
        robot = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < 2 * N + 1; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            step1();

            step2();
            checkZero = step4();
            if(checkZero >= K)
                break;

            step3();
            checkZero = step4();
            if(checkZero >= K)
                break;

            level++;
        }

        System.out.println(level);
    }

    static void step1() {
        //벨트 회전
        int temp = belt[2 * N];
        for(int i=2*N; i>1; i--){
            belt[i] = belt[i - 1];
        }
        belt[1] = temp;

        //로봇 이동
        for(int i=N-1; i>0; i--){
            if(robot[i]){
                robot[i+1] = true;
                robot[i] = false;
            }
        }

        //N칸에 로봇이 있으면 바로 내리기
        if(robot[N])
            robot[N] = false;
    }

    static void step2(){
        for(int i=N-1; i>0; i--){
            if(robot[i] && !robot[i+1] && belt[i+1] >= 1){  //다음칸에 로봇이 없고 내구도 1이상 조건
                robot[i] = false;
                robot[i+1] = true;
                belt[i+1]--;
            }
        }
    }

    static void step3(){
        if(belt[1] != 0) {
            robot[1] = true;
            belt[1]--;
        }
    }

    static int step4(){
        int countZero = 0;
        for(int i=1; i<2*N+1; i++){
            if(belt[i] == 0)
                countZero++;
        }
        return countZero;
    }
}
