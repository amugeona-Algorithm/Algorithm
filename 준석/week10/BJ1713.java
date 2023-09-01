package 준석.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1713 {
    static int N; //사진틀의 개수
    static int K; //총 추천횟수

    /*
    틀이 꽉차있으면 추천받은 횟수가 가장 적은 학생의 사진 삭제
    적은 횟수가 두명이상일 경우 오래된 사진 삭제
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        List<Student> studentList = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            int recommendedId = Integer.parseInt(input[i]);
            boolean alreadyExist = false;

            for (Student student : studentList) {
                //이미 있는 학생에게 추천받을 경우 -> COUNT늘리고 already처리
                if (student.studentId == recommendedId) {
                    student.count++;
                    alreadyExist = true;
                    break;
                }
            }

            if (!alreadyExist) {
                //사진틀 사이즈가 꽉 찼을 경우
                if (studentList.size() >= N) {
                    studentList.sort(Comparator.comparingInt((Student o) -> o.count) //count로 먼저 정렬하고
                            .thenComparingInt(o -> o.recommendedTime)); //recommendedTime으로 정렬
                    studentList.remove(0);
                }
                studentList.add(new Student(1, recommendedId, i)); //아닐 경우 추가
            }
        }

        // id로 정렬
        studentList.sort(Comparator.comparingInt(o -> o.studentId));

        for (Student student : studentList) {
            System.out.print(student.studentId + " ");
        }
    }
    static class Student {
        int count;
        int studentId;
        int recommendedTime;

        public Student(int count, int studentId, int recommendedTime) {
            this.count = count;
            this.studentId = studentId;
            this.recommendedTime = recommendedTime;
        }
    }
}
