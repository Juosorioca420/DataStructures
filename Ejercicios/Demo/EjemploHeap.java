package Demo;
import java.util.Comparator;
import java.util.PriorityQueue;

public class EjemploHeap{
    public static void main(String[] args) {
        // Crear una cola de prioridad
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // Agregar elementos a la cola de prioridad
        pq.offer(5);
        pq.offer(2);
        pq.offer(8);
        pq.offer(1);
        pq.offer(6);

        System.out.println("Cola de prioridad (orden natural): " + pq);



        int peekedElement = pq.peek();
        System.out.println("Elemento con mayor prioridad (sin eliminar): " + peekedElement);


        // Eliminar y obtener el elemento con la mayor prioridad
        pq.poll();
        int polledElement1 = pq.poll();
        System.out.println("Elemento con mayor prioridad (eliminado): " + polledElement1);

        // Cola de prioridad después de eliminar el elemento de mayor prioridad
        System.out.println("Cola de prioridad actualizada: " + pq);


        // Verificar si la cola de prioridad está vacía
        boolean isEmpty = pq.isEmpty();
        System.out.println("¿La cola de prioridad está vacía? " + isEmpty);


        // Obtener el tamaño de la cola de prioridad
        int size = pq.size();
        System.out.println("Tamaño de la cola de prioridad: " + size);

    }
}
