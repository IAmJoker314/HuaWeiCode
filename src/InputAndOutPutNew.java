import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputAndOutPutNew {
    public static int num = 0;
    public static int newNum = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        scanner.nextLine();
        String inputStr;
        List<String> strList = new ArrayList<>();
        List<List<String>> charList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean flagInt = false;
        while ((inputStr = scanner.nextLine()) != ""){
            if(inputStr.contains(",")){
                strList.add(inputStr);
                flagInt = true;
            } else {
                newNum = Integer.parseInt(inputStr);
                flagInt = false;
            }

            if(flagInt) continue;

            for (int i = 0; i < strList.size(); i++) {
                List<String> tempStrList = new ArrayList<>(Arrays.asList(strList.get(i).split(","))) ;
                charList.add(tempStrList);
            }

            int flag = 0;

            while (flag < charList.size()){
                for (int i = 0; i < charList.size(); i++) {
                    if(!charList.isEmpty()){
                        if(charList.get(i).size()>= num){
                            for (int j = 0; j < num; j++) {
                                sb.append(charList.get(i).get(j)+",");
                            }

                            int count = 0;
                            while (count < num){
                                charList.get(i).remove(0);
                                count++;
                            }

                        } else {
                            for (int j = 0; j < charList.get(i).size(); j++) {
                                sb.append(charList.get(i).get(j)+",");
                            }

                            charList.get(i).removeAll(charList.get(i));
                            flag++;
                        }

                    }
                }

            }

            String output = sb.toString();
            System.out.println(output.substring(0, output.length()-1));
            num = newNum;
            charList.clear();
            strList.clear();
            sb.setLength(0);

        }

    }
}
