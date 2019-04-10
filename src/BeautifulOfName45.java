import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BeautifulOfName45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int num = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < num; i++) {
                String inputStr = scanner.nextLine();
                int[] hashTable = new int[26];

                for (int j = 0; j < inputStr.length(); j++) {
                    hashTable[inputStr.charAt(j)-'a']++;
                }

                Arrays.sort(hashTable);
                int sum = 0;
                int start = 26;
                for (int j = hashTable.length - 1; j >= 0; j--) {
                    if(hashTable[j] == 0) break;
                    sum += (hashTable[j] * start);
                    start--;
                }
                System.out.println(sum);
            }

        }

    }
}
