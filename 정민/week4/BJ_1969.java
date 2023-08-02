package 정민.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1969 {

    /*
     * 백준 1969
     * DNA
     */
    static String s = ""; // 결과 s 값
    static int N, M;
    static int min = 0; // 합의 최소값

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        String[] dna = new String[N];

        for (int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            int max = 0;
            char maxChar = '.';
            HashMap<Character, Integer> check = new HashMap<>();

            for (int j = 0; j < N; j++) {
                char temp = dna[j].charAt(i);
                if (!check.containsKey(temp))
                    check.put(temp, 1);
                else {
                    check.put(temp, check.get(temp) + 1);
                }

                if (max < check.get(temp)) {
                    max = check.get(temp);
                    maxChar = temp;
                }
            }

            if (check.size() == 1) {
                s += maxChar;
                continue;
            }
            // 가장 많이 저장된 DNA 값 출력, 단 사전순으로 앞서는 것
            if (maxChar == 'C') {
                if (check.containsKey('A') && check.get('A') == max)
                    maxChar = 'A';
            } else if (maxChar == 'G') {
                if (check.containsKey('A') && check.get('A') == max)
                    maxChar = 'A';
                else if (check.containsKey('C') && check.get('C') == max)
                    maxChar = 'C';
            } else if (maxChar == 'T') {
                if (check.containsKey('A') && check.get('A') == max)
                    maxChar = 'A';
                else if (check.containsKey('C') && check.get('C') == max)
                    maxChar = 'C';
                else if (check.containsKey('G') && check.get('G') == max)
                    maxChar = 'G';
            }

            s += maxChar;
            min += N - check.get(maxChar);
        }

        System.out.println(s);
        System.out.println(min);

    }

}