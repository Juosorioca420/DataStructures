import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TreeNode<T>{
    private T val;
    private TreeNode<T> left, right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null; this.right = null; 
    }

    public T getVal() { return val; }
    public void setVal(T val) { this.val = val; }

    public TreeNode<T> getLeft() { return left; }
    public void setLeft(TreeNode<T> left) { this.left = left; }

    public TreeNode<T> getRight() { return right; }
    public void setRight(TreeNode<T> right) { this.right = right; }

}
class BST< T extends Comparable<T> >{
    protected TreeNode<T> root;
    protected static int count = 0;

    public BST(T data){ this.root = new TreeNode<>(data); }
    public BST(){ this.root = null; }


    public void insert(T data) { this.root = this.insert(this.root, data); }
    private TreeNode<T> insert(TreeNode<T> root, T data) {
        if(root == null){ root = new TreeNode<>(data); }

        else if(data.compareTo(root.getVal()) < 0) {
            root.setLeft(this.insert(root.getLeft(), data));
        }
        else if(data.compareTo(root.getVal()) > 0) {
            root.setRight(this.insert(root.getRight(),data));
        }

        return root;
    }

    public TreeNode<T> ksmall(int k){ return this.ksmall(this.root, k); }
    private TreeNode<T> ksmall(TreeNode<T> node, int k){
        if( node == null ){ return null; }

        TreeNode<T> smaller = this.ksmall(node.getLeft(), k);
        if( smaller != null ){ return smaller; }

        count++;
        if( count == k ){ return node; }

        return this.ksmall(node.getRight(), k);
    }

    public TreeNode<T> findParent(T data) {
        TreeNode<T> prev = null, current = this.root;

        while (current != null) {
            int flag = data.compareTo( current.getVal() );

            if (flag == 0){ return prev; } 

            prev = current;
            if (flag < 0){ current = current.getLeft(); }             
            else{ current = current.getRight(); } 
        }

        return null;
    }
}


public class KsmallestNode {
    public static void main( String[] args ) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line = bf.readLine();
        String[] data = line.split(" ");

        BST<Integer> bst = new BST<>();
        for (String value : data) {
            int int_value = Integer.parseInt(value);
            bst.insert(int_value);
        }

        int k = Integer.parseInt( bf.readLine() );

        bf.close();

        TreeNode<Integer> small = bst.ksmall(k); int small_val = small.getVal();

        TreeNode<Integer> parent = bst.findParent(small_val); int parent_val;
        if( parent != null ){ parent_val = parent.getVal(); }
        else{ parent_val = -1; }

        System.out.println(small_val + " " + parent_val);
    }
}