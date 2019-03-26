
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class IndexTreeMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();

        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        for (int i = 0; i < count; i++) {
            int tempKey = scanner.nextInt();
            int tempValue = scanner.nextInt();

            if(!treeMap.containsKey(tempKey))
            {
                treeMap.put(tempKey, tempValue);
            }
            else
            {
                int nowValue = treeMap.get(tempKey);
                nowValue += tempValue;
                treeMap.put(tempKey, nowValue);
            }
        }

        Set<Integer> set = treeMap.keySet();

        for (Integer intger : set
             ) {
            System.out.print(intger);
            System.out.printf(" ");
            System.out.print(treeMap.get(intger));
            System.out.println("");
        }

    }
}
