import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LearnEnglish42 {

    public static String[] single = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    public static String[] teens = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen","seventeen", "eighteen", "nineteen" };
    public static String[] decede = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty","ninety"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            long needTransNum = scanner.nextLong();
            String outputStr = transFunc(needTransNum);
            System.out.println(outputStr.trim());
        }

    }

    public static String transFunc(long needTransNum) {
        StringBuilder sb = new StringBuilder();

        sb.append(threePos(needTransNum, 1000000000, " billion "));
        needTransNum %= 1000000000;
        sb.append(threePos(needTransNum, 1000000, " million "));
        needTransNum %= 1000000;
        sb.append(threePos(needTransNum, 1000, " thousand "));
        needTransNum %= 1000;
        sb.append(threePos(needTransNum, 1, ""));
        return sb.toString();
    }

    private static String threePos(long needTransNum, long i, String s) {
        StringBuilder sb = new StringBuilder();

        long num = needTransNum / i;

        if(num != 0){
            sb.append(trans(num) + s);
        }

        return sb.toString();
    }

    public static String trans(long num){
        StringBuilder sb = new StringBuilder();

        int th = (int)num / 100;

        if(th != 0) sb.append(single[th] + " hundred");

        int rest = (int)num % 100;

        int ten = rest / 10;

        if(ten != 0){
            if(th != 0)sb.append(" and ");
            if(ten >= 2){
                sb.append(decede[ten]);
                int sing = rest % 10;
                if(sing != 0) sb.append(" " + single[sing]);
            } else {
                sb.append(teens[rest - 10]);
            }
        } else {
            int sing = rest % 10;
            if(th != 0) sb.append(" and ");
            sb.append(single[sing]);
        }

        return sb.toString();
    }


}
