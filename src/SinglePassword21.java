
import java.util.Scanner;

public class SinglePassword21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String tempPassWord = scanner.nextLine();
            if(tempPassWord.equals("over"))
                break;

            outputRealPassWord(tempPassWord);

        }

    }

    private static void outputRealPassWord(String tempPassWord) {
        //System.out.println("in");
        String[] phoneWordList = {"", "", "abc", "def",
                                    "ghi", "jkl", "mno",
                                    "pqrs", "tuv", "wxyz"};

        String realPassWord="";

        for(int i = 0 ; i < tempPassWord.length(); i++){
            if(tempPassWord.charAt(i) >= 'a' && tempPassWord.charAt(i) <= 'z'){
                for (int j = 0; j < phoneWordList.length; j++) {
                    if(phoneWordList[j].contains(tempPassWord.charAt(i)+""))
                        realPassWord += j;
                }
            } else if(tempPassWord.charAt(i) >= 'A' && tempPassWord.charAt(i) <= 'Z'){
                if(tempPassWord.charAt(i) == 'Z')
                    realPassWord += "a";
                else
                    realPassWord += (char)(tempPassWord.charAt(i)-'A'+'a'+1)+"";
            } else {
                realPassWord += tempPassWord.charAt(i)+"";
            }

        }

        System.out.println(realPassWord);

    }
}
