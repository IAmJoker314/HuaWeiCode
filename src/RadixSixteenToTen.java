import java.util.Scanner;

public class RadixSixteenToTen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {
            String tempStr = scanner.nextLine().substring(2);
            System.out.println(tempStr);
            int tempNum = 0;

            for (int i = 0; i < tempStr.length(); i++) {
                if(tempStr.charAt(i) >= '0'  && tempStr.charAt(i) <= '9')
                {
                    tempNum = tempNum * 16 + (tempStr.charAt(i) - '0');
                }
                else if(tempStr.charAt(i) >= 'A' && tempStr.charAt(i) <= 'Z')
                {
                    tempNum = tempNum * 16 + (tempStr.charAt(i) - 'A' + 10);
                }
            }
            System.out.println(tempNum);
        }
    }
}
