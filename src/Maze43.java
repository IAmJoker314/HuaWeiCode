import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Maze43 {
    public static void fun(int[][] map,int m,int n){
        int[][] visit = new int[m][n];
        int[][] dir = {{1, 0}, {0, 1}};

        int max=0;
        Stack<Node> queue = new Stack<Node>();

        Stack<Node> st = new Stack<Node>();
        Node in = new Node(0,0);
        st.push(in);
        while(st.size()>0){
            Node top = st.peek();
            if(top.x==m-1&&top.y==n-1){
                //记录一条路径
                if(max<st.size()){
                    max=st.size();
                    queue.clear();
                    Queue<Node> temp = new LinkedList<Node>();
                    while(st.size()>0){
                        temp.offer(st.peek());
                        queue.push(st.pop());
                    }
                    while(temp.size()>0){
                        st.push(temp.poll());
                    }
                }
                st.pop();
            }
            else{
                Node n1 = new Node(top.x+dir[0][0],top.y+dir[0][1]);
                Node n2 = new Node(top.x+dir[1][0],top.y+dir[1][1]);
                boolean tag=false;
                if(n1.x<m&&n1.y<n&&map[n1.x][n1.y]==0&&visit[n1.x][n1.y]!=1){
                    st.push(n1);
                    visit[n1.x][n1.y]=1;
                    tag=true;
                }
                if(n2.x<m&&n2.y<n&&map[n2.x][n2.y]==0&&visit[n2.x][n2.y]!=1&&tag==false){
                    st.push(n2);
                    visit[n2.x][n2.y]=1;
                    tag=true;
                }
                if(tag==false){
                    st.pop();
                }
            }
        }

        while(queue.size()>0){
            Node top = queue.pop();
            System.out.println("("+top.x+","+top.y+")");
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int map[][] = new int[M][N];
            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = sc.nextInt();
                }
            }
            fun(map,M,N);
        }
    }

    public static class Node{
        int x;
        int y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
