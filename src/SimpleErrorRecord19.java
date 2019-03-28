import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//这道题明明他自己没表述清楚
public class SimpleErrorRecord19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        int count = 0;
        while (scanner.hasNext())
        {
            count++;
            String tempRecord = scanner.nextLine();
            if(tempRecord.equals("over"))
                break;
            String lineRecord = tempRecord.split(" +")[1];
            String absFileRecord = tempRecord.split(" +")[0];
            String[] fileRecord = absFileRecord.split("\\\\");
            String lastFileRecord = fileRecord[fileRecord.length - 1];
            if(lastFileRecord.length() > 16)
                lastFileRecord = lastFileRecord.substring(lastFileRecord.length() - 16);

            lastFileRecord += (" " + lineRecord);

            if(map.containsKey(lastFileRecord)){
                map.put(lastFileRecord, map.get(lastFileRecord) +1);
            }
            else {
                map.put(lastFileRecord, 1);
            }

            if(map.size() > 8)
            {
                Map.Entry<String,Integer> entry = map.entrySet().iterator().next();
                map.remove(entry.getKey());
            }

        }

        for (Map.Entry<String, Integer> entry : map.entrySet()
             ) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
