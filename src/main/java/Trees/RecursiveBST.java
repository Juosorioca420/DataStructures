package Trees;

import java.util.*;
import Trees.Utils.Tree;
import Trees.Utils.TreeNode;

public class RecursiveBST<T extends Comparable<T>> implements Tree<T> {

    protected TreeNode<T> root;

    public RecursiveBST(T data) { this.root = new TreeNode<>(data); }
    public RecursiveBST() { this.root = null; }



    @Override
    public boolean search(T data) { return this.search(this.root, data) != null; }

    private T search(TreeNode<T> root, T data) {
        if(root == null){ return null; }

        if ( root.getVal().compareTo(data) == 0 ){ return root.getVal(); }

        else if ( data.compareTo(root.getVal()) < 0 ){ return this.search(root.getLeft(),data); }
        else{ return this.search(root.getRight(), data); }
    }


    @Override
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



    @Override
    public void delete(T data) { this.root = this.delete(this.root, data); }

    private TreeNode<T> delete(TreeNode<T> root, T data) {
        if(root == null){ return root; }

        if(data.compareTo(root.getVal()) < 0) {
            root.setLeft(this.delete(root.getLeft(), data));
        }
        else if (data.compareTo(root.getVal()) > 0) {
            root.setRight(this.delete(root.getRight(), data));
        }

        else { // root.value == data

            // Single Child - Leaf  cases
            if( root.getLeft() == null ){ return root.getRight(); }
            else if( root.getRight() == null ){ return root.getLeft(); }

            // Two Children case
            root.setVal(this.minValue(root.getRight()));
            root.setRight(delete(root.getRight(), root.getVal())); // delete sucesor
        }
            return root;
    }



    @Override
    public void inOrder() { this.inOrder(this.root); }

    private void inOrder(TreeNode<T> root) {
        if(root == null){ return; }

        this.inOrder(root.getLeft());
        System.out.print(root.getVal() + " ");
        this.inOrder(root.getRight());
    }

    

    @Override
    public void preOrder() { this.preOrder(this.root); }

    private void preOrder(TreeNode<T> root) {
        if(root == null){ return; }

        System.out.print(root.getVal() + " ");
        this.preOrder(root.getLeft());
        this.preOrder(root.getRight());
    }



    @Override
    public void postOrder() { this.postOrder(this.root); }

    private void postOrder(TreeNode<T> root) {
        if(root == null){ return; }

        this.postOrder(root.getLeft());
        this.postOrder(root.getRight());
        System.out.print(root.getVal() + " ");
    }

    @Override
    public int height() { return this.height(this.root); }

    protected int height(TreeNode<T> root) {
        if(root == null){ return 0; }

        return 1 + Math.max( height(root.getLeft()), height(root.getRight()) );
    }



    @Override
    public int size() { return this.size(this.root); }

    private int size(TreeNode<T> root) {
        if(root == null){ return 0; }

        return 1 + size( root.getLeft() ) + size( root.getRight() );
    }



    @Override
    public T minValue() { return this.minValue(this.root); }

    protected T minValue(TreeNode<T> root) {
        if(root == null){ return null; }

        if(root.getLeft() == null){ return root.getVal(); }

        else{ return minValue(root.getLeft()); }
    }



    @Override
    public T maxValue() { return this.maxValue(this.root); }

    private T maxValue(TreeNode<T> root) {
        if(root == null){ return null; }

        if(root.getRight() == null){ return root.getVal(); }
        else{ return maxValue(root.getRight()); }
    }



    @Override
    public boolean isBalanced() { return this.isBalanced(this.root); }

    protected boolean isBalanced(TreeNode<T> root) {
        if(root == null){ return true; }

        int lh = this.height(root.getLeft());
        int rh = this.height(root.getRight());

        if( Math.abs(lh - rh) > 1 ){ return false; }

        return this.isBalanced(root.getLeft()) && this.isBalanced(root.getRight());
    }



    // Level Order
    @Override
    public String toString() { return this.toString(this.root); }

    private String toString(TreeNode<T> root) {

        Queue< TreeNode<T> > queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        if(root == null){ return "" ; }

        queue.add(root);
        level.add(0);
        StringBuilder sb = new StringBuilder();
        int preLevel = 0;

        while ( !queue.isEmpty() ){

            TreeNode<T> temp = queue.poll();
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
