import Heaps.MaxHeap;
import Heaps.MinHeap;
import Heaps.Utils.Heap;

public class HeapTest {
    public static void main(String[] args) throws Exception {

       Heap<Integer> heap = new MinHeap<>(20);
       heap.add(4);
       heap.add(10);
       heap.add(9);
       heap.add(15);
       heap.add(11);
       System.out.println("--------------------------");
       System.out.println(heap);
       System.out.println("--------------------------");

       heap.add(20);
       System.out.println();
       System.out.println(heap);
       System.out.println("--------------------------");



       System.out.println(heap.get());

       heap.extract();
       System.out.println("--------------------------");
       System.out.println(heap);
       System.out.println("--------------------------");

       heap.extract();
       System.out.println();
       System.out.println(heap);
       System.out.println("--------------------------");

       

       heap.add(14);
       heap.add(15);
       heap.add(17);
       heap.add(18);
       System.out.println();
       System.out.println(heap);


       System.out.println();


       heap.update(7, 22);
       System.out.println("--------------------------");
       System.out.println(heap);
       System.out.println("--------------------------");

       heap.update(2, 12);

       System.out.println();
       System.out.println(heap);
       System.out.println("--------------------------");



       int element = heap.remove(6);
       System.out.println(element);

       System.out.println("--------------------------");
       System.out.println(heap);
       System.out.println("--------------------------");

    }

}
