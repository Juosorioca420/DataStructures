package Arrays;

import java.util.Iterator;

import Arrays.utils.Queue;

public class LinkedQueue<T> extends Queue<T>{

    private LinkedList<T> list;
    public LinkedQueue(){ this.list = null; }

    @Override
    public Iterator<T> iterator(){ return this.list.iterator(); }

    @Override
    public boolean empty(){ return this.list.isEmpty(); }

    @Override
    public void add(T e) throws Exception{ this.list.add(e); }

    @Override
    public T peek() throws Exception {
        if( this.empty() ){return null;}
        return list.get(0);
    }

    @Override
    public T poll() throws Exception {
        if( this.empty() ){ return null;} 
        return list.remove(0);
    }

    @Override
    public int search(T e) { return list.indexOf(e); }
    
}
