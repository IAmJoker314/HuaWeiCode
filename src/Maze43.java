import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;
        import java.util.Stack;

public class Maze43 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            int[][] maze = new int[row][column];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }

            int[][] isVisited = new int[row][column];
            int[][] move = {{1, 0}, {0, 1},{-1, 0}, {0, -1}};
            int startX = 0;
            int startY = 0;
            Node startNode = new Node(0, 0);
            Node endNode = new Node(row-1,column-1);

            Stack<Node> stack = new Stack<Node>();
            List<List<Node>> path = new ArrayList<List<Node>>();
            List<Node> bestPath = new ArrayList<>();

            isVisited[0][0] = 1;

            stack.push(startNode);

            while (!stack.empty()){
                Node now = stack.peek();
                boolean flag = false;

                if(now.x == endNode.x && now.y == endNode.y){
                    path.add(stack);
                    break;
                } else {
                    for (int i = 0; i < 4; i++) {
                        Node newNode = new Node(now.x+move[i][0], now.y+move[i][1]);

                        if(newNode.x >= 0 && newNode.x < row && newNode.y >= 0 && newNode.y < column && isVisited[newNode.x][newNode.y] == 0 && maze[newNode.x][newNode.y] == 0){
                            stack.push(newNode);
                            isVisited[newNode.x][newNode.y] = 1;
                            flag = true;
                            break;
                        }
                    }
                    if(flag) continue;
                    stack.pop();
                }
            }

            int minPath = 10000;
            for (List<Node> list : path
                 ) {
                if(list.size() < minPath){
                    bestPath = list;
                    minPath = list.size();
                }
            }

            for (Node node : bestPath
                 ) {
                System.out.println("("+node.x+","+node.y+")");
            }

        }

    }

}

class Node{
    int x;
    int y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}