import java.util.Scanner;

public class RabbitCount37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int month = scanner.nextInt();
            int count = countRabbit(month);
            System.out.println(count);
        }

    }

    private static int countRabbit(int month) {

        if(month == 1 || month == 2){
            return 1;
        }

        return countRabbit(month - 1) + countRabbit(month - 2);
    }
}
