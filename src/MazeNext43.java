import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeNext43 {
    public static List<List<Node>> path = new ArrayList<>();
    public static List<Node> bestPath = new ArrayList<>();
    public static List<Node> tempPath = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            int[][] maze = new int[row][column];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }

            int[][] isVisted = new int[row][column];

            Node startNode = new Node(0, 0);
            tempPath.add(startNode);
            backTrace(startNode, maze, isVisted, row, column);

            int minPath = 10000;

            for (List list : path
                 ) {
                if(list.size()<minPath){
                    minPath = list.size();
                    bestPath = new ArrayList<>(list);
                }
            }

            for (Node node : bestPath
                 ) {
                System.out.println("("+node.x+","+node.y+")");
            }

        }
    }

    private static void backTrace(Node startNode, int[][] maze, int[][] isVisted, int row, int column) {
        isVisted[startNode.x][startNode.y] = 1;
        if(startNode.x == row - 1 && startNode.y == column - 1){
            path.add(new ArrayList<>(tempPath));
            return;
        }
        Node newNode = new Node(startNode.x, startNode.y);

        if(startNode.x + 1 >= 0 && startNode.x + 1 < row && isVisted[startNode.x + 1][startNode.y] == 0 && maze[startNode.x + 1][startNode.y] == 0){
            newNode = new Node(startNode.x+1, startNode.y);
            tempPath.add(newNode);
            backTrace(newNode, maze, isVisted, row, column);
        }

        if(startNode.x - 1 >= 0 && startNode.x - 1 < row && isVisted[startNode.x - 1][startNode.y] == 0 && maze[startNode.x - 1][startNode.y] == 0){
            newNode = new Node(startNode.x-1, startNode.y);
            tempPath.add(newNode);
            backTrace(newNode, maze, isVisted, row, column);
        }

        if(startNode.y - 1 >= 0 && startNode.y - 1 < row && isVisted[startNode.x][startNode.y-1] == 0 && maze[startNode.x][startNode.y-1] == 0){
            newNode = new Node(startNode.x, startNode.y-1);
            tempPath.add(newNode);
            backTrace(newNode, maze, isVisted, row, column);
        }

        if(startNode.y + 1 >= 0 && startNode.y + 1 < column && isVisted[startNode.x][startNode.y+1] == 0 && maze[startNode.x][startNode.y+1] == 0){
            newNode = new Node(startNode.x, startNode.y+1);
            tempPath.add(newNode);
            backTrace(newNode, maze, isVisted, row, column);
        }
        isVisted[newNode.x][newNode.y] = 0;
        tempPath.remove(tempPath.size() - 1);

    }
}

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
