package org.example.week1;

import java.util.ArrayList;
import java.util.List;

//https://www.acmicpc.net/problem/1158
public class BJ1158 {

    private final int selectedNumber;
    private final int maxSize;

    public BJ1158(int maxSize, int selectedNumber) {
        this.selectedNumber = selectedNumber - 1;
        this.maxSize = maxSize;
    }

    public List<Integer> makeList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < maxSize; i++) {
            list.add(i + 1);
        }
        return list;
    }

    public int removeSelectedValue(List<Integer> list, int indexCount) {
        return list.remove(indexCount);
    }

    //인덱스가 max를 넘어가면 다시 첫번째로 돌리기 (원형큐 활용)
    public int connectToFirstIndex(List<Integer> list, int indexCount) {
        if (indexCount > list.size()) {
            return indexCount % list.size();
        }
        return indexCount;
    }

    public void playJosephusPermutation() {
        List<Integer> list = makeList();
        int indexCount = selectedNumber;
        System.out.print("<");
        while (list.size() > 0) {
            indexCount = connectToFirstIndex(list, indexCount);
            System.out.print(removeSelectedValue(list, indexCount));
            setToPrintStandard(list);
            indexCount += selectedNumber;
        }
        System.out.print(">");
    }

    public void setToPrintStandard(List<Integer> list) {
        if (list.size() > 0) {
            System.out.print(", ");
        }
    }

    public static void main(String[] args) {
        BJ1158 bj1158 = new BJ1158(7, 3);

        bj1158.playJosephusPermutation();
    }

}
