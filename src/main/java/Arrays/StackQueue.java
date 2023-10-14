package Arrays;

import java.util.Iterator;
import java.util.Stack;


public class StackQueue<T>{

    private Stack<T> pushStack;
    private Stack<T> popStack;
    public StackQueue(){ 
        pushStack = new Stack<>(); 
        popStack = new Stack<>(); 
    }


    public boolean empty(){ return pushStack.empty() && popStack.empty(); }
    public void add(T e){ pushStack.push(e); }

    public T peek(){
        if( this.empty() ){ throw new IllegalStateException("Empty Queue."); }

        if( popStack.empty() ){
            while( !pushStack.empty() ){ popStack.push( pushStack.pop() ); }
        }

        return popStack.peek();
    }

    public T poll(){
        if( this.empty() ){ throw new IllegalStateException("Empty Queue."); }

        if( popStack.empty() ){
            while( !pushStack.empty() ){ popStack.push( pushStack.pop() ); }
        }

        return popStack.pop();
    }
    
    public int search(T e){
        Stack<T> temp_pop = this.popStack;
        Stack<T> temp_push = this.pushStack;
        int indx = 0;

        while( !temp_pop.empty() ){
            if( temp_pop.pop().equals(e) ){ return indx; }
            indx++;
        }

        while( ! temp_push.empty() ){ temp_pop.push(temp_push.pop()); }
        while( !temp_pop.empty() ){
            if( temp_pop.pop().equals(e) ){ return indx; }
            indx++;
        }

        return -1;
    }
}
