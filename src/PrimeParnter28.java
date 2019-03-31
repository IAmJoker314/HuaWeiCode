import java.util.*;

public class PrimeParnter28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int inputNum = scanner.nextInt();
            List<Integer> oddList = new ArrayList<Integer>();
            List<Integer> evenList = new ArrayList<Integer>();

            for (int i = 0; i < inputNum; i++) {
                int tempInt = scanner.nextInt();
                if(tempInt % 2 == 0)
                    evenList.add(tempInt);
                else
                    oddList.add(tempInt);
            }

            int count = 0;
            int[] used = new int[evenList.size()];
            int[] parnterOfEven = new int[evenList.size()];

            for (int i = 0; i < oddList.size(); i++) {
                Arrays.fill(parnterOfEven, 0);
                if(check(oddList.get(i), evenList, used, parnterOfEven))
                    count++;
            }

            System.out.println(count);

        }

    }

    private static boolean check(Integer integer, List<Integer> evenList, int[] used, int[] parnterOfEven) {
        for (int i = 0; i < evenList.size(); i++) {
            if(isPrime(integer + evenList.get(i)) && used[i] == 0){
                used[i] = 1;
                if(parnterOfEven[i] == 0 || check(parnterOfEven[i], evenList, used, parnterOfEven)){
                    parnterOfEven[i] = integer;
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPrime(int i) {
        int sqr = (int)Math.sqrt(i);

        for (int j = 2; j <= sqr; j++) {
            if(i % j == 0) return false;
        }

        return true;
    }
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n=sc.nextInt();
            ArrayList<Integer> ji =new ArrayList<>();//存放奇数
            ArrayList<Integer> ou =new ArrayList<>();//存放偶数
            for(int i=0;i<n;i++){
                int x=sc.nextInt();
                if(x%2==0) ou.add(x);
                else ji.add(x);
            }
            int[] used = new int[ou.size()];
            int[] oushu = new int[ou.size()];
            int sum = 0;
            for(int i=0;i<ji.size();i++){
                Arrays.fill(used, 0);
                if(find(ji.get(i),ou,used,oushu)) sum++;
            }
            System.out.println(sum);
        }
    }
    private static boolean find(Integer x, ArrayList<Integer> ou, int[] used, int[] oushu) {
        for (int j=0;j<ou.size();j++){    //扫描每个数
            if (isprim(x+ou.get(j)) && used[j]==0)
            {
                //因为每次开始都又赋值为0，这里的used针对每组里面，怕返回去的时候又找到原来的
                used[j]=1;
                if (oushu[j]==0 || find(oushu[j],ou,used,oushu)) {
                    oushu[j]=x;
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isprim(Integer x) {
        int sum=0;
        for(int i=2;i<=Math.pow(x, 0.5);i++){
            if(x%i==0) return false;
        }
        return true;
    }*/

}