package Algorithm.지환.backjoon.w6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Back_15663 {
    /*
    백준 15663
    N 과 M 9
     */

    private static int N;
    private static int M;
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] isUsed;
    private static int[] arr;

    private static int[] nums;
    private static HashSet<String> set = new LinkedHashSet<>();
    private static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isUsed = new boolean[10];
        arr = new int[M];
        nums = new int[M];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        //0부터 넣어주는 이유는 aar[0] 부터 채워 넣기 위함
        func(0);
        //중복 제거를 위해 set 사용
        set.forEach(System.out::println);
    }

    private static void func(int k) {
        if (k == M) {
            sb = new StringBuffer();
            for (int i = 0; i < M; i++) {
                sb.append(nums[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;//사용됨 처리
                nums[k] = arr[i];
                func(k + 1); //다음으로 진행
                isUsed[i] = false; //재귀 끝나고 나오면서 사용처리 풀어줌. -> 다시 써야해서
            }
        }
    }
}

