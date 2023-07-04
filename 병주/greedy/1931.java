package hello;

import java.util.*;

public class Main {

    static class Meeting {
        private final int start;
        private final int end;

        public Meeting(String time) {
            this.start = Integer.parseInt(time.split(" ")[0]);
            this.end = Integer.parseInt(time.split(" ")[1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(scanner.nextLine()));
        }
        Collections.sort(meetings, (o1, o2) -> {
            if(o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        int endTime = 0;
        int count = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= endTime) {
                count++;
                endTime = meeting.end;
            }
        }
        scanner.close();
        System.out.println(count);
    }
}




