import java.util.Scanner;

public class SodaBottle22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int totalEmptyBottle = scanner.nextInt();
            if(totalEmptyBottle == 0)
                break;

            int nowBottle = totalEmptyBottle;
            int nowDrink = 0;

            while (nowBottle > 1){
                nowDrink = nowDrink + (nowBottle / 3);
                nowBottle = (nowBottle % 3) + (nowBottle / 3);
                System.out.println("nowDrink:"+nowDrink+"nowBottle:"+nowBottle);
                if(nowBottle == 2){
                    nowDrink++;
                    nowBottle = 1;
                }
            }

            System.out.println(nowDrink);

        }

    }
}
