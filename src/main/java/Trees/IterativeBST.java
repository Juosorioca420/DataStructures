package Trees;

import java.util.*;
import Trees.Utils.Tree;
import Trees.Utils.TreeNode;

public class IterativeBST<T extends Comparable<T>> implements Tree<T> {

    private TreeNode<T> root;

    public IterativeBST(T data) { this.root = new TreeNode<>(data); }
    public IterativeBST() { this.root = null; }


    @Override
    public boolean search(T data) {
        TreeNode<T> current = this.root;

        while (current != null) {
            int flag = data.compareTo( current.getVal() );

            if (flag == 0){ return true; } 

            else if (flag < 0){ current = current.getLeft(); }             
            else{ current = current.getRight(); } // data > current.val
        }

        return false;
    }



    @Override
    public void insert(T data) {
        TreeNode<T> nuevo = new TreeNode<>(data);

        // empty tree case
        if ( this.root == null ){ 
            this.root = nuevo; 
            return;
        }

        TreeNode<T> current = this.root;
        while(true){

            int flag = data.compareTo(current.getVal());

            if (flag < 0) { // data < current.val
                if (current.getLeft() == null) {
                    current.setLeft(nuevo); 
                    return;
                }
                current = current.getLeft();
            } 

            else { // data > current.val
                if (current.getRight() == null) {
                    current.setRight(nuevo); 
                    return;
                }
                current = current.getRight();
            }

        }

    }

    @Override
    public void delete(T data) {
        if( !this.search(data) ){ return; } // if invalid node, do nothing

        TreeNode<T> prev = null, current = this.root;

        // Find to delete Node
        int flag = data.compareTo(current.getVal());
        while (current != null && flag != 0){
            prev = current;

            if (flag < 0) { current = current.getLeft(); } 
            else { current = current.getRight(); }
            flag = data.compareTo(current.getVal());
        }


        // Single Child - Leaf  Cases
        if (current.getLeft() == null) { replace(current, current.getRight(), prev); } 
        else if (current.getRight() == null) { replace(current, current.getLeft(), prev); } 

        // Two Children Case
        else {

            // find the smaller in-order sucesor 
            TreeNode<T> sucesor_prev = null, sucesor = current.getRight();
            while( sucesor.getLeft() != null ){ 
                sucesor_prev = sucesor;
                sucesor = sucesor.getLeft();
            }

            // 'replace' current node with sucesor node
            current.setVal( sucesor.getVal() );

            // remove already replaced sucesor node
            if( sucesor_prev != null ){ sucesor_prev.setLeft(sucesor.getRight()); }
            else{ current.setRight(sucesor.getRight()); }

        }
    }
    private void replace(TreeNode<T> current, TreeNode<T> sucesor, TreeNode<T> prev) {
        if( prev == null ){ this.root = sucesor; } // single child root subcase

        else if( current == prev.getLeft() ){prev.setLeft(sucesor); }
        else{ prev.setRight(sucesor); }
    }



    @Override
    public T minValue() {
        if (root == null) { return null; }

        TreeNode<T> current = this.root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current.getVal();
    }

    @Override
    public T maxValue() {
        if (root == null) { return null; }

        TreeNode<T> current = this.root;
        while (current.getRight() != null) {
            current = current.getRight();
        }

        return current.getVal();
    }



    @Override
    public void inOrder() {
        if ( this.root == null) { return; }

        TreeNode<T> current = this.root;
        Stack< TreeNode<T> > stack = new Stack<>();

        while ( current != null || !stack.isEmpty() ){

            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            current = stack.pop();
            System.out.print(current.getVal() + " ");

            current = current.getRight();
        }
    }

    @Override
    public void preOrder() {
        if (this.root == null) { return; }

        Stack< TreeNode<T> > stack = new Stack<>();
        stack.push(this.root);

        while ( !stack.isEmpty() ){

            TreeNode<T> current = stack.pop();
            System.out.print(current.getVal() + " ");

            if (current.getRight() != null){ stack.push(current.getRight()); }
            if (current.getLeft() != null){ stack.push(current.getLeft()); }

        }
    }

    @Override
    public void postOrder() {
        if (this.root == null) { return; } // caso vacio

        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        
        stack1.push(this.root);
        TreeNode<T> current;

        // actualizar bajo el orden de aparicion en stack1; primero el hijo menor.
        // usar stack2 para invertir el orden de los hijos de cada nodo; ubicando el menor apilado sobre el mayor.
        while ( !stack1.isEmpty() ) {  
            current = stack1.pop();
            stack2.push(current);

            if (current.getLeft() != null) { stack1.push(current.getLeft()); }
            if (current.getRight() != null) { stack1.push(current.getRight()); }
        }

        // imprimir en el orden adecuado, apareciendo los menores primero
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().getVal() + " ");
        }
    }



    @Override
    public int height(){ return this.height(this.root); }
    // separar funciones para usar en isBalance()
    public int height(TreeNode<T> root) {
        if (root == null) { return 0; }

        int height = 0;
        TreeNode<T> current;

        Queue< TreeNode<T> > queue = new LinkedList<>();
        queue.add(root);

        // recorrer en "level-order" y añadir una unidad de altura por cada nivel
        while (true) {

            // queu -> all of the current nodes to consider
            int nodeCount = queue.size();

            // break if all previous nodes were leafs;  end of the tree reached
            if (nodeCount == 0){ return height; }

            // all the current nodes represent a new level of the tree
            height++; 

            // add all current nodes children (next level) to consider in the next iteration
            for (int i = 0; i < nodeCount; i++){
                current = queue.poll();
                
                if (current.getLeft() != null) { queue.add(current.getLeft()); }
                if (current.getRight() != null) { queue.add(current.getRight()); }
            }

        }
    }

    @Override
    public int size() {
        if( this.root == null ){ return 0; }

        int size = 0;
        Stack< TreeNode<T> > stack = new Stack<>();
        TreeNode<T> current = this.root;

        // recorrer todos los nodos izquierdos y luego todos los derechos
        while ( current != null || !stack.isEmpty() ) {

            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }

            current = stack.pop();
            size++;
            current = current.getRight();

        }

        return size;
    }



    @Override
    public boolean isBalanced() {
        // arbol vacio es equilibrado.
        if( this.root == null ){ return true; }

        TreeNode<T> current;
        Queue< TreeNode<T> > q = new LinkedList<>(); 
        q.add(this.root);
        
        // recorrer en level-order y verificar que todos los hijos cumplan AVL
        while( !q.isEmpty() ){
            current = q.poll();

            int lefth = this.height(current.getLeft()), righth = this.height(current.getRight());
            if( Math.abs(righth - lefth) > 1 ){ return false; }

            if( current.getLeft() != null ){ q.add(current.getLeft()); }
            if( current.getRight() != null ){ q.add(current.getRight()); }
        }


        return true; 
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
