package Arrays;

import java.util.Iterator;

import Arrays.utils.Index;
import Arrays.utils.List;


public class ArrayList<T> implements List<T>{
    // Se parte de un Arreglo estatico; Aplican los metodos estandar de Array.
    private Object[] list; 

    private int size; // cantidad elementos
    // (lenght: cantidad casillas)


    // CONSTRUCTORS
    public ArrayList(){ 
        this.list = new Object[10]; 
        this.size = 0;
    }

    public ArrayList(int lenght){ 
        this.list = new Object[lenght];
        this.size = 0; 
    }


    // METHODS
    @Override
    public void clear() {
        int currentLenght = this.list.length;

        this.list = new Object[currentLenght];
        this.size = 0;
    }

    @Override
    public boolean contains(T e) {
        int index = this.indexOf(e);
        return (index != -1) ? true : false;
    }

    @Override
    public boolean isEmpty() { return this.size == 0; }

    
    //   GETTER
    @Override
    public int indexOf(T e) {
        for( int i = 0; i < this.size; i++){
            if( this.list[i].equals(e) ){ return i; }
        }

        return -1; // if not, return -1
    }

    @Override
    public T get(int index) throws Exception {
        Index.checkValidIndex(index, this.size);
        return (T) this.list[index];
    }

    @Override
    public int size() { return this.size; }
    

    //   ADD
    @Override
    public void add(T e) throws Exception { this.add(size, e); }

    @Override
    public void add(int index, T e) throws Exception {
        Index.checkValidIndex(index, this.size + 1); // Allow index \in [0, current_final_index + 1]

        if( this.size == this.list.length ){
            Object[] temp =  new Object[this.size * 2];

            for(int i = 0; i < this.size; i++){ temp[i] = this.list[i]; }
            this.list = temp;
        }

        for( int i = this.size-1; i >= index; i-- ){
            this.list[i+1] = this.list[i];
        }

        this.list[index] = e;
        this.size++;
    }


    //   REMOVE
    @Override
    public T remove(int index) throws Exception {
        Index.checkValidIndex(index, this.size);

        T e = this.get(index); // obtener elemento
        
        // Mover izq.
        for (int i = index + 1; i < this.size; i++){ 
            this.list[i - 1] = this.list[i]; 
        }
        this.list[ this.size - 1 ] = null;

        size--;
        return e;
    }

    @Override
    public boolean remove(T e) throws Exception {
        int index = this.indexOf(e);
        if(index == -1) return false;

        this.remove(index);
        return true;
    }


    //  Iterator
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            int size = ArrayList.this.size;
            int i = 0;
            Object[] list = ArrayList.this.list;


            @Override
            public boolean hasNext() { return i < size; }

            @Override
            public T next() { 
                T e = (T) list[i+1];
                i++;

                return e;
             }  
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < this.size; i++) {
            sb.append(this.list[i]);
            if(i != this.size - 1) { sb.append(","); }
        }
        
        sb.append("]");
        return sb.toString();
    }

}