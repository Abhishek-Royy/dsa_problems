public class postOrderTraversal {

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


    // POSTORDER TRAVERSAL
    public static void postOrder(Node root){
        if(root==null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+"->");
    }


    public static void main(String[] args) {

           int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
           Node tree=buildTree(node);

           postOrder(tree);
        
    }    
}
