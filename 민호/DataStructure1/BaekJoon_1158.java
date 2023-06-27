package 민호.DataStructure1;

import java.util.*;

public class BaekJoon_1158 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> aList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            aList.add(i + 1);
        }

        stringBuilder.append("<");
        while (!aList.isEmpty()) {
            if (aList.size() == 1) {
                stringBuilder.append(aList.get(0));
                break;
            }
            for (int i = 0; i < k; i++) {
                if (i != k - 1) {
                    aList.add(aList.get(0));
                    aList.remove(0);
                } else {
                    stringBuilder.append(aList.get(0)).append(", ");
                    aList.remove(0);
                }
            }
        }
        stringBuilder.append(">");
        System.out.println(stringBuilder);
        sc.close();
    }
}
