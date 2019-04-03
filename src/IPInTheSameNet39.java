import java.util.Arrays;
import java.util.Scanner;

public class IPInTheSameNet39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String coverCode = scanner.next();
            String ip1 = scanner.next();
            String ip2 = scanner.next();

            if(checkIPAndCoverCode(coverCode, ip1, ip2)){
                String binaryCoverCode = tenToBinary1(coverCode);
                String binaryIp1 = tenToBinary(ip1);
                String binaryIp2 = tenToBinary(ip2);


                String netWork1 = changeNet(binaryIp1, binaryCoverCode);
                String netWork2 = changeNet(binaryIp2, binaryCoverCode);

                if (netWork1.equals(netWork2)) System.out.println(0);
                else System.out.println(2);

            } else {
                System.out.println(1);
            }

        }

    }

    private static String tenToBinary1(String coverCode) {
        String[] sArray = coverCode.split("\\.");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sArray.length; i++) {
            int tempNum = Integer.parseInt(sArray[i]);
            String binaryNum = Integer.toBinaryString(tempNum);
            binaryNum = "0000000" + binaryNum;
            binaryNum = binaryNum.substring(binaryNum.length()-8);
            sb.append(binaryNum);
        }
        return sb.toString();

    }

    private static String changeNet(String binaryIp, String coverCode) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < coverCode.length(); i++) {
            if(binaryIp.charAt(i) == coverCode.charAt(i) && binaryIp.charAt(i) == '1'){
                sb.append(1);
            } else sb.append(0);

        }

        return sb.toString();
    }

    private static String tenToBinary(String s) {
        String[] sArray = s.split("\\.");
        String[] s1Array = new String[4];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sArray.length; i++){
            s1Array[i] = sArray[i];
        }

        for (int i = sArray.length; i < s1Array.length; i++) {
            s1Array[i] = "0";
        }

        for (int i = 0; i < s1Array.length; i++) {
            int tempNum = Integer.parseInt(s1Array[i]);
            String binaryNum = Integer.toBinaryString(tempNum);
            binaryNum = "0000000" + binaryNum;
            binaryNum = binaryNum.substring(binaryNum.length()-8);
            sb.append(binaryNum);
        }
        return sb.toString();
    }

    private static boolean checkIPAndCoverCode(String coverCode, String ip1, String ip2) {
        if(!checkCorrectStr(ip1) || !checkCorrectStr(ip2)){
            return false;
        }

        if(!checkCorrectCoverCode(coverCode)){
            return false;
        }


        return true;
    }


    private static boolean checkCorrectCoverCode(String coverCode) {
        String[] coverCodeArray = coverCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        String[] coverCodeArray1 = new String[4];

        for (int i = 0; i < coverCodeArray.length; i++){
            coverCodeArray1[i] = coverCodeArray[i];
        }

        for (int i = coverCodeArray.length; i < coverCodeArray1.length; i++) {
            coverCodeArray1[i] = "0";
        }

        for (int i = 0; i < coverCodeArray1.length; i++) {
            int tempNum = Integer.parseInt(coverCodeArray1[i]);
            String binaryNum = Integer.toBinaryString(tempNum);
            binaryNum = "0000000" + binaryNum;
            binaryNum = binaryNum.substring(binaryNum.length()-8);
            sb.append(binaryNum);
        }

        int posFirstZero = sb.indexOf("0");
        int posLatOne = sb.indexOf("1");

        if(posFirstZero < posLatOne) return false;

        return true;
    }

    private static boolean checkCorrectStr(String string) {
        String[] ipArray = string.split("\\.");

        if(ipArray.length != 4) return false;

        for (int i = 0; i < ipArray.length; i++) {
            int tempIP = Integer.parseInt(ipArray[i]);
            //System.out.println(tempIP);
            if(tempIP < 0 || tempIP > 255) return false;
        }

        return true;
    }
}
