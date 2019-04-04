import java.util.Scanner;

public class StringCode29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String codeStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String uncodeStr = "BCDEFGHIJKLMNOPQRSTUVWXYZAbcdefghijklmnopqrstuvwxyza1234567890";

        while (scanner.hasNext()){
            String needCode = scanner.nextLine();
            if(needCode.equals("over"))
                break;
            codePassWord(needCode, codeStr, uncodeStr);

            String needUnCode = scanner.nextLine();
            codePassWord(needUnCode, uncodeStr, codeStr);

        }

    }

    public static void codePassWord(String needCode, String nowStr, String changeStr){

        StringBuilder sbCode = new StringBuilder();
        for (int i = 0; i < needCode.length(); i++) {
            for (int j = 0; j < nowStr.length(); j++) {
                if(needCode.charAt(i) == nowStr.charAt(j)){
                    sbCode.append(changeStr.charAt(j));
                }
            }
        }

        System.out.println(sbCode.toString());

    }

}
