import java.util.LinkedList;
import java.util.Queue;

class TreeNode<T> {
    public T val;
    public TreeNode<T> left, right;

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
class Tree{
    protected TreeNode<Integer> root;

    public Tree(int data){ this.root = new TreeNode<>(data); }
    public Tree(TreeNode<Integer> root){ this.root = root; }
    public Tree(){ this.root = null; }


    public String toString() { return this.toString(this.root); }
    private String toString(TreeNode<Integer> root) {

        Queue< TreeNode<Integer> > queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        if(root == null){ return "" ; }

        queue.add(root);
        level.add(0);
        StringBuilder sb = new StringBuilder();
        int preLevel = 0;

        while ( !queue.isEmpty() ){

            TreeNode<Integer> temp = queue.poll();
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


    public void insert(int data) { this.root = this.insert(this.root, data); }
    private TreeNode<Integer> insert(TreeNode<Integer> root, int data) {
        if(root == null){ root = new TreeNode<>(data); }

        else if( root.getVal() > data ) {
            root.setLeft(this.insert(root.getLeft(), data));
        }
        else if( root.getVal() < data ) {
            root.setRight(this.insert(root.getRight(),data));
        }

        return root;
    }


    public int rangeSum(int n, int m){ return this.rangeSum(this.root, n, m); }
    private int rangeSum( TreeNode<Integer> node, int n, int m){
        if( node == null ){ return 0; }

        int val = node.getVal(), sum = 0;
        if( n <= val && val <= m ){ sum += val; }

        if( val > n ){ sum += rangeSum(node.getLeft(), n, m); }
        if( val < m ){ sum += rangeSum(node.getRight(), n, m); }

        return sum;
    }

    public boolean evenOdd(){
        if( this.root == null ){return true;}
        
        int level = 0;
        Queue< TreeNode<Integer> > q = new LinkedList<>(); q.add(this.root);
        TreeNode<Integer> current, after;

        while( !q.isEmpty() ){

            int nodes = q.size();
            for( int i = 0; i < nodes; i++ ){

                current = q.poll(); after = q.peek();

                if( level % 2 == 0 ){
                    if( current.getVal() % 2 == 0 ){ return false; }
                    if( after != null ){
                        if( current.getVal() >= after.getVal() ){ return false; }
                    }
                }
                else{
                    if( current.getVal() % 2 == 1 ){ return false; }
                    if( after != null ){
                        if( current.getVal() <= after.getVal() ){ return false; }
                    }
                }

                if( current.getLeft() != null ){ q.add(current.getLeft()); }
                if( current.getRight() != null ){ q.add(current.getRight()); }
            }

            level ++;
        }

        return true;
    }
    
}

public class Trees{
    public static void main( String[] args ){
        Tree bst = new Tree();
        bst.insert(1); bst.insert(10); bst.insert(4); bst.insert(3);
        bst.insert(7); bst.insert(9); bst.insert(12); bst.insert(8);
        bst.insert(6); bst.insert(2);

        TreeNode<Integer> root1 = new TreeNode<>(1);
        root1.left = new TreeNode<>(8);
        root1.right = new TreeNode<>(4);
        root1.left.left = new TreeNode<>(3);
        root1.right.left = new TreeNode<>(7);
        root1.right.right = new TreeNode<>(9);
        Tree tree1 = new Tree(root1);


        int sum = bst.rangeSum(-10, 5);
        boolean evenOdd = tree1.evenOdd();


        System.out.println();
        System.out.println(tree1);
        System.out.println();

        System.out.println(sum);
        System.out.println(evenOdd);
    }
}
