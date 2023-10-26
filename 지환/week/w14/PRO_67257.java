package 지환.week.w14;

import java.util.ArrayList;
import java.util.List;

class PRO_67257 {
    public static long result = Long.MIN_VALUE;

    public static List<Long> numbers = new ArrayList<>();
    public static List<String> symbolList = new ArrayList<>();

    public static String[] symbols = {"+", "-", "*"};
    public static String[] output = new String[3];
    public static boolean[] visited = new boolean[3];


    public long solution(String expression) {
        String n = "";


        for (int i = 0; i < expression.length(); i++) {
            char exp = expression.charAt(i);
            if (exp == '+' || exp == '-' || exp == '*') {
                symbolList.add(exp + "");
                numbers.add(Long.parseLong(n));
                n = "";
            } else {
                n += exp;
            }
        }

        //마지막 숫자 넣기
        numbers.add(Long.parseLong(n));

        per(0, symbols.length);
        return result;
    }

    static void per(int depth, int r){
        if(depth == r){
            solve();
            return;
        }
        for (int i = 0; i < symbols.length; i++) {
            if(!visited[i]){
                visited[i]=true;
                output[depth] = symbols[i];
                per(depth + 1, r);
                visited[i] = false;
            }
        }
    }
    static void solve(){
        //우선순위로 저장해둔 연산자들을 리스트에 넣어줌
        List<String> tempSymbols = new ArrayList<>();
        tempSymbols.addAll(symbolList);

        List<Long> num = new ArrayList<>();
        num.addAll(numbers);

        for (int i = 0; i < output.length; i++) {
            String curOper = output[i];//현재 우선순위 연산자

            for (int j = 0; j < tempSymbols.size(); j++) {
                //현재 우선순위에 맞는 연산자인 경우
                if(tempSymbols.get(j).equals(curOper)){
                    long n1 = num.get(j);
                    long n2 = num.get(j + 1);
                    long tempResult = cal(n1, n2, curOper);

                    //숫자 제거

                    num.remove(j + 1);
                    num.remove(j);

                    //사용한 연산자 제거
                    tempSymbols.remove(j);

                    num.add(j, tempResult);

                    j--;// 연산자를 삭제 했으니 인덱스 하나 줄여서 반복문 사이즈에 맞게 돌도락함.
                }

            }

        }
        result = Math.max(result, Math.abs(num.get(0)));
    }

    static long cal(long n1, long n2, String o) {
        long result = 0;
        switch(o) {
            case "+" :
                result = n1 + n2;
                break;
            case "-" :
                result = n1 -n2;
                break;
            case "*" :
                result = n1 * n2;
                break;
        }

        return result;

    }

}