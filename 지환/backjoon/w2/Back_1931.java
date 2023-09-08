package 지환.backjoon.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Back_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> is = new LinkedHashMap<>();
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            meetings.add(new Meeting(start, end));
        }

        List<Meeting> sortedMeetings = meetings.stream()
                .sorted()
                .collect(Collectors.toList());


        int result = 0;
        int curEnd = 0;
        for (Meeting meeting : sortedMeetings) {
            // 시간이기 때문에 >= 끝나자 마자 바로 가능.
            if (meeting.start >= curEnd ) {
                curEnd = meeting.end;
                result++;
            }
        }

        System.out.println(result);

    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if ((end - o.end) > 0) {
                return 1;
            } else if ((end - o.end) == 0) {
                return start - o.start;
            }
            return -1;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
