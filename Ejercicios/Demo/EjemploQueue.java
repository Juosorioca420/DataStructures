package Demo;
import java.util.LinkedList;
import java.util.Queue;

public class EjemploQueue {
    public static void main(String[] args) {
        // Crear una cola utilizando una implementación de LinkedList
        Queue<String> cola = new LinkedList<>();

        // Agregar elementos a la cola
        cola.offer("Elemento 1");
        cola.offer("Elemento 2");
        cola.offer("Elemento 3");

        // Mostrar el contenido de la cola
        System.out.println("Contenido de la cola: " + cola);

        // Obtener el primer elemento de la cola sin eliminarlo
        String primerElemento = cola.peek();
        System.out.println("Primer elemento de la cola (peek): " + primerElemento);

        // Eliminar y obtener el primer elemento de la cola
        String elementoEliminado = cola.poll();
        System.out.println("Elemento eliminado de la cola (poll): " + elementoEliminado);
        
        // Mostrar el contenido de la cola después de la eliminación
        System.out.println("Contenido de la cola después de la eliminación: " + cola);

        // Verificar si la cola contiene un elemento específico
        boolean contieneElemento2 = cola.contains("Elemento 2");
        System.out.println("¿La cola contiene 'Elemento 2'? " + contieneElemento2);

        // Obtener el tamaño de la cola
        int tamañoCola = cola.size();
        System.out.println("Tamaño de la cola: " + tamañoCola);

        // Vaciar la cola
        cola.clear();
        System.out.println("La cola está vacía: " + cola.isEmpty());


        System.out.println("-----------------------");
        cola.offer("Elemento 1");
        cola.offer("Elemento 2");
        cola.offer("Elemento 3");
        for( String e : cola){ System.out.println(e);}
        System.out.println("-----------------------");
        System.out.println(cola);

    }
}
