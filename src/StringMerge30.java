import java.util.Arrays;
import java.util.Scanner;

public class StringMerge30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String str1 = scanner.next();
            String str2 = scanner.next();

            String mergeStr = merge(str1, str2);

            System.out.println(mergeStr);
        }

    }

    private static String merge(String str1, String str2) {
        String tempStr = str1 + str2;

        StringBuilder sbOdd = new StringBuilder();
        StringBuilder sbEven = new StringBuilder();

        for (int i = 0; i < tempStr.length(); i++) {
            if(i % 2 == 0) sbOdd.append(tempStr.charAt(i));
            else sbEven.append(tempStr.charAt(i));
        }

        char[] oddArray = sbOdd.toString().toCharArray();
        char[] evenArray = sbEven.toString().toCharArray();

        Arrays.sort(oddArray);
        Arrays.sort(evenArray);

        char[] changedOddArray = change(oddArray);
        char[] changedEvenArray = change(evenArray);

        StringBuilder mergeSb = new StringBuilder();

        int indexEven = 0;
        int indexOdd = 0;

        for (int i = 0; i < tempStr.length(); i++) {
            if(i % 2 == 0) mergeSb.append(oddArray[indexOdd++]);
            else mergeSb.append(evenArray[indexEven++]);
        }

        return mergeSb.toString();
    }

    private static char[] change(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] >= 'a' && array[i] <= 'f'){
                int num = Integer.parseInt((array[i] - 'a')+"");
                array[i] = reverse(num + 10);
            } else if(array[i] >= 'A' && array[i] <= 'F'){
                int num = Integer.parseInt((array[i] - 'A')+"");
                array[i] = reverse(num + 10);
            } else if(array[i] >= '0' && array[i] <= '9'){
                int num = Integer.parseInt(array[i]+"");
                array[i] = reverse(num);
            }

        }

        return array;
    }

    private static char reverse(int num) {
        String tempBianryStr = "000" + Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        sb.append(tempBianryStr.substring(tempBianryStr.length() - 4));
        String reverseStr = sb.reverse().toString();
        int reverseNum = Integer.parseInt(reverseStr,2);

        if(reverseNum >= 0 && reverseNum <= 9) return (char) (reverseNum + '0');
        else return (char) (reverseNum - 10 + 'A');

    }
}//decfab
//5D37BF