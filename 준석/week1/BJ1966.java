package 준석.week1;

import java.util.*;
import java.util.stream.Collectors;

//https://www.acmicpc.net/problem/1966
public class BJ1966 {

    private Queue<Integer> queue;
    private List<Integer> indexList;
    private List<Integer> results;  // 결과를 저장할 리스트

    public BJ1966() {
        this.queue = new LinkedList<>();
        this.indexList = new ArrayList<>();
        this.results = new ArrayList<>();
    }

    public int setToPrintStandard() {
        Scanner scanner = new Scanner(System.in);
        int testCaseNumber = scanner.nextInt();
        scanner.nextLine();
        int curiousPaper = 0;
        for (int i = 0; i < testCaseNumber; i++) {
            String paperCountAndCuriousPaper = scanner.nextLine();
            String[] splitValue = paperCountAndCuriousPaper.split(" ");
            int paperCount = Integer.parseInt(splitValue[0]);
            curiousPaper = Integer.parseInt(splitValue[1]);

            queue.clear();
            indexList.clear();
            String paperValue = scanner.nextLine();
            splitValue = paperValue.split(" ");
            for (int j = 0; j < paperCount; j++) {
                queue.add(Integer.parseInt(splitValue[j]));
                indexList.add(j);
            }
            play(curiousPaper);
        }
        return curiousPaper;
    }
    public void play(int curiousPaper) {

        int count = 1;
        int curiousPaperValue = queue.stream().collect(Collectors.toList()).get(curiousPaper);

        while (!queue.isEmpty()) {
            int maxPriorityValue = Collections.max(queue);
            int value = queue.poll();
            int currentIndex = indexList.remove(0);

            if (value == maxPriorityValue) {
                if (value == curiousPaperValue && currentIndex == curiousPaper) {
                    results.add(count);
                    break;
                }
                count++;
            } else {
                indexList.add(currentIndex);

                queue.add(value);
            }
        }
    }

    public static void main(String[] args) {
        BJ1966 result = new BJ1966();
        result.setToPrintStandard();
        for(int i = 0; i< result.results.size(); i++) {
            System.out.println(result.results.get(i));
        }
    }
}
