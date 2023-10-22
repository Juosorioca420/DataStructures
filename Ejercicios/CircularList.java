
class HeadNode<T>{
    private T value;
    private HeadNode<T> next;

    public HeadNode(T e){ this.value = e; this.next = null;}

    public T getValue() {
        return value;
    }
    public HeadNode<T> getNext() {
        return next;
    }
    public void setValue(T value) {
        this.value = value;
    }
    public void setNext(HeadNode<T> next) {
        this.next = next;
    }
}

public class CircularList{
    static class CircularListSol<T> {
        public boolean circular( HeadNode<T> head ){
                if( head == null ){ return false; }

                HeadNode<T> t = head, l = head;
                while( l != null && l.getNext() != null ){
                    t = t.getNext(); l = l.getNext().getNext();
                    if( t == l ){ return true; }
                }

                return false;
        }
    }

    public static void main( String[] args ){
        HeadNode<Integer> head = new HeadNode<>(1);
        head.setNext(new HeadNode<>(2));
        head.getNext().setNext(new HeadNode<>(3));
        head.getNext().getNext().setNext(new HeadNode<>(4));
        head.getNext().getNext().getNext().setNext(head);
        
        CircularListSol<Integer> sol =  new CircularListSol<>();
        boolean circular = sol.circular(head);

        System.out.println(circular);
    }
}