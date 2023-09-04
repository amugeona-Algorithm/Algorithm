package 지환.backjoon.w10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Back_1713 {
    /*
    백준 1713
    후보 추천하기
    실버 1
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;

    private static List<Pic> pics = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            int student = Integer.parseInt(stringTokenizer.nextToken());

            //사진 수가 다 안찼거나, 학생이 없으면
            if (!hasStudent(student) && pics.size() < N) {
                pics.add(new Pic(1, student));
                pics.stream().forEach(pic -> pic.time++);
                Collections.sort(pics);
            } else { // 삭제후 추가 혹은 카운ㄴ트
                if (hasStudent(student)) {
                    pics.forEach(pic -> {
                        if (pic.id == student) {
                            pic.count++;
                        }
                    });
                    Collections.sort(pics);
                    continue;
                }
                //젤 적은거 제거
                Collections.sort(pics);
                pics.remove(0);
                pics.add(new Pic(1, student));
                pics.stream().forEach(pic -> pic.time++);
            }
        }
        Collections.sort(pics);
        List<Integer> objects = new ArrayList<>();
        for (Pic number : pics) {
            objects.add(number.id);
        }
        Collections.sort(objects);
        for (int a : objects) {
            System.out.printf(a + " ");
        }
    }

    private static boolean hasStudent(int student) {
        return pics.stream()
                .anyMatch(pic -> pic.id == student);
    }

    static class Pic implements Comparable<Pic> {
        int count;
        int id;
        int time;

        public Pic(int count, int id) {
            this.count = count;
            this.id = id;
        }

        @Override
        public int compareTo(Pic o) {
            if (this.count > o.count) {
                return 1;
            } else if (this.count < o.count) {
                return -1;
            } else {
                return o.time - this.time;
            }
        }
    }
}