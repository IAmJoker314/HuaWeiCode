import java.util.*;

public class StringSort26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            String inputStr = scanner.nextLine();
            char[] s = inputStr.toCharArray();
            List<Character> list = new LinkedList<Character>();

            for (int i = 0; i < s.length; i++) {
                if(Character.isLetter(s[i])){
                    list.add(s[i]);
                }
            }

            /*Collections.sort(list, new Comparator<Character>(){
                @Override
                public int compare(Character o1, Character o2){
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });*/

            Collections.sort(list, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });

            StringBuilder sb = new StringBuilder();
            int listIndex = 0;
            for (int i = 0; i < s.length; i++) {
                if(Character.isLetter(s[i]) && listIndex < s.length){
                    sb.append(list.get(listIndex));
                    listIndex++;
                } else {
                    sb.append(s[i]);
                }

            }
            System.out.println(sb.toString());
        }

    }
}
