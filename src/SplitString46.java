import java.util.Scanner;

public class SplitString46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String inputStr = scanner.nextLine();
            int num = scanner.nextInt();
            scanner.nextLine();

            StringBuilder sb = new StringBuilder();
            int len = 0;
            for (int i = 0; i < inputStr.length() && len < num; i++) {
                char tempChar = inputStr.charAt(i);

                if((int) tempChar > 255){
                    if(len + 2 > num) break;
                    sb.append(tempChar);
                    len += 2;
                } else {
                    sb.append(tempChar);
                    len += 1;
                }

            }

            System.out.println(sb.toString());
        }

    }
}
