package 정민.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1074 {
    // Z
    static int n, r, c, smallB, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        n = Integer.parseInt(s[0]);
        r = Integer.parseInt(s[1]);
        c = Integer.parseInt(s[2]);

        zzz();
        System.out.println(num);

    }

    public static void zzz() {
        while (true) {
            // 1.한면 길이 구하기
            int size = (int) Math.pow(2, n);
            // 2. r, c를 통한 위치 구하기
            int cnt = 0;
            if (size / 2 > r && size / 2 > c) {
                cnt = 0;
            } else if (size / 2 > r && size / 2 <= c) {
                cnt = 1;
            } else if (size / 2 <= r && size / 2 > c) {
                cnt = 2;
            } else if (size / 2 <= r && size / 2 <= c) {
                cnt = 3;
            }

            if (size == 2) {
                num += cnt;
                break;
            } else {
                // 3. 순서 계산하기
                smallB = (int) Math.pow(2, n) * (int) Math.pow(2, n) / 4; // pow는 double
                num += smallB * cnt; // 순서 계산

                // 재귀를 위해서
                n = n - 1;
                switch (cnt) {
                    case 0:
                        break;
                    case 1:
                        c -= size / 2;
                        break;
                    case 2:
                        r -= size / 2;
                        break;
                    case 3:
                        r -= size / 2;
                        c -= size / 2;
                        break;
                }

            }

        }
    }
}
