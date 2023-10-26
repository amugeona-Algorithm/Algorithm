package 지환.week.w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Back_1969 {
    /*
    백준 1969
    DNA
     */

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static int N;
    static int M;
    static List<List<String>> map = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 0; i < N; i++) {
            List<String> temp = Arrays.stream(br.readLine().split(""))
                    .collect(Collectors.toList());
            map.add(temp);
        }
        String dna = "";
        for (int i = 0; i < M; i++) {
            String col = "";
            for (int j = 0; j < N; j++) {
                col = col + map.get(j).get(i);
            }
            dna = dna + findDNA(col);
        }

        //출력용
        System.out.println(dna);
        System.out.println(countHD(dna));
    }

    private static String findDNA(String col) {
        float a = 0.3F;
        float c = 0.2F;
        float g = 0.1F;
        float t = 0F;

        for (int i = 0; i < col.length(); i++) {
            if (col.charAt(i) == 'A') {
                a++;
            } else if (col.charAt(i) == 'C') {
                c++;
            } else if (col.charAt(i) == 'G') {
                g++;
            } else if (col.charAt(i) == 'T') {
                t++;
            }

        }
        List<Float> list = new ArrayList<>();
        list.add(a);
        list.add(c);
        list.add(g);
        list.add(t);
        Float aFloat = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0);

        if (aFloat.floatValue() == a) {
            return "A";
        }
        if (aFloat.floatValue() == c) {
            return "C";
        }
        if (aFloat.floatValue() == g) {
            return "G";
        }
        if (aFloat.floatValue() == t) {
            return "T";
        }
        return null;
    }

    static int countHD(String dna) {
        int count = 0;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                if (!map.get(i).get(j).equals(String.valueOf(dna.charAt(j)))) {

                    count++;
                }
            }
        }
        return count;
    }
}
