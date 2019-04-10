import java.util.ArrayList;
import java.util.Scanner;

public class InputAndOutput {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        Scanner scanner= new Scanner(System.in);
        int len = scanner.nextInt();
        int index = 0;
        int maxx = 0;
        while(scanner.hasNext()){
            String s = scanner.next();
            if(s.equals("over")) break;
            String[] array = s.split(",");
            int len1 = array.length;
            if(maxx<len1)
                maxx=len1;
            list.add(s);
        }

        while(index < maxx){
            for(int i=0;i<list.size();i++){
                String str = list.get(i);
                String[] array = str.split(",");
                int maxLen=array.length;
                int endLen=index+len;
                if(maxLen < endLen)
                    endLen = maxLen;
                for(int j=index;j<endLen;j++){
                    String out=array[j];
                    result.add(out);
                    result.add(",");
                    //System.out.print(out);
                    //if(j != maxx-1)
                    //System.out.print(",");
                }
            }
            index += len;
        }
        int rlen = result.size();
        result.remove(rlen-1);
        for(String a:result)
            System.out.print(a);

    }
}