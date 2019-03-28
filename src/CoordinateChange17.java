import java.util.Scanner;

public class CoordinateChange17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext())
        {

            String inputStr = scanner.nextLine();
            String[] orderList = inputStr.split(";");
            int x = 0;
            int y = 0;

            for (int i = 0; i < orderList.length; i++) {
                if(orderList[i].matches("[ASWD]\\d{1,2}"))
                {
                    int orderNum = Integer.parseInt(orderList[i].substring(1));
                    if(orderList[i].charAt(0) == 'A')
                    {
                        x -= orderNum;
                    }
                    else if(orderList[i].charAt(0) == 'S')
                    {
                        y -= orderNum;
                    }
                    else if(orderList[i].charAt(0) == 'D')
                    {
                        x += orderNum;
                    }
                    else
                    {
                        y += orderNum;
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }
}
