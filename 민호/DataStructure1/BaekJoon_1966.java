package 민호.DataStructure1;

import java.util.*;

public class BaekJoon_1966 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt(); //테스트케이스 수

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); //문서의 개수
            int m = sc.nextInt(); //궁금한 문서
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                arrayList.add(sc.nextInt());
            }
            findOrder(sb, m, arrayList); //궁금한 문서의 인쇄 순서 찾기 로직
        }

        System.out.println(sb);
        sc.close();
    }

    private static void findOrder(StringBuilder sb, int m, ArrayList<Integer> arrayList) {
        int count = 0; //인쇄 횟수
        int max = getMax(arrayList, 0);

        while (true) {
            if (arrayList.get(0) != max && m != 0) {
                arrayList.add(arrayList.get(0));
                arrayList.remove(0);
                m--;
            } else if (arrayList.get(0) != max && m == 0) {
                arrayList.add(arrayList.get(0));
                arrayList.remove(0);
                m = arrayList.size() - 1;
            } else if (arrayList.get(0) == max && m != 0) {
                arrayList.remove(0);
                count++;
                m--;
                max = getMax(arrayList, 0);
            } else if (arrayList.get(0) == max && m == 0) {
                count++;
                break;
            }
        }
        sb.append(count).append("\n");
    }

    private static int getMax(ArrayList<Integer> arrayList, int max) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > max)
                max = arrayList.get(i);
        }
        return max;
    }
}
