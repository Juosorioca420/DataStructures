import java.util.Stack;

public class EjemploStack {

    public static void main(String[] args) {
        // Crear una instancia de Stack
        Stack<String> pila = new Stack<>();

        // Agregar elementos a la pila
        pila.push("Elemento 1");
        pila.push("Elemento 2");
        pila.push("Elemento 3");

        // Verificar si la pila está vacía
        boolean estaVacia = pila.isEmpty();
        System.out.println("¿La pila está vacía? " + estaVacia);

        // Obtener el tamaño de la pila
        int tamano = pila.size();
        System.out.println("Tamaño de la pila: " + tamano);

        // Obtener y mostrar el elemento en la cima de la pila sin eliminarlo
        String elementoEnCima = pila.peek();
        System.out.println("Elemento en la cima de la pila: " + elementoEnCima);
        System.out.println("index: " + pila.indexOf(elementoEnCima));

        // Eliminar y mostrar el elemento en la cima de la pila
        String elementoEliminado = pila.pop();
        System.out.println("Elemento eliminado de la cima de la pila: " + elementoEliminado);

        // Verificar si un elemento específico está en la pila
        boolean contieneElemento = pila.contains("Elemento 2");
        System.out.println("¿La pila contiene 'Elemento 2'? " + contieneElemento);

        // Mostrar el contenido completo de la pila
        System.out.println("Contenido de la pila después de eliminar un elemento: " + pila);

        // Vaciar la pila
        pila.clear();
        System.out.println("Pila después de vaciarla: " + pila);


        System.out.println("-----------------------");
        pila.push("Elemento 1");
        pila.push("Elemento 2");
        pila.push("Elemento 3");
        for( String e : pila){ System.out.println(e);}
        System.out.println("-----------------------");
        System.out.println(pila);
    }
}
