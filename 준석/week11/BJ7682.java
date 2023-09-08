package 준석.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ7682 {

    static char[][] array = new char[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int xCount = 0;
            int oCount = 0;
            String data = br.readLine();
            if (data.equals("end")) {
                break;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    array[i][j] = data.charAt(3 * i + j);
                    if (array[i][j] == 'X') {
                        xCount++;
                    }
                    if (array[i][j] == 'O') {
                        oCount++;
                    }
                }
            }
            if(checkRule(xCount, oCount)){
                System.out.println("valid");
            }
            else{
                System.out.println("invalid");
            }
        }
    }


    static boolean checkRule(int xCount, int oCount) {
        //모두 두었으면 x의 수가 o의 수보다 1개 더 많아야함
        if (xCount + oCount == 9 && xCount == oCount + 1) {
            boolean x = play('X');
            boolean o = play('O');
            //x가 이긴 경우 X는 play에 걸려야하는데 o는 걸리면 안됨
            if (x && !o) return true;
            //o가 이긴 경우 o는 play에 걸려야하는데 x는 걸리면 안됨
            if (o && !x) return true;
            if(!o && !x) return true;
        } else { // 모두 두지 못한 경우
            //X가 이긴 경우 -> X가 O보다 1개 더 많아야함
            if (play('X') && xCount == oCount + 1) {
                return true;
            }
            //O가 이긴 경우 -> X랑 O랑 개수가 같아야함
            if (play('O') && xCount == oCount) {
                return true;
            }
        }
        return false;
    }

    static boolean play(char value) {
        //대각선 검증 00 11 22, 02 11 20
        if (array[0][0] == value && array[1][1] == value && array[2][2] == value) {
            return true;
        }
        if (array[0][2] == value && array[1][1] == value && array[2][0] == value) {
            return true;
        }
        //가로 검증
        for (int i = 0; i < 3; i++) {
            if (array[i][0] == value && array[i][1] == value && array[i][2] == value) {
                return true;
            }
        }
        //세로 검증
        for (int i = 0; i < 3; i++) {
            if (array[0][i] == value && array[1][i] == value && array[2][i] == value) {
                return true;
            }
        }
        return false;
    }
}
