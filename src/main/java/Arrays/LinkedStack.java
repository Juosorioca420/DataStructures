package Arrays;

import java.util.Iterator;
import Arrays.utils.Stack;


public class LinkedStack<T> extends Stack<T>{

    private LinkedList<T> list;
    public LinkedStack(){ this.list = null; };

    @Override
    public Iterator<T> iterator(){ return this.list.iterator(); }

    @Override
    public boolean empty(){ return this.list.size() == 0; }

    @Override
    public T peek() throws Exception{
        if( this.empty() ){ return null; }
        return this.list.get(0);
    }

    @Override
    public T pop() throws Exception {
        if( this.empty() ){ return null; }
        return this.list.remove(0);
    }

    @Override
    public void push(T e) throws Exception { // add
        this.list.add(0, e);
    }

    @Override
    public int search(T e) { return this.list.indexOf(e); }
    
}
