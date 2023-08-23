package 준석.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ20438 {
    static int N;
    static int K;
    static int Q;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String data = br.readLine();

        N = Integer.parseInt(data.split(" ")[0]);
        K = Integer.parseInt(data.split(" ")[1]);
        Q = Integer.parseInt(data.split(" ")[2]);
        M = Integer.parseInt(data.split(" ")[3]);
    }
}
