import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassportCheck20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String passportStr = scanner.nextLine();
            if(passportStr.equals("over"))
                break;

            if(checkPassport(passportStr)){
                System.out.println("OK");
            }
            else {
                System.out.println("NG");
            }

        }


    }

    private static boolean checkPassport(String passportStr) {
        if(passportStr.length() <= 8){
            return false;
        }

        if(!checkTypeNum(passportStr)){
            return false;
        }

        if(!checkSubString(passportStr)){
            return false;
        }


        //不能有相同长度超2的子串重复

        return true;
    }

    private static boolean checkSubString(String passportStr) {

        for (int i = 0; i < passportStr.length() - 2; i++) {
            String subStr = passportStr.substring(i, i + 3);
            if(passportStr.substring(i + 1).contains(subStr))
                return false;
        }

        return true;
    }

    private static boolean checkTypeNum(String passportStr) {
        int typeCount = 0;
        String[] regex = {"[a-z]", "[A-Z]", "\\d", "[^a-zA-Z0-9]"};

        for (int i = 0; i < regex.length; i++) {
            Pattern pattern = Pattern.compile(regex[i]);
            Matcher m = pattern.matcher(passportStr);

            if(m.find())
                typeCount++;
        }

        return typeCount >= 3;
    }
}
