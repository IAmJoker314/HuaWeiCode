import java.util.Scanner;

public class SnackMatrix35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int count = scanner.nextInt();
            int[][] matrix = new int[count + 1][count + 1];
            int index = 0;
            int insertNum = 1;

            while (index < count){

                int row = index;
                int column = 0;

                while (column <= index){
                    matrix[row][column] = insertNum++;
                    column++;
                    row--;
                }
                index++;
            }

            for (int i = 0; i <count; i++) {
                for (int j = 0; j < count; j++) {
                    if(matrix[i][j] != 0){
                        System.out.printf(matrix[i][j]+"");
                        if(matrix[i][j+1] != 0) System.out.printf(" ");
                    }
                }
                    System.out.println("");
            }

        }
    }

}
