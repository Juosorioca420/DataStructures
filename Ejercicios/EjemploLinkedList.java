import java.util.LinkedList;

public class EjemploLinkedList {
    public static void main(String[] args) {
        // Crear una lista enlazada
        LinkedList<String> linkedList = new LinkedList<>();

        // Agregar elementos al final de la lista
        linkedList.add("Manzana");
        linkedList.add("Banano");
        linkedList.add("Cereza");
        linkedList.add("Damasco");

        // Agregar elementos en una posición específica
        linkedList.add(2, "Fresa");

        // Mostrar la lista
        System.out.println("Lista Original: " + linkedList);

        // Obtener y mostrar el primer elemento
        String firstElement = linkedList.getFirst();
        System.out.println("Primer Elemento: " + firstElement);

        // Obtener y mostrar el último elemento
        String lastElement = linkedList.getLast();
        System.out.println("Último Elemento: " + lastElement);

        // Verificar si la lista contiene un elemento específico
        boolean containsBanana = linkedList.contains("Banano");
        System.out.println("¿Contiene 'Banano'? " + containsBanana);

        // Encontrar el índice de un elemento
        int indexCherry = linkedList.indexOf("Cereza");
        System.out.println("Índice de 'Cereza': " + indexCherry);

        // Eliminar el primer elemento
        linkedList.removeFirst();

        // Eliminar el último elemento
        linkedList.removeLast();

        // Eliminar un elemento en una posición específica
        linkedList.remove(2);

        // Mostrar la lista después de las eliminaciones
        System.out.println("Lista después de eliminaciones: " + linkedList);

        // Recorrer la lista e imprimir cada elemento
        System.out.println("Recorriendo la lista:");
        for (String fruit : linkedList) {
            System.out.println("- " + fruit);
        }

        // Obtener el tamaño de la lista
        int size = linkedList.size();
        System.out.println("Tamaño de la lista: " + size);

        // Verificar si la lista está vacía
        boolean isEmpty = linkedList.isEmpty();
        System.out.println("¿La lista está vacía? " + isEmpty);

        // Limpiar la lista (eliminar todos los elementos)
        linkedList.clear();
        System.out.println("Lista después de limpiar: " + linkedList);
    }
}
