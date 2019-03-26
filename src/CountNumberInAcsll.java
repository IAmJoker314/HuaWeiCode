import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CountNumberInAcsll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        StringBuffer sb = new StringBuffer();
//        String outputStr = sb.append(inputStr).reverse().toString();
        Set<Character> set = new HashSet<Character>();

        TreeSet<String> treeSet = new TreeSet<String>();

        for (int i = 0; i < inputStr.length(); i++) {
            if(set.add(inputStr.charAt(i)) && inputStr.charAt(i) >= 0 && inputStr.charAt(i) >= 127)
            {
                set.add(inputStr.charAt(i));
            }
        }
        System.out.println(set.size());
    }
}
