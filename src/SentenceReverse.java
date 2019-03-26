import java.util.Scanner;

public class SentenceReverse {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();

        String[] wordList = inputStr.split(" +");

        for(int i = wordList.length - 1; i >= 0; i--)
        {
            System.out.printf(wordList[i]);
            if(i > 0)
            {
                System.out.printf(" ");
            }
        }

    }
}
