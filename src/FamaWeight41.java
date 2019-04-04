import java.util.*;

public class FamaWeight41 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int famaNum = scanner.nextInt();
            int[] famaWeight = new int[famaNum];
            int[] famaCount = new int[famaNum];

            for(int i = 0 ; i < famaNum; i++){
                famaWeight[i] = scanner.nextInt();
            }

            for(int i = 0 ; i < famaNum; i++){
                famaCount[i] = scanner.nextInt();
            }

            Set<Integer> set = new HashSet<Integer>();

            for(int i = 0; i <= famaCount[0]; i++){
                //System.out.println(famaWeight[0] * i);
                set.add(famaWeight[0] * i);
            }

//            System.out.println("-----------");

            for(int i = 1; i < famaNum; i++){
                List<Integer> list = new ArrayList<Integer>(set);

                for(int j = 0; j <= famaCount[i]; j++){
                    for(int k = 0; k < list.size(); k++){
                        //System.out.println(famaWeight[i]*j+list.get(k));
                        set.add(famaWeight[i]*j+list.get(k));
                    }
                }

            }

            System.out.println(set.size());

        }

    }
}
