import java.util.*;

public class StringInTreeSet {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();


        for (int i = 0; i < count; i++) {
            String tempStr = scanner.nextLine();
            if(treeMap.containsKey(tempStr))
            {
                treeMap.put(tempStr, treeMap.get(tempStr) + 1);
            }
            else
            {
                treeMap.put(tempStr, 1);
            }
        }

        for (Map.Entry entry : treeMap.entrySet()
             ) {
            while ((Integer) entry.getValue() != 0)
            {
                System.out.println(entry.getKey());
                treeMap.put((String) entry.getKey(), (Integer) entry.getValue() - 1);
            }

        }

        Set<String> set = treeMap.keySet();

        for (String str : set
             ) {
            while (treeMap.get(str) != 0)
            {
                System.out.println(str);
                treeMap.put(str, treeMap.get(str) - 1);
            }
        }

    }

}



