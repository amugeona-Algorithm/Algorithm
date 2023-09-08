package 지환.backjoon.w4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Back_16508 {
    /*
    백준 16508
    전공책
     */

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int result = Integer.MAX_VALUE;
    static String T;
    static int N;
    static List<Book> books = new ArrayList<>();
    static int[] visit;

    public static void main(String[] args) throws IOException {
        T = br.readLine();
        N = Integer.parseInt(br.readLine());
        visit = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int money = Integer.parseInt(st.nextToken());
            String bookName = st.nextToken();
            books.add(new Book(money, bookName));
        }
        for (int i = 1; i <= N; i++) {
            combi(i, 0, 0);
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
            System.exit(0);
        }else
            System.out.printf(String.valueOf(result));
    }


    static void combi(int bookNumber, int start, int count) {
        if (count == bookNumber) {
            result = Math.min(countMinBookMoney(), result);
            return;
        }

        for (int i = start; i < N; i++) {
            visit[i] = 1;
            combi(bookNumber, start + 1, count + 1);
            visit[i] = 0;
        }
    }

    static int countMinBookMoney() {
        List<Integer> visitIndex = new ArrayList<>();
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == 1) {
                visitIndex.add(i);
            }
        }

        int booksMoney = 0;
        StringBuilder bookNameSum = new StringBuilder();
        for (int index : visitIndex) {
            bookNameSum.append(books.get(index).getName());
            booksMoney += books.get(index).getMoney();
        }

        List<String> bookNames = Arrays.stream(bookNameSum.toString().split("")).collect(Collectors.toList());
        int initSizeOfBookNames = bookNames.size();
        List<String> Ts = Arrays.stream(T.split("")).collect(Collectors.toList());
        for (String t : Ts) {
            bookNames.remove(t);
        }

        if (bookNames.size() + Ts.size() == initSizeOfBookNames) {
            return booksMoney;
        }
        return Integer.MAX_VALUE;
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
