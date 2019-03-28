import java.util.Scanner;

public class ValidIpAddress18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] countArray = new int[7];

        while (scanner.hasNext())
        {
            String tempIpAndCode = scanner.next();
            if(tempIpAndCode.equals("over"))
                break;
            String ip = tempIpAndCode.split("~")[0];
            String code = tempIpAndCode.split("~")[1];

            String[] ipList = ip.split("\\.");
            String[] codeList = code.split("\\.");

            //System.out.println(ip + ":" + code);

            if(!checkRightIpAndCode(ipList, codeList))
            {
                countArray[5]++;
                continue;
            }


            if(check(ipList) >= 0 && check(ipList) <= 4)
                countArray[check(ipList)]++;

            if(checkPrivateIp(ipList))
                countArray[6]++;
        }

        for (int i = 0; i < countArray.length; i++) {
            System.out.print(countArray[i]);
            if(i < countArray.length - 1) System.out.printf(" ");
        }

    }

    private static boolean checkPrivateIp(String[] ipNum) {
        //System.out.println(ipNum[0] + ipNum[1]);
        int firstIp = Integer.parseInt(ipNum[0]);
        int seccondIp = Integer.parseInt(ipNum[1]);

        if(firstIp == 10 || (firstIp == 172 && seccondIp >= 16 && seccondIp <= 31) || (firstIp == 192 && seccondIp == 168 ) )
            return true;
        return false;
    }

    private static int check(String[] ipNum) {
        int firstIp = Integer.parseInt(ipNum[0]);

        if(firstIp >= 1 && firstIp <= 126) {
            return 0;
        }
        else if(firstIp >= 128 && firstIp <= 191){
            return 1;
        }
        else if(firstIp >= 192 && firstIp <= 223){
            return 2;
        }
        else if(firstIp >= 224 && firstIp <= 239){
//            for (String str : ipNum
//                 ) {
//                System.out.printf(str+".");
//            }
//            System.out.println("");
            return 3;
        }
        else if(firstIp >= 240 && firstIp <= 255){
            return 4;
        }
        return -1;
    }


    private static boolean checkRightIpAndCode(String[] ipList, String[] codeList) {

        if(!checkIpOrCode(ipList)){
            //System.out.println("ip false");
            return false;
        }

        if(!checkIpOrCode(codeList)){
            //System.out.println("code false");
            return false;
        }

        StringBuffer sb = new StringBuffer();

        for (String str : codeList
             ) {
            int tempValue = Integer.parseInt(str);
            String binaryStr = Integer.toBinaryString(tempValue);

            int lackOfZero = 8 - binaryStr.length();

            for (int i = 0; i < lackOfZero; i++) {
                sb.append("0");
            }
            sb.append(Integer.toBinaryString(tempValue));
        }

        int zeroIndex = sb.indexOf("0");
        int lastOneIndex = sb.lastIndexOf("1");

        if(lastOneIndex > zeroIndex)
            return false;

        return true;
    }

    private static boolean checkIpOrCode(String[] list) {
        if(list.length != 4)
            return false;

        for (int i = 0; i < list.length; i++) {
            if(list[i].equals("") || Integer.parseInt(list[i]) < 0 || Integer.parseInt(list[i]) > 255)
                return false;
        }
        return true;
    }
}
