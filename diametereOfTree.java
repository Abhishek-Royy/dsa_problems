public class diametereOfTree {

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

    // CALCULATE DIAMETERE

    static class TreeInfo{
        int height;
        int diameter;

        public TreeInfo(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
        
    }


    public static TreeInfo calculateDiametere(Node root){
        if(root==null){
            return new TreeInfo(0,0);
        }

        TreeInfo left=calculateDiametere(root.left);
        TreeInfo right=calculateDiametere(root.right);

        int myHeight=Math.max(left.height,right.height)+1;

        int diam1=left.diameter;
        int diam2=right.diameter;
        int diam3=left.height+right.height+1;

        int myDiam=Math.max(Math.max(diam1,diam2),diam3);


        TreeInfo myInfo=new TreeInfo(myHeight, myDiam);

        return myInfo;

    }

    public static void main(String[] args) {
        
         int node[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        Node tree=buildTree(node);

        System.out.println(calculateDiametere(tree).diameter);

    }
}
