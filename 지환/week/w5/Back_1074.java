package 지환.week.w5;

import java.io.*;
import java.util.*;

public class Back_1074 {
    /*
    백준 1074
    Z
    분할정복
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    private static int n;
    private static int R;
    private static int C;
    private static int count = 0;
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());


        divideZ((int) Math.pow(2, n), 0, 0);
        System.out.println(sb.toString());
    }

    private static void divideZ(int dist, int r, int c) {
        if (r == R && c == C) {
            sb.append(count);
            return;
        }
        if (R >= r && C >= c && R < r + dist && C < c + dist) { //현재 사분면에 있다면
            divideZ(dist / 2, r, c);
            divideZ(dist / 2, r, c + dist / 2);
            divideZ(dist / 2, r + dist/2, c);
            divideZ(dist / 2, r + dist / 2, c + dist / 2);
        } else { // 없으면 count 더해줌. 현재 사분면 만큼의 수
            count = count + (dist * dist);
        }
    }

}

