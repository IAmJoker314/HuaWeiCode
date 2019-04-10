import java.util.*;


public class DeleteNodeInChain48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int nodeNum = scanner.nextInt();
            int headNode = scanner.nextInt();
            Stack<Integer> chainTable = new Stack<>();
            chainTable.push(headNode);
//            ChainNode nullHeadChainNode = new ChainNode(-1);
//            nullHeadChainNode.next = new ChainNode(headNode);

            for (int i = 0; i < nodeNum-1; i++) {
                int nextData = scanner.nextInt();
                int thisData = scanner.nextInt();
                chainTable = insertChainStack(thisData, nextData, chainTable);
            }

            int deleteNode = scanner.nextInt();
            chainTable = deleteChainStack(deleteNode, chainTable);
//            removeNode(deleteNode, nullHeadChainNode);
//
//            ChainNode outputChainNode = nullHeadChainNode.next;
//
//            while (outputChainNode.next != null){
//                System.out.print(outputChainNode.val+" ");
//                outputChainNode = outputChainNode.next;
//            }
//
//            System.out.print(outputChainNode.val+" ");

            List<Integer> list = new ArrayList<>(chainTable);

            for (Integer intger : list
                 ) {
                System.out.printf(intger+" ");
            }
            System.out.println("");
        }

    }

    private static Stack<Integer> deleteChainStack(int deleteNode, Stack<Integer> chainTable) {
        Stack<Integer> tempStack = new Stack<>();

        while (chainTable.peek() != deleteNode){
            tempStack.push(chainTable.peek());
            chainTable.pop();
        }

        chainTable.pop();

        while (!tempStack.isEmpty()){
            chainTable.push(tempStack.peek());
            tempStack.pop();
        }

        return chainTable;
    }

    private static Stack<Integer> insertChainStack(int thisData, int nextData, Stack<Integer> chainTable) {
        Stack<Integer> tempStack = new Stack<>();

        while (chainTable.peek() != thisData){
            tempStack.push(chainTable.peek());
            chainTable.pop();
        }

        chainTable.push(nextData);

        while (!tempStack.isEmpty()){
            chainTable.push(tempStack.peek());
            tempStack.pop();
        }

        return chainTable;
    }

    private static void removeNode(int deleteNode, ChainNode nullHeadChainNode) {
        ChainNode nodeNow = nullHeadChainNode;
        while (nodeNow.next != null){
            if(nodeNow.next.val == deleteNode){
                nodeNow.next = nodeNow.next.next;
            }
            nodeNow = nodeNow.next;
        }

    }


    private static void insertChainNode(int thisData, int nextData, ChainNode nullHeadChainNode) {
        ChainNode nodeNext = new ChainNode(nextData);
        ChainNode nodeNow = nullHeadChainNode;

        while (nodeNow != null){
            if(nodeNow.val == thisData){
                nodeNext.next = nodeNow.next;
                nodeNow.next = nodeNext;
                break;
            }
            nodeNow = nodeNow.next;
        }

    }

}

class ChainNode{
    int val;
    ChainNode next;

    ChainNode(int val){
        this.val = val;
    }
}
