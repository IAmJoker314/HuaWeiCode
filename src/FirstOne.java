import java.util.Scanner;

public class FirstOne {
    public static int count = 0;
    public static void backTrace(int choocaleNum, int totalNum){
        if(choocaleNum == totalNum){
            count++;
        } else {

            for(int i = 1; i <= totalNum-choocaleNum; i++){
                backTrace(choocaleNum+i, totalNum);
            }

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();

            backTrace(5, num);

            System.out.println(count % 666666666);

            count = 0;
        }
    }

}
