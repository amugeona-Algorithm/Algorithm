package 준석.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20291 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String data = br.readLine();
            list.add(data.split("\\.")[1]); //"."으로 할경우 안도미
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (!isExistSameValue(map,list, i)) {
                map.put(list.get(i), 1);
            } else {
                int count = map.get(list.get(i));
                map.replace(list.get(i),count+1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        for(Map.Entry<String,Integer> entry: entryList){
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
    }

    static boolean isExistSameValue(Map<String, Integer> map, List<String> a,int i) {
        if (map.containsKey(a.get(i))) {
            return true;
        }
        return false;
    }

}
