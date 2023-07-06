package Algorithm.지환.backjoon.w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Back_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s2 = bufferedReader.readLine();
        int n = Integer.parseInt(s2);

        for (int i = 0; i < n; i++) {
            String[] s = bufferedReader.readLine().split(" ");
            int paperNum = Integer.parseInt(s[0]);
            int find = Integer.parseInt(s[1]);
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> indexQueue = new LinkedList<>();
            String[] s1 = bufferedReader.readLine().split(" ");
            Arrays.stream(s1).forEach(num -> queue.add(Integer.parseInt(num)));
            for (int j = 0; j < paperNum; j++) {
                indexQueue.add(j);
            }

            extracted(find, queue, indexQueue);

        }
    }

    private static void extracted(int find, Queue<Integer> queue, Queue<Integer> indexQueue) {
        int count = 1;
        while (!queue.isEmpty()) {
            int max = Collections.max(queue);
            int curValue = queue.poll();
            int curIndex = indexQueue.poll();
            if (curValue == max) {
                if (curIndex == find) {
                    System.out.println(count);
                    break;
                }
                count++;
            } else {
                queue.add(curValue);
                indexQueue.add(curIndex);
            }
        }
    }
}
