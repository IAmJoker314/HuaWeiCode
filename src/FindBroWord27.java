import java.util.*;

public class FindBroWord27 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int inputNum = scanner.nextInt();

            String[] wordArray = new String[inputNum];

            for (int i = 0; i < inputNum; i++) {
                wordArray[i] = scanner.next();
            }

            String findWord = scanner.next();

            int numOfBroWord = scanner.nextInt();

            List<String> broWordList = findBroWord(wordArray, findWord);

            System.out.println(broWordList.size());

            if(!broWordList.isEmpty() && broWordList.size() >= numOfBroWord){
                System.out.println(broWordList.get(numOfBroWord - 1));
            }

        }
    }

    public static List<String> findBroWord(String[] wordArray, String findWord){
        List<String> broWordList = new ArrayList<String>();
        char[] findWordArray = findWord.toCharArray();
        Arrays.sort(findWordArray);

        for(int i = 0; i < wordArray.length; i++){
            char[] tempStringArray = wordArray[i].toCharArray();
            Arrays.sort(tempStringArray);
            if(!wordArray[i].equals(findWord)){
                if(Arrays.equals(findWordArray, tempStringArray)){
                    broWordList.add(wordArray[i]);
                }
            }
        }

        Collections.sort(broWordList);

        return broWordList;
    }

}
