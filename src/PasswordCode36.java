import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PasswordCode36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String passwordKey = scanner.nextLine().toUpperCase();
            if(passwordKey.equals("OVER")) break;
            String needChangePassword = scanner.nextLine();

            Set<Character> set = new LinkedHashSet<Character>();

            for (int i = 0; i < passwordKey.length(); i++) {
                set.add(passwordKey.charAt(i));
            }

//            System.out.println(set.size());

            for (int i = 0; i < 26; i++) {
                set.add((char)('A'+ i));
            }

//            System.out.println(set.size());

            /*for (Character ch : set
                 ) {
                System.out.print(ch);
            }

            System.out.println("");*/

            Character[] passwordKeyArray = new Character[set.size()];
            set.toArray(passwordKeyArray);

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < needChangePassword.length(); i++) {
                if(needChangePassword.charAt(i) == ' '){
                    sb.append(needChangePassword.charAt(i));
                } else {
                    int pos = Character.toUpperCase(needChangePassword.charAt(i)) - 'A';
                    //System.out.println(Character.toUpperCase(needChangePassword.charAt(i)) + ":"  + pos);
                    if(Character.isLowerCase(needChangePassword.charAt(i))){
                        sb.append(Character.toLowerCase(passwordKeyArray[pos]));
                    } else {
                        sb.append(passwordKeyArray[pos]);
                    }

                }


            }

            System.out.println(sb.toString());

        }

    }
}
