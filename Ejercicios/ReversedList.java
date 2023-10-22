
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

public class ReversedList{
    
    static class ReversedListSol<T> {
        public HeadNode<T> reversed( HeadNode<T> head ){
            if( head == null || head.getNext() == null ){ return head; }

            HeadNode<T> prev = null;
            HeadNode<T> current = head;
            HeadNode<T> after = head.getNext();

            while( after != null ){
                current.setNext(prev);

                prev = current; current = after; after = after.getNext();
            }
            current.setNext(prev);
            prev = current;

            return prev;
        }
    }
    public static void main( String[] args ){

        HeadNode<Integer> head = new HeadNode<>(1);
        head.setNext(new HeadNode<>(2));
        head.getNext().setNext(new HeadNode<>(3));
        head.getNext().getNext().setNext(new HeadNode<>(4));
        //head.getNext().getNext().getNext().setNext(head);
        
        ReversedListSol<Integer> sol =  new ReversedListSol<>();
        HeadNode<Integer> reversed = sol.reversed(head);

        System.out.println(reversed);
    }
}