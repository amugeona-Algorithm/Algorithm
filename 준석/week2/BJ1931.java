package 준석.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class BJ1931 {
    static int N;

    public static class TimeManager {
        public int startTime;
        public int endTime;

        public TimeManager(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        List<TimeManager> timeList = new ArrayList<>();
        List<Integer> endTimeList = new ArrayList<>();

        int count = 1;
        for (int i = 0; i < N; i++) {
            String time = br.readLine();
            timeList.add(new TimeManager(Integer.parseInt(time.split(" ")[0]), Integer.parseInt(time.split(" ")[1])));
            endTimeList.add(Integer.parseInt(time.split(" ")[1]));
        }
        //endTime이 같을 때에는 startTime이 더 빠른 순서대로 정렬해야한다 ( 이부분 몰랐음 ㅜ)
        List<TimeManager> sortedTimeList = timeList.stream()
                .sorted(Comparator.comparingInt((TimeManager a) -> a.endTime).thenComparing(a -> a.startTime))
                .collect(Collectors.toList());

        //        종료시간이 제일 빠른 순서대로 정렬한다.
        //        -> 종료시간이 제일 빠른걸 먼저 선택하고
        //        그 다음 것들이 시간이 중복되는지 아닌지 판별하면 됨
        int comparingTime = sortedTimeList.get(0).endTime;

        for (int i = 1; i < N; i++) {
            if (comparingTime <= sortedTimeList.get(i).startTime) {
                comparingTime = sortedTimeList.get(i).endTime;
                count++;
            }
        }
        System.out.println(count);
    }
}
