import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long inputNum = scanner.nextLong();
        ArrayList<Integer> primeList = findPrime(inputNum);
        String primeFactor = getFrimeFactor(inputNum, primeList);
        System.out.println(primeFactor);

    }

    private static String getFrimeFactor(long inputNum, ArrayList<Integer> primeList) {
        String primeFactor = "";

        for (int i = 0; i < primeList.size(); i++) {
            if(inputNum % primeList.get(i) == 0)
            {
                while (inputNum % primeList.get(i) == 0)
                {
                    primeFactor += primeList.get(i) + " ";
                    inputNum /= primeList.get(i);
                }
            }
        }

        if(inputNum != 1)
        {
            primeFactor += inputNum +" ";
        }

        return primeFactor;
    }

    private static ArrayList<Integer> findPrime(long inputNum) {
        int sqr = (int)Math.sqrt(inputNum);
        ArrayList<Integer> primeList = new ArrayList<Integer>();

        for(int i = 2; i <= sqr; i++)
        {
            if(isPrime(i))
            {
                primeList.add(i);
            }
        }
        return primeList;
    }

    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if(i % j == 0)
            {
                return false;
            }
        }
        return true;
    }


}
