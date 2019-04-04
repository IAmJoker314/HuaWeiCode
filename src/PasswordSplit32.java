import java.util.Scanner;

public class PasswordSplit32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String inputStr = scanner.nextLine();
            if(inputStr.equals("over")) break;
            System.out.println(manacher(inputStr));

            /*int len = inputStr.length();
            int[][] dp = new int[len][len];

            int maxLen = 1;
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
                if(i < len - 1){
                    if(inputStr.charAt(i) == inputStr.charAt(i + 1)){
                        dp[i][i+1] = 1;
                        maxLen = 2;
                    }
                }
            }

            for(int step = 3; step <= len; step++){
                for (int i = 0; i + step - 1 < len; i++) {
                    int j = i + step - 1;
                    if(inputStr.charAt(i) == inputStr.charAt(j) && dp[i+1][j-1] == 1){
                        dp[i][j] = 1;
                        if(step > maxLen) maxLen = step;
                    }
                }
            }
            System.out.println(maxLen);*/
        }
    }

    public static int manacher(String str){
        int count = 0;

        char[] oriCharArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append("#");

        for (int i = 0; i < str.length(); i++) {
            sb.append(oriCharArray[i]);
            sb.append("#");
        }

        char[] manacherCharArray = sb.toString().toCharArray();
        int[] radius = new int[manacherCharArray.length];
        int id = 0;
        int max = 0;

        for (int i = 0; i < manacherCharArray.length; i++) {
            if(max > i){
                radius[i] = Math.min(radius[id * 2 - i], max - i);
            } else {
                radius[i] = 1;
            }
            while (i - radius[i] >= 0 && i + radius[i] < manacherCharArray.length && manacherCharArray[i - radius[i]] == manacherCharArray[i + radius[i]]){
                radius[i]++;
            }
            if(i+radius[i] > max){
                id = i;
                max = i+radius[i];
            }

            count = Math.max(count, radius[i] - 1);
        }


        return count;
    }

}
