package 지환.week.w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_16508_2s {
    /*
    백준 16508
    전공책
     */

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static int result = Integer.MAX_VALUE;
    static String T;
    static int N;
    static List<Book> books = new ArrayList<>();
    static int[] visit;
    static int[] cnt = new int[26];
    static int[] selectCnt = new int[26]; //알파벱 비트

    public static void main(String[] args) throws IOException {
        T = br.readLine();
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < T.length(); i++) {
            cnt[T.charAt(i) - 'A']++; //입력받은 T 카운팅
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int money = Integer.parseInt(st.nextToken());
            String bookName = st.nextToken();
            books.add(new Book(money, bookName));
        }

        dfs(0, 0);

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);
    }

    static void dfs(int index, int totalMoney) {
        if (index == N) {
            if (check()) {
                result = Math.min(result, totalMoney);// 4가지 다 넣어둔 후 돌아오면서 검증 // 이때 재귀를 풀면서 dfs 로 모든 경우의 수에 대해 탐색
            }
            return;
        }
        for (int i = 0; i < books.get(index).getName().length(); i++) {
            selectCnt[books.get(index).getName().charAt(i) - 'A']++; //해당 알파벳 - 'A' 한 위치에 있는 배열 ++
        }
        dfs(index + 1, totalMoney + books.get(index).getMoney());
        for (int i = 0; i < books.get(index).getName().length(); i++) {
            selectCnt[books.get(index).getName().charAt(i) - 'A']--; //해당 알파벳 - 'A' 한 위치에 있는 배열 --, 탐색 후 원위치!
        }
        dfs(index + 1, totalMoney);

    }

    static boolean check() {
        for (int i = 0; i < 26; i++) {// 주어진 단어T(cnt) 의 갯수가 더 많으면 false
            if (cnt[i] > selectCnt[i]) {
                return false;
            }
        }
        return true;
    }

    static class Book {
        String name;
        int money;

        public String getName() {
            return name;
        }

        public int getMoney() {
            return money;
        }

        public Book(int money, String name) {
            this.name = name;
            this.money = money;
        }
    }
}
