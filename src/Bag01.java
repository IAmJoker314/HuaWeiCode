import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bag01 {
    public static List<Integer> bestWay = new ArrayList<Integer>();
    public static int maxValue = 0;
    public static void main(String[] args) {
        int n = 5;
        int capacity = 10;
        int[] weight = {2, 6, 4, 1, 5};
        int[] value = {6, 9, 6, 1, 5};

        int[] tempWay = new int[n];

        int nowValue = 0;
        int nowWeight = 0;

        backTrace(0, nowWeight, nowValue, n, capacity, weight, value, tempWay);

//        System.out.println(bestWay.get(0));

        for (Integer chooseOrNot : bestWay
             ) {
            System.out.print(chooseOrNot+" ");
        }

    }

    private static void backTrace(int i, int nowWeight, int nowValue, int n, int capacity, int[] weight, int[] value, int[] tempWay) {
        if(i == n - 1){
            if(nowValue > maxValue){
                maxValue = nowValue;
                bestWay.clear();
                for (int j = 0; j < tempWay.length; j++) {
                    bestWay.add(tempWay[j]);
                }
            }
            return;
        }

        if(nowWeight+weight[i] <= capacity){
            nowValue += value[i];
            nowWeight += weight[i];
            tempWay[i] = 1;
            backTrace(i+1, nowWeight, nowValue, n, capacity, weight, value, tempWay);
            nowValue -= value[i];
            nowWeight -= weight[i];
            tempWay[i] = 0;
        }

        backTrace(i+1, nowWeight, nowValue, n, capacity, weight, value, tempWay);

    }


}
