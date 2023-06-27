package 민호.DataStructure2;

import java.util.*;

public class BaekJoon_14425 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;

        ArrayList<String> sList = new ArrayList<>(); //집합 S
        ArrayList<String> checkList = new ArrayList<>(); //검사해야 하는 문자열

        for (int i = 0; i < n; i++) {
            sList.add(sc.next());
        }

        for (int i = 0; i < m; i++) {
            checkList.add(sc.next());
        }

        for (String check : checkList) {
            for (String s : sList) {
                if (check.equals(s)) {
                    count++;
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
