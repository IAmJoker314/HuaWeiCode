import java.util.Scanner;

public class ApproximateValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double inputDouble = scanner.nextDouble();
        String inputStr = String.valueOf(inputDouble);
        String[] splitStr = inputStr.split("\\.");
        int approximateNum;
        if(splitStr[1].charAt(0) >= '0' && splitStr[1].charAt(0) <= '4')
        {
            approximateNum = (int)Math.floor(inputDouble);
        }
        else
        {
            approximateNum = (int)Math.ceil(inputDouble);
        }
        System.out.println(approximateNum);
    }
}
