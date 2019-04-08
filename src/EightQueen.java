public class EightQueen {
     public static int[][] cheese = new int[8][8];
     public static int count = 0;
    public static void main(String[] args) {

        backTrace(0);

    }

    private static void backTrace(int row) {
        if(row > 7){
            System.out.println("------------------");
            System.out.println(count++);
            printCheese();
        } else {
            for (int i = 0; i < 8; i++) {
                if(cheese[row][i] == 0){
                    if(check(row, i)){
                        cheese[row][i] = 1;

                        backTrace(row+1);

                        cheese[row][i] = 0;
                    }
                }

            }
        }
    }

    private static boolean check(int row, int column) {
        for (int i = 0; i != column && i < 8; i++){
            if(1 == cheese[row][i]) return false;
        }

        for (int i = 0; i != row && i < 8; i++){
            if(1 == cheese[i][column]) return false;
        }
        
        //左上对角线
        for (int i=row-1, j=column-1; i>=0 && j>=0; i--,j--) {
            if(cheese[i][j] == 1) return false;
        }

        //右上对角线
        for (int i=row-1, j=column+1; i>=0 && j<8; i--,j++) {
            if(cheese[i][j] == 1) return false;
        }

        //右下对角线
        for (int i=row+1, j=column-1; i<8 && j>=0; i++,j--) {
            if(cheese[i][j] == 1) return false;
        }
        
        //左下对角线
        for (int i=row+1, j=column+1; i<8 && j<8; i++,j++) {
            if(cheese[i][j] == 1) return false;
        }
        
        return true;
    }

    private static void printCheese(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(cheese[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
