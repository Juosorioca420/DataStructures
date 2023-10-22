import java.util.LinkedList;
import java.util.Queue;

class Node{
    public int key;
    public Node next;

    public Node(int key) {
        this.key = key;
        next = null;
    }
    public int getKey() {return key;}
    public void setKey(int key) {this.key = key;}
    public Node getNext() {return next;}
    public void setNext(Node next) { this.next = next;}

}
class TreeNode{
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null; this.right = null; 
    }
    public TreeNode(){};

    public int getVal() { return val; }
    public void setVal(int val) { this.val = val; }
    public TreeNode getLeft() { return left; }
    public void setLeft(TreeNode left) { this.left = left; }
    public TreeNode getRight() { return right; }
    public void setRight(TreeNode right) { this.right = right; }

}


public class fromListToBST {

    static TreeNode create(Node head, Node tail){
        if( head == null ){ return null; }
        if( head == tail ){ return null; }

        Node mitad = head, liebre = head;

        while( liebre != tail && liebre.getNext() != tail ){ 
            mitad = mitad.getNext();
            liebre = liebre.getNext().getNext();
        }

        TreeNode tree = new TreeNode( mitad.getKey() );
        tree.setLeft( create(head, mitad) );
        tree.setRight( create(mitad.getNext(), tail) );

        return tree;
    }


    public static void main( String[] args ){
        Node head = new Node(-10);
        head.next = new Node(-3);
        head.next.next = new Node(0);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(9);

        System.out.println();
        TreeNode tree = create(head, null);
        System.out.println( print(tree) );
    }


    static String print(TreeNode root) {

            Queue< TreeNode > queue = new LinkedList<>();
            Queue<Integer> level = new LinkedList<>();

            if(root == null){ return "" ; }

            queue.add(root);
            level.add(0);
            StringBuilder sb = new StringBuilder();
            int preLevel = 0;

            while ( !queue.isEmpty() ){

                TreeNode temp = queue.poll();
                int l = level.poll();


                if(preLevel != l) {
                    sb.append("\n"); preLevel = l;
                }
                sb.append(temp.getVal() + " ");


                if(temp.getLeft() != null) {
                    queue.add(temp.getLeft()); level.add(l + 1);
                }
                if(temp.getRight() != null) {
                    queue.add(temp.getRight()); level.add(l + 1);
                }

            }

            return sb.toString();
        }

}
