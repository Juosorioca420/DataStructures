package Trees.Utils;

public class TreeNode<T> {
    private T val;
    private TreeNode<T> left, right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null; this.right = null;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

}
