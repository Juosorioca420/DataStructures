package Arrays;

import java.util.Iterator;
import Arrays.utils.Stack;

public class ArrayStack<T> extends Stack<T>{

    private Object[] list;
    private int size;
    
    public ArrayStack( int length ){
        this.list = new Object[length];
        this.size = 0;
    }
    public ArrayStack(){ this(10); }

    @Override
    public boolean empty() { return size == 0; }

    @Override
    public T peek() throws Exception {
        if( this.empty() ){ return null; }
        return (T) list[ this.size - 1 ];    
    }

    @Override
    public T pop() throws Exception {
        if( this.empty() ){ return null; }
        
        T e = (T) list[ this.size - 1 ];
        list[ --this.size ] = null;

        return e;
    }

    @Override
    public void push(T e) throws Exception { //add
        if( this.size == this.list.length ){ throw new Exception("Stack top reached"); }
        this.list[ this.size++ ] = e;    
    }

    @Override
    public int search(T e) {
        for( int i = this.size-1; i <= 0 ; i-- ){
            if( this.list[i].equals(e) ){ return this.size-1 - i; }
        }
        return -1;
    }
    


    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            Object[] list = ArrayStack.this.list;
            int i = ArrayStack.this.size - 1;

            @Override
            public boolean hasNext() { return i >= 0;}

            @Override
            public T next() { return (T) list[i--]; }
        };
    }

}

