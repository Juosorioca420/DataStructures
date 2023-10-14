package Arrays;

import java.util.Iterator;

import Arrays.utils.Index;
import Arrays.utils.List;
import Arrays.utils.Node;


public class LinkedList<T> implements List<T>{

    private int size; // # elementos
    private Node<T> head, tail;

    // Key -> Value
    // Next -> Pointer

    public LinkedList(){ 
        this.size = 0;
        this.head = null; this.tail = null;
    }


    // METHODS
    @Override
    public boolean isEmpty() { return this.size == 0; }

    @Override
    public void clear() {
        this.size = 0;
        this.head = null; this.tail = null;
    }

    @Override
    public boolean contains(T e) { 
        return this.indexOf(e) != -1; 
    }


    //   Getters
    @Override
    public int size() { return this.size; }

    @Override
    public int indexOf(T e) {
        int index = 0;
        Node<T> actual = this.head;

        while( actual != null ){
            if( actual.getKey().equals(e) ){ return index; }
            index++ ;
        }
        return -1;
    }

    @Override
    public T get(int index) throws Exception {
        if( index < 0 || index >= this.size ){
            throw new Exception("Index out of Range");
        }

        if(index == 0){ return this.head.getKey(); }
        if(index == this.size - 1){ this.tail.getKey(); }

        Node<T> actual = this.head;
        for (int i = 0; i < index; i++) { actual = actual.getNext(); }
        return actual.getKey();
    }


    //   Add
    @Override
    public void add(T e) throws Exception { this.add(this.size, e); }

    @Override
    public void add(int index, T e) throws Exception {
        if( index < 0 || index > this.size ){
            throw new Exception("Index out of Range");
        }

        // Set new node to add
        Node<T> nuevo = new Node<T>(e);


        if( index == 0 ){
            nuevo.setNext(this.head);
            this.head = nuevo;

            if( this.tail == null ){this.tail = this.head; }
        }
        else if( index == this.size ){
            this.tail.setNext(nuevo);
            this.tail = nuevo; // nuevo tiene Next = null por construccion
        }
        else{
            Node<T> prev = this.head;
            for( int i = 0; i < index-1; i++ ){ prev = prev.getNext(); }

            nuevo.setNext(prev.getNext());
            prev.setNext(nuevo);
        }

        this.size++;
    }


    //   Remove
    @Override
    public T remove(int index) throws Exception {
        Index.checkValidIndex(index, this.size);        

        Node<T> deleted = new Node<T>(null);
        Node<T> prev = this.head;

        if( index == 0 ){
            deleted = this.head; 

            this.head = this.head.getNext();
            if( this.head == null ){this.tail = null;}
        }

        else if( index == this.size - 1 ){ // first case covers if size=1
            deleted = this.tail;

            for( int i =  0; i < index; i++){prev = prev.getNext();}

            this.tail = prev;
            this.tail.setNext(null);
        }

        else{
            for( int i = 0; i < index-1; i++){ prev = prev.getNext(); }
            Node<T> current = prev.getNext();

            prev.setNext(current.getNext());
            deleted = current;
            
            current.setNext(null);
        }

        this.size--;
        return deleted.getKey();
    }

    @Override
    public boolean remove(T e) throws Exception {
        int index = this.indexOf(e);
        if( index == -1 ){return false;}

        this.remove(index);
        return true;
    }
    


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = LinkedList.this.head;

            @Override
            public boolean hasNext() { return current.getNext() != null; }

            @Override
            public T next() {
                T e = current.getKey();
                current = current.getNext();

                return e;
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (T e: this) {
            sb.append(e);
            sb.append(">");
        }
        if(sb.length() > 1){ sb.replace(sb.length() - 1, sb.length(), ""); }

        sb.append("]");
        return sb.toString();
    }
    
}
