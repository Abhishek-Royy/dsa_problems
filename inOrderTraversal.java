public class inOrderTraversal {

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

    public static Node buildTree(int node[]){
        index++;
        if(node[index]==-1){
            return null;
        }

        Node newNode=new Node(node[index]);

        newNode.left=buildTree(node);
        newNode.right=buildTree(node);
        return newNode;
    }

    // INORDER TRAVERSAL LOGIC
    public static void inOrderTraversal(Node root){
        // base case
        if(root==null){
            return;
        }
        // visit left
        inOrderTraversal(root.left);
        // print root
        System.out.print(root.data+"->");
        // visit right
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node tree=buildTree(node);

        inOrderTraversal(tree);
    }    
}
