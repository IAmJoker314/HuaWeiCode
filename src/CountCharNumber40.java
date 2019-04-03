import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountCharNumber40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int[] countNum = new int[4];
            String[] regexArray = {"[a-zA-Z]", " ", "[0-9]", "[^0-9A-Za-z ]"};

            String string = scanner.nextLine();

            for (int i = 0; i < string.length(); i++) {
                for (int j = 0; j < regexArray.length; j++) {
                    if (String.valueOf(string.charAt(i)).matches(regexArray[j])){
                        countNum[j]++;
                    }

                }

            }

            for (int i = 0; i < countNum.length; i++) {
                System.out.println(countNum[i]);
            }


        }

    }
}
