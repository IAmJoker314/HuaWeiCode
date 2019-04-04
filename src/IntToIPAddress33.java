
import java.util.Scanner;

public class IntToIPAddress33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String ipAddress = scanner.nextLine();
            String intAddress = scanner.nextLine();

            String[] splitIP = ipAddress.split("\\.");
            System.out.println( (Integer.parseInt(splitIP[0])<<24) | (Integer.parseInt(splitIP[1])<<16) | (Integer.parseInt(splitIP[2])<<8) | Integer.parseInt(splitIP[3]));

            long tempLong = Long.parseLong(intAddress);
            System.out.println(((tempLong & 0Xff000000)>>24) + "." + ((tempLong & 0X00ff0000)>>16) + "." + ((tempLong & 0X0000ff00)>>8) + "." + ((tempLong & 0X000000ff)));


            /*String changeIntAddress = changeToInt(ipAddress);
            System.out.println(changeIntAddress);
            String changeIpAddress = changeToIP(intAddress);
            System.out.println(changeIpAddress);*/
        }

    }

    private static String changeToInt(String ipAddress) {
        String[] ipSplit = ipAddress.split("\\.");
        String totalStr = "";

        for (int i = 0; i < ipSplit.length; i++) {
            int tempIp = Integer.parseInt(ipSplit[i]);
            String tempStr = Integer.toBinaryString(tempIp);
            tempStr = "0000000"+ tempStr;
            tempStr = tempStr.substring(tempStr.length() - 8);
            totalStr += tempStr;
        }

        long totalLong = Long.parseLong(totalStr, 2);
        return Long.toString(totalLong);
    }

    private static String changeToIP(String intAddress) {
        Long tempLong = Long.parseLong(intAddress);
        String totalStr = Long.toBinaryString(tempLong);

        for (int i = totalStr.length(); i < 32; i++) {
            totalStr = "0"+totalStr;
        }

        System.out.println(totalStr.length());

        StringBuilder sb = new StringBuilder();

        int index = 0;

        while(index + 8 <= totalStr.length()){
            System.out.println("index:"+index);
            String tempIP = totalStr.substring(index, index+8);
            int tempIntIp = Integer.parseInt(tempIP,2);
            sb.append(tempIntIp+".");
            index += 8;
        }

        return sb.toString().substring(0, sb.length()-1);
    }


}