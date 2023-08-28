package 민호.Simulation;

import java.util.*;
import java.io.*;

public class BaekJoon_1713 {
    /**
     * 백준 1713
     * 시뮬레이션 - 후보 추천하기
     */


    static int N, M; //사진틀 개수, 추천 횟수
    static Map<Integer, Integer> pictureFrame;
    static int[] recommend; //추천받은 학생
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        pictureFrame = new LinkedHashMap<>(N);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        recommend = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            recommend[i] = Integer.parseInt(st.nextToken());
        }

        for (int studentNum : recommend) {
            post(studentNum);
        }

        for (int key : pictureFrame.keySet()) {
            result.add(key);
        }

        Collections.sort(result);

        for (int r : result) {
            System.out.print(r + " ");
        }

    }

    static void post(int i) {
        if (pictureFrame.size() < N) {        //사진틀에 N장의 사진이 전부 없는 경우
            if (!pictureFrame.containsKey(i))
                pictureFrame.put(i, 1);
            else
                pictureFrame.replace(i, pictureFrame.get(i) + 1);
        } else if (pictureFrame.size() == N) {  //사진틀에 N장의 사진이 전부 있는 경우
            if (!pictureFrame.containsKey(i)) {
                changePicture(i);
            } else
                pictureFrame.replace(i, pictureFrame.get(i) + 1);
        }
    }


    static void changePicture(int i) {
        int min = Collections.min(pictureFrame.values());   //가장 낮은 추천 횟수;

        Iterator<Integer> keys = pictureFrame.keySet().iterator();
        while (keys.hasNext()) {
            int key = keys.next();
            if (pictureFrame.get(key) == min) {
                pictureFrame.remove(key);
                break;
            }
        }
        pictureFrame.put(i, 1);
    }
}
