package Arrays;

import java.util.Iterator;
import Arrays.utils.Queue;


public class ArrayQueue<T> extends Queue<T>{

    private Object[] list; 
    private int size, r, w;

    public ArrayQueue( int length ){
        this.list = new Object[length + 1]; // + buffer slot
        this.size = 0; this.r = 0; this.w = 0;
    }
    public ArrayQueue(){ this(10); }


    // METHODS
    @Override
    public boolean empty() { return this.size == 0; }

    @Override
    public void add(T e) throws Exception {
        int mod = (w+1) % list.length;

        if( mod == r ){ throw new Exception( "Maximun queue length reached" ); }

        this.list[w] = e;
        this.size++;

        w = mod;
    }

    @Override
    public int search(T e) {        
        int i = r, flag = 0, l = list.length;

        while( i%l != w  &&  flag < l ){
            if( list[i % l].equals(e) ){ return i - r; }
            i++; flag++;
        }

        return -1;
    }


    // Retrieves, but does not remove, the head of this queue.
    @Override
    public T peek() throws Exception {
        if( this.empty() ){ return null; }
        return (T) this.list[r];
    }


    // Retrieves and removes the head of this queue, or returns null if this queue is empty.
    @Override
    public T poll() throws Exception {
        if( this.empty() ){ return null; }
        
        T e = (T) this.list[r];
        this.list[r] = null;

        r = (r+1) % list.length;
        this.size--;

        if( r == w ){ r = 0; w = 0; }

        return e;
    }


    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            Object[] list = ArrayQueue.this.list;

            int length = ArrayQueue.this.list.length;
            int w = ArrayQueue.this.w;
            int i = ArrayQueue.this.r;

            @Override
            public boolean hasNext() { return (i % length) != w; }

            @Override
            public T next() {
                T e = (T) list[i % length];
                i++;

                return e;
            }
        };
    }
}
