package 민호.Greedy;

import java.util.*;
import java.io.*;

public class BaekJoon_1931 {
    /**
     * 백준_1931
     * 회의실 배정 문제
     * compareTo Override "https://st-lab.tistory.com/243"
     */

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        //종료 시간 기준으로 정렬하도록 override
        @Override
        public int compareTo(Meeting meeting) {
            if (this.end > meeting.end) {
                return 1; //아무 양수 가능
            } else if (this.end < meeting.end) {
                return -1; //아무 음수 가능
            } else
                return this.start - meeting.start; //종료 시간이 동일하면 시작 시간기준으로 정렬

        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int result = 1; //회의 수는 최소 1

        ArrayList<Meeting> mList = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mList.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(mList);
        int check = mList.get(0).end;   //가장 먼저 끝나는 회의의 종료시간이 기준

        for (int i = 1; i < N; i++){
            if(mList.get(i).start >= check){ //새로운 회의 시작 시간이 이전 회의의 종료시간 이후인 경우
                check = mList.get(i).end;
                result++;
            }
        }
        System.out.println(result);
    }
}
