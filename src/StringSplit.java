import java.util.Scanner;

public class StringSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        splitStringInEight(str1);
        splitStringInEight(str2);


    }

    public static void splitStringInEight(String str)
    {
        int count = 0;

        for (int i = 0; i < str.length() - 8 ; i += 8) {
            System.out.println(str.substring(i, i + 8));
            count++;
        }

        if(str.length() != count * 8)
        {
            String lastOne = str.substring(count * 8, str.length());

            for (int i = lastOne.length(); i < 8; i++) {
                lastOne += "0";
            }

            System.out.println(lastOne);

        }
    }
}
