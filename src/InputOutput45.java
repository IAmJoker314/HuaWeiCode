import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputOutput45 {
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            List<String> strList = new ArrayList<>();
            List<List<String>> charList = new ArrayList<>();
            String tempStr = scanner.nextLine();

            StringBuilder sb = new StringBuilder();

            int len = Integer.parseInt(tempStr);

            while (scanner.hasNext()){
                if (tempStr.equals("over")) break;
                if (!tempStr.contains(",")) break;
                if (tempStr.contains(",")) strList.add(tempStr);
                for (int i = 0; i < strList.size(); i++) {
                    List<String> tempStrList = Arrays.asList(strList.get(i).split(","));
                    charList.add(tempStrList);
                }

                for (int i = 0; i < charList.size(); i++) {
                    if(!charList.isEmpty()){
                        if(charList.get(i).size()>=3){
                            for (int j = 0; j < 3; j++) {
                                sb.append(charList.get(i).get(j)+",");
                            }

                            for (int j = 0; j < 3; j++) {
                                charList.get(i).remove(j);
                            }

                        } else {
                            for (int j = 0; j < charList.get(i).size(); j++) {
                                sb.append(charList.get(i).get(j)+",");
                            }

                            for (int j = 0; j < charList.get(i).size(); j++) {
                                charList.get(i).remove(j);
                            }

                        }

                    }
                }
            }

        }

*/
    }
}
