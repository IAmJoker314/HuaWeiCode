import java.util.Scanner;

public class BallDrop38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            double startHeight = scanner.nextDouble();
            double totalHeight =  startHeight;
//            double up = 1;
//            double down = 32;
            double powX = 1.0 / 32.0;
//            System.out.println(powX);
            double upHeight = startHeight*powX;

            int count = 1;
            double tempHeight = startHeight / 2;
            while (count < 5){
                totalHeight += (tempHeight * 2);
                tempHeight /= 2;
                //System.out.println(tempHeight);
                count++;
            }

            System.out.println(totalHeight);
            System.out.println(upHeight);
        }
    }
}
