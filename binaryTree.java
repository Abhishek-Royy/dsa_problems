public class binaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


    static int index=-1;
    // Build through preorder
    public static Node buildTree(int node[]){
        index++;

        if(node[index]==-1){
            return null;
        }
        // creaate node
        Node newNode=new Node(node[index]);

        // create left tree
        newNode.left=buildTree(node);

        // create right tree
        newNode.right=buildTree(node);



        return newNode;
    }



    public static void main(String[] args) {

        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,5,-1,-1};
        

        Node tree=buildTree(node);

        System.out.println(tree.data);

    }
}
