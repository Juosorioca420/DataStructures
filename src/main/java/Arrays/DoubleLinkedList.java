package Arrays;

import java.util.Iterator;

import Arrays.utils.DoubleNode;
import Arrays.utils.List;


public class DoubleLinkedList<T> implements List<T>{

    private int size;
    private DoubleNode<T> head, tail;


    public DoubleLinkedList() {
        this.size = 0;
        this.head = null; this.tail = null;
    }


    private static void checkValidIndex(int index, int length) throws Exception{
        if(index < 0 || index >= length){
            throw new Exception("Invalid Index: Index out of range.");
        }
    }


    // General Methods
    @Override
    public int size(){ return this.size; }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public void clear() {
        this.head = null; this.tail = null;
        this.size = 0;
    }

    @Override
    public T get(int index) throws Exception {
        DoubleLinkedList.checkValidIndex(index, this.size);

        if( index == 0 ){ return this.head.getValue(); }
        else if( index == this.size - 1 ){ return this.tail.getValue(); }

        
        DoubleNode<T> current = new DoubleNode<T>(null);
        int diff = (this.size - 1 - index);
        if( index > diff ){
            current = this.tail;
            //   int i = this.size-1; i > index; i--
            for( int i = 0; i < diff; i++ ){ current = current.getPrev(); }
        }
        else{
            current = this.head;
            for( int i = 0; i < index; i++ ){ current = current.getNext(); }
        }

        return current.getValue();
    }

    @Override
    public int indexOf(T e) { // Only one search direction to find first or last appearance.
        DoubleNode<T> currentHead = this.head;
        //DoubleNode<T> currentTail = this.tail;
        //int half = (int) this.size/2;

        for( int i = 0; i < this.size ; i++){
            if( currentHead.getValue().equals(e) ){ return i; }
            //if( currentTail.getValue().equals(e) ){ return this.size - (i+1); }

            currentHead = currentHead.getNext();
            //currentTail = currentTail.getPrev();
        }

        return -1;
    }

    @Override
    public boolean contains(T e) {
        int index = this.indexOf(e);
        return index != -1;
    }


    //   Add
    @Override
    public void add(T e) throws Exception { this.add(this.size, e); }

    @Override
    public void add(int index, T e) throws Exception {
        DoubleLinkedList.checkValidIndex(index, this.size + 1);

        DoubleNode<T> nuevo = new DoubleNode<T>(e);

        if( index == 0 ){
            nuevo.setNext(this.head);
            if( this.head != null ){this.head.setPrev(nuevo);}

            this.head = nuevo;

            if( this.tail == null ){ this.tail = this.head; }
        }
        else if( index == this.size ){
            nuevo.setPrev(this.tail);
            this.tail.setNext(nuevo);

            this.tail = nuevo;
        }
        else{
            DoubleNode<T> prev = this.head;
            for( int i = 0; i < index - 1 ; i++ ){ prev = prev.getNext(); }
            DoubleNode<T> current = prev.getNext();

            nuevo.setNext(current);
            nuevo.setPrev(prev);

            prev.setNext(nuevo);
            current.setPrev(nuevo);
        }

        this.size++;
    }


    //   Remove
    @Override
    public boolean remove(T e) throws Exception {
        int index = this.indexOf(e);
        if( index == -1 ){return false;}

        this.remove(index);
        return true;
    }

    @Override
    public T remove(int index) throws Exception {
        DoubleLinkedList.checkValidIndex(index, this.size);

        DoubleNode<T> deleted = new DoubleNode<T>(null);

        if (index == 0){
            deleted = this.head;

            this.head = this.head.getNext();
            this.head.setPrev(null);

            if(this.head == null){this.tail = null;}
        }
        else if(index == this.size - 1){
            deleted = this.tail;

            this.tail = this.tail.getPrev();
            this.tail.setNext(null);
        }
        else{
            DoubleNode<T> prev = this.head;
            for( int i = 0; i < index - 1; i++ ){ prev = prev.getNext(); }
            DoubleNode<T> current = prev.getNext();
            DoubleNode<T> after = current.getNext();

            deleted = current;

            prev.setNext(after);
            after.setPrev(prev);
        }

        this.size--;
        return deleted.getValue();
    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            DoubleNode<T> current = DoubleLinkedList.this.head;

            @Override
            public boolean hasNext() { return current != null; }

            @Override
            public T next() {
                T e = current.getValue();
                current = current.getNext();

                return e;
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder("[ ");

        for( T e : this){ 
            s.append(e);
            s.append(" <-> ");
        }
        int lastIndex = s.lastIndexOf("<");
        s.delete(lastIndex, lastIndex + 3);

        s.append("]");
        
        return s.toString().trim();
    }

}

