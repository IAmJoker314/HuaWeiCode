import java.util.Scanner;

public class PictureSort34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String picture = scanner.nextLine();
            if(picture.equals("over")) break;
            int[] hashTable = new int [10 + 26 + 26];

            for (int i = 0; i < picture.length(); i++) {
                if(picture.charAt(i) >= '0' && picture.charAt(i) <= '9'){
                    hashTable[picture.charAt(i) - '0']++;
                } else if(picture.charAt(i) >= 'A' && picture.charAt(i) <= 'Z'){
                    hashTable[picture.charAt(i) - 'A' + 10]++;
                } else {
                    hashTable[picture.charAt(i) - 'a' + 10 + 26]++;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < hashTable.length; i++) {
                while (hashTable[i] > 0){
                    if(i >= 0 && i <= 9){
                        sb.append(i);
                    } else if(i >= 10 && i <= 35){
                        sb.append((char)(i - 10 + 'A'));
                    } else {
                        sb.append((char)(i - 10 - 26 + 'a'));
                    }
                    hashTable[i]--;
                }
            }

            System.out.println(sb.toString());

        }

    }
}
