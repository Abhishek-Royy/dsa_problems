
import java.util.LinkedList;
import java.util.Queue;



public class levelOrderTraversal {

    static class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int index=-1;

    public static Node buildTree(int node[]){
        index++;

        if(node[index]==-1){
            return null;
        }

        // create node
        Node newNode=new Node(node[index]);

        // left subtree
        newNode.left=buildTree(node);
        // right subtree
        newNode.right=buildTree(node);

        return newNode;
    }


    // here use Queue in the place of recursion
    public static void levelOrderTraversal(Node root){
        // base case
        if(root==null){
            return;
        }

        // crete a queue through collection frame work
        Queue <Node> queue=new LinkedList<>();
        
        // add the root in the queue
        queue.add(root);

        // run a loop until q is empty
        while(!queue.isEmpty()){
            // remove the first element
            Node current=queue.remove();

            // print the current remove element
            System.out.print(current.data+"->");

            // add the left  element of current in the queue
            if(current.left!=null){
                queue.add(current.left);
            }

            // add the right element of current in the queue
            if(current.right!=null){
                queue.add(current.right);
            }
        }

    }


    // count total number of Nodes in a tree
    public static int countNode(Node root){
        if(root==null){
            return 0;
        }
        int leftNodeCount=countNode(root.left);
        int rightNodeCount=countNode(root.right);

        return leftNodeCount+rightNodeCount+1;
    }


    // calculate total sum of all nodes
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }

        int leftNodesSum=sumOfNodes(root.left);
        int rightNodesSum=sumOfNodes(root.right);

        return leftNodesSum+rightNodesSum+root.data;
    }


    public static void main(String[] args) {

        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node tree=buildTree(node);

        levelOrderTraversal(tree);
        System.out.println();

        System.out.println(countNode(tree));

        System.out.println(sumOfNodes(tree));
        System.out.println();

    }
}
