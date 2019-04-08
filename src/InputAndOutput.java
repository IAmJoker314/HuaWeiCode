import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputAndOutput {
    public static int nextInt = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tempStr;
        while ((tempStr = scanner.nextLine()) != null){
            int num = 0;
            if(!tempStr.contains(",")){
                if(nextInt == 0){
                    num = Integer.parseInt(tempStr);
                }
            } else {
                num = nextInt;
            }

                String inputStr;
                List<String> strList = new ArrayList<>();
                List<List<String>> charList = new ArrayList<>();
                StringBuilder sb = new StringBuilder();

                if((inputStr = scanner.nextLine()).contains(",")){
                    strList.add(inputStr);
                    while ((inputStr = scanner.nextLine()).contains(",")){
                        strList.add(inputStr);
                    }
                } else {
                    nextInt = Integer.parseInt(inputStr);
                }


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
            }
    }
}
