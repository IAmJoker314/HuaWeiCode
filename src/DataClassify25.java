import java.util.*;

public class DataClassify25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //while (scanner.hasNext()){

            int N = scanner.nextInt();
            String[] I = new String[N];
            for (int i = 0; i < N; i++) {
                I[i] = scanner.next();
            }

            int M = scanner.nextInt();
            Map<Integer, Integer> mapR = new TreeMap<Integer, Integer>();
            for (int i = 0; i < M; i++) {
                mapR.put(scanner.nextInt(), 0);
            }

            int totalCount = 0;

            for (Map.Entry entry : mapR.entrySet()
                 ) {
                for (int j = 0; j < I.length; j++) {
                    if(I[j].contains(((Integer)entry.getKey()).toString())){
                        mapR.put((Integer) entry.getKey(), (Integer) entry.getValue() + 1);
                        totalCount++;
                    }
                }

            }

            int totalR = 0;

            for (Map.Entry entry : mapR.entrySet()
            ) {
                if((Integer)entry.getValue() != 0){
                    totalR++;
                }
            }

            StringBuilder sb = new StringBuilder();

            sb.append((totalCount + totalR) * 2);

            int index = 0;
            for (Map.Entry entry : mapR.entrySet()
            ) {
                if((Integer)entry.getValue() != 0){
                    sb.append(" "+ ((Integer)entry.getKey()).toString()+" "+(Integer) entry.getValue());
                    for (int j = 0; j < I.length; j++) {
                        if(I[j].contains(((Integer)entry.getKey()).toString())){
                            sb.append(" "+j+" "+I[j]);
                        }
                    }
                }
            }

            System.out.println(sb.toString());
        }

    //}
}
