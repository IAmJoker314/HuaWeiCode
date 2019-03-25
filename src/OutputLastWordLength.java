import java.util.Scanner;

public class OutputLastWordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tempStr = scanner.nextLine();
        String[] strList = tempStr.split(" ");
        System.out.println(strList[strList.length - 1].length());
    }
}
