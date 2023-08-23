package 정민.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1713 {
    /*
     * 백준 1713
     * 후보 추천하기
     */
    static int N, cnt; // 사진틀 개수, 총 추천회수
    // static int min = Integer.MAX_VALUE; // 최소 횟수
    static ArrayList<Integer> list; // 시간 기억 위함
    static HashMap<Integer, Integer> onBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = Integer.parseInt(br.readLine()); // 전체 학생의 총 추천횟수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        list = new ArrayList<>(); // 1.
        onBoard = new HashMap<>(); // 추천 횟수 저장 값

        for (int i = 0; i < cnt; i++) {
            int stu = Integer.parseInt(st.nextToken()); // 추천할 학생 번호
            recommendStudent(stu);
        }

        // 증가하는 순 출력

        Collections.sort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }

    public static void recommendStudent(int id) {
        // id : 추천 받은 학생
        // 사진을 삭제하고 그 자리에 새롭게 추천받은 학생 사진 개시

        if (onBoard.containsKey(id)) {
            int temp = onBoard.get(id) + 1;
            onBoard.put(id, temp);
        } else {
            if (list.size() == N)
                removePhoto();
            onBoard.put(id, 1);
            list.add(id);
        }

    }

    public static void removePhoto() {

        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int studentNum = -1;

        for (int i = 0; i < list.size(); i++) {
            int id = list.get(i);
            int value = onBoard.get(id); // 리스트에 id 값의 추천횟수

            if (value < min) {
                minIdx = i;
                min = value;
                studentNum = id;
            }
        }

        onBoard.remove(studentNum);
        list.remove(minIdx);

    }
}
