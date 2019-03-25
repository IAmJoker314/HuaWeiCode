import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MingMingSurvey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            int countNum = scanner.nextInt();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < countNum; i++) {
                int tempInt = scanner.nextInt();
                if(!list.contains(tempInt))
                {
                    list.add(tempInt);
                }
            }

            Collections.sort(list);

            for (Integer in : list
                 ) {
                System.out.println(in);
            }
        }
    }
}
