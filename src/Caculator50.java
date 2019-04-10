
import java.util.*;

public class Caculator50 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String strExpression = in.nextLine();
            String handledExpression = handleStr(strExpression);
//            System.out.println(handledExpression);
            List<String> postExpression = getPostExpression(handledExpression);
        }

    }

    private static List<String> getPostExpression(String handledExpression) {
        Stack<String> postExStack = new Stack<>();
        List<String> postExList = new ArrayList<>();

        for (int i = 0; i < handledExpression.length();) {
            if(handledExpression.charAt(i)>='0' && handledExpression.charAt(i)<='9'){
                StringBuilder sb = new StringBuilder();
                sb.append(handledExpression.charAt(i));
                while (i+1 < handledExpression.length() && handledExpression.charAt(i+1)>='0' && handledExpression.charAt(i+1)<='9'){
                    sb.append(handledExpression.charAt(i+1));
                    i++;
                }
                postExList.add(sb.toString());
            } else if(postExStack.empty() || postExStack.peek().equals("(")){
                postExStack.push(String.valueOf(handledExpression.charAt(i)));
            }
            else {
                if(checkPri(postExStack.peek(), String.valueOf(handledExpression.charAt(i)))){
                    if(handledExpression.charAt(i)==')'){
                        while (!postExStack.empty() && postExStack.peek() != "("){
                            postExList.add(postExStack.pop());
                        }
                        postExStack.pop();
                    } else {
                        while (!postExStack.empty() && checkPri(postExStack.peek(), String.valueOf(handledExpression.charAt(i)))){
                            postExList.add(postExStack.pop());
                        }
                        postExStack.push(String.valueOf(handledExpression.charAt(i)));
                    }
                } else {
                    postExStack.push(String.valueOf(handledExpression.charAt(i)));
                }
                i++;
            }

        }

        while (!postExStack.empty()){
            postExList.add(postExStack.pop());
        }

        return postExList;
    }

    private static boolean checkPri(String top, String now){
        if((top.equals("+")|| top.equals("-")) && (now.equals("+")|| now.equals("-")) ){
            return true;
        }

        if((top.equals("*")|| top.equals("/")) && (now.equals("+")|| now.equals("-") || now.equals("*") || now.equals("/") ) ){
            return true;
        }

        if(now.equals(")")) return true;

        return false;
    }

    private static String handleStr(String strExpression) {
        strExpression=strExpression.replace("[", "(");
        strExpression=strExpression.replace("{", "(");
        strExpression=strExpression.replace("]", ")");
        strExpression=strExpression.replace("}", ")");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strExpression.length(); i++) {
            sb.append(strExpression.charAt(i));
            if(strExpression.charAt(i) == '-'){
                if((i > 0 &&strExpression.charAt(i-1) == '(') || i == 0){
                    sb.insert(i,"0");
                }
            }
        }
        return sb.toString();
    }


}