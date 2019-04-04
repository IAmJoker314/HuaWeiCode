import java.util.Scanner;

public class ReverseString31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String inputStr = scanner.nextLine();
            if(inputStr.equals("over")) break;

            String[] wordList = inputStr.split("[^a-zA-Z]+");
            StringBuffer sb = new StringBuffer();

            for (int i = wordList.length - 1; i >= 0; i--) {
                if(wordList[i] == null || wordList[i].equals("")) continue;
                sb.append(wordList[i]+" ");
            }

            System.out.println(sb.toString().trim());

        }

    }
}
