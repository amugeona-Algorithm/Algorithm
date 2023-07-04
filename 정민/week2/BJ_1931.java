package 정민.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1931 {
    /*
     * 백준 1931
     * 회의실 배정
     */
    static class Time implements Comparable<Time> {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time t) {
            if (end != t.end)
                return end - t.end;
            else
                return start - t.start;
        }
    }

    static int N, res;
    static ArrayList<Time> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        StringTokenizer st;
        res = 1;
        // 서로 겹치지 않으면서 종료시간이 빠른 것
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Time(start, end));
        }
        Collections.sort(list); // 종료시간 빠르고, 종료시간이 같다면 회의 시작시간 빠른순
        int endT = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            Time t = list.get(i);
            if (t.start >= endT) {
                res++;
                endT = t.end;
            }
        }
        System.out.println(res);

    }

}