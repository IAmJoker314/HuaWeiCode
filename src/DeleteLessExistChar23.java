import java.util.Arrays;
import java.util.Scanner;

public class DeleteLessExistChar23 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String inputStr = scanner.nextLine();
            int[] hashTable = new int[26];
            for (int i = 0; i < inputStr.length(); i++) {
                hashTable[inputStr.charAt(i) - 'a']++;
            }

            int minExist = Integer.MAX_VALUE;

            for (int i = 0; i < hashTable.length; i++) {
                if(hashTable[i] < minExist && hashTable[i] > 0)
                    minExist = hashTable[i];
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < inputStr.length(); i++) {
                if(hashTable[inputStr.charAt(i) - 'a'] > minExist)
                    sb.append(inputStr.charAt(i));
            }

            System.out.println(sb.toString());
        }
    }
}
