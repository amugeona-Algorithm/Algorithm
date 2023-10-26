package 지환.week.w11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_7682 {
    /*
    백준 7682
    틱택토
    실버1
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] map = new char[3][3];
    private static StringBuffer sb = new StringBuffer();


    public static void main(String[] args) throws IOException {
        String s;
        while (!(s = br.readLine()).equals("end")) {

            for (int i = 0; i < 9; i++) {
                map[i / 3][i % 3] = s.charAt(i);
            }

            if( sol(map))
            {
                sb.append("valid").append("\n");
            }else {
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean sol(char[][] map) {
        int oCount = 0;
        int xCount = 0;

        for (int i = 0; i < 9; i++) {
            char c = map[i / 3][i % 3];
            if (c == 'O') {
                oCount++;
            } else if (c == 'X') {
                xCount++;
            }
        }

        if (xCount + oCount == 9) {
            if (xCount - 1 != oCount || isBinggo(map, 'O')) {
                return false;
            }
            return true;
        }

        //O빙고로 끝나는 겨웅
        if (xCount == oCount) {
            boolean isXBingGo = isBinggo(map, 'X');
            boolean isOBingGo = isBinggo(map, 'O');

            if (isOBingGo && !isXBingGo) {
                return true;
            }
            return false;
        }
        //X 빙고로 끝나는 경우
        if (xCount - 1 == oCount) {
            boolean isXBingGo = isBinggo(map, 'X');
            boolean isOBingGo = isBinggo(map, 'O');

            if (isXBingGo && !isOBingGo) {
                return true;
            }
            return false;
        }

        //다른 경우들은 모두 false
        return false;
    }


    private static boolean isBinggo(char[][] map, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (map[i][0] == symbol && map[i][1] == symbol && map[i][2] == symbol) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (map[0][i] == symbol && map[1][i] == symbol && map[2][i] == symbol) {
                return true;
            }
        }

        if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol) {
            return true;
        }
        if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol) {
            return true;
        }
        return false;
    }
}
