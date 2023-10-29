package Heaps;
import Heaps.Utils.Heap;


public class MaxHeap<T extends Comparable<T>> implements Heap<T> {

    private Object[] elements;
    private int size;

    public MaxHeap() { this(10); }
    public MaxHeap(int capacity) {
        this.size = 0;
        this.elements = new Object[capacity];
    }


    @Override
    public T extract() {
        if(this.size == 0){ return null; }

        T max = (T) this.elements[0];
        this.size--;

        if(size > 0) { 
            this.elements[0] = this.elements[this.size];
        }

        this.elements[this.size] = null;
        this.siftDown(0);

        return max;
    }

    @Override
    public T get() {
        if(this.size == 0){ return null; }
        return (T) this.elements[0];
    }

    @Override
    public void add(T element) {
        if( this.size == this.elements.length ){
            throw new RuntimeException("Heap at full capacity");
        }

        this.elements[this.size++] = element;
        this.siftUp(this.size - 1);
    }

    @Override
    public void update(int i, T element) {
        if( this.size == 0 ){ throw new RuntimeException("Can not update from Empty Heap");}
        if(i >= this.size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        T temp = (T) this.elements[i];
        this.elements[i] = element;

        if(element.compareTo(temp) > 0){ this.siftUp(i); }
        else if(element.compareTo(temp) < 0){ this.siftDown(i); }

    }

    @Override
    public T remove(int i) {
        if( this.size == 0 ){ throw new RuntimeException("Can not remove from Empty Heap");}
        if(i >= this.size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        
        T deleted = (T) this.elements[i];

        this.elements[i] = this.elements[0];
        this.siftUp(i);
        this.extract();

        return deleted;
    }


    private void siftUp(int i){
        
        int parent = (i-1)/2;
        if( ( (T) this.elements[ parent ] ).compareTo( (T) this.elements[i] ) < 0 ){

            T temp = (T) this.elements[ parent ];
            this.elements[ parent ] = this.elements[i];
            this.elements[i] = temp;
            
            siftUp(parent);
        }
        return;

    }


    private void siftDown(int i) {

        while (i < this.size){

            int indx = i;
            int lindx = 2*i + 1;
            int rindx = 2*i + 2;

            if( lindx < this.size  &&  ( (T) this.elements[indx] ).compareTo( (T)this.elements[lindx] ) < 0){
                indx =  lindx;
            }

            if( rindx < this.size  &&  ( (T) this.elements[indx] ).compareTo( (T)this.elements[rindx] ) < 0){
                indx =  rindx;
            }

            if( indx == i ){ break; }
            else{
                T temp = (T) this.elements[i];

                this.elements[i] = this.elements[indx];
                this.elements[indx] = temp;

                i = indx;
            }

        }

    }


    @Override
    public String toString() { return this.toString(0); }
    private String toString(int level) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while(i < this.size) {
            int quantity = (int) Math.pow(2,j);
            int k = 0;
            while (k < quantity && i < this.size) {
                sb.append(this.elements[i++] + " ");
                k++;
            }
            sb.append("\n");
            j++;
        }
        return sb.toString();
        
    }

}