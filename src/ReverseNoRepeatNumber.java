import java.util.Scanner;

public class ReverseNoRepeatNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.nextLine();
        int[] hashTable = new int[10];

        for (int i = inputNum.length() - 1; i >= 0; i--) {
            if('0' == inputNum.charAt(i) && i == inputNum.length() - 1)
            {
                continue;
            }

            if(hashTable[Integer.parseInt(inputNum.charAt(i)+"")] == 0)
            {
                System.out.print(inputNum.charAt(i));
                hashTable[Integer.parseInt(inputNum.charAt(i)+"")] = 1;
            }

        }

    }
}
