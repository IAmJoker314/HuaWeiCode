import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sudoku44 {
     public static int[][] sudokuArray = new int[9][9];
     public static boolean flag = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){


            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudokuArray[i][j] = scanner.nextInt();
                }
            }

            backTrace(new SudokuNode(0, 0), sudokuArray);

        }

    }

    private static void backTrace(SudokuNode su, int[][] sudokuArray){
        if(su.x == 8 && su.y == 9){
            if(flag == false){
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        System.out.printf(sudokuArray[i][j]+"");
                        if(j < 8) System.out.printf(" ");
                    }
                    System.out.println("");
                }
                flag = true;
            }
            //System.out.println("获得正确解");
            return;
        }

        if(su.y == 9){
            su.x++;
            su.y=0;
        }


        if(sudokuArray[su.x][su.y] == 0){
            for (int i = 1; i <= 9; i++) {
                if(checkColumn(sudokuArray, su, i) && checkRow(sudokuArray, su, i) && checkSquare(sudokuArray, su, i)){
                    sudokuArray[su.x][su.y] = i;
                    SudokuNode newSu = new SudokuNode(su.x, su.y+1);
                    backTrace(newSu, sudokuArray);
                    sudokuArray[su.x][su.y] = 0;
                }
            }
        } else {
            SudokuNode newSu = new SudokuNode(su.x, su.y+1);
            backTrace(newSu, sudokuArray);
        }

    }

    private static boolean checkSquare(int[][] sudokuArray,SudokuNode su, int i) {
        int startX = (su.x)/3*3;
        int startY = (su.y)/3*3;

        for (int j = startX; j < startX+3; j++) {
            for (int k = startY; k < startY+3; k++) {
                if(sudokuArray[j][k] == i){
                    return false;
                }
            }

        }

        return true;
    }

    private static boolean checkColumn(int[][] sudokuArray, SudokuNode su, int i) {
        for (int j = 0; j < 9; j++) {
            if(sudokuArray[j][su.y] == i){
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int[][] sudokuArray, SudokuNode su, int i) {
        for (int j = 0; j < 9; j++) {
            if(sudokuArray[su.x][j] == i){
                return false;
            }
        }
        return true;
    }
}

class SudokuNode{
    int x;
    int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    SudokuNode(int x, int y){
        this.x = x;
        this.y = y;
    }
}
