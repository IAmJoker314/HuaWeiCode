import java.util.Scanner;

public class IntegerToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum = scanner.nextInt();
        String binaryNumStr = Integer.toBinaryString(inputNum);

        int count = 0;

        for (int i = 0; i < binaryNumStr.length(); i++) {
            if(binaryNumStr.charAt(i) == '1')
            {
                count++;
            }
        }

        System.out.println(count);

    }
}
