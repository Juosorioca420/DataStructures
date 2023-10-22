import Trees.IterativeBST;
import Trees.RecursiveBST;

public class BinaryTreeTest {
    public static void main(String[] args) {
        System.out.println();

        RecursiveBST<Integer> bst = new RecursiveBST<>();
        //IterativeBST<Integer> bst = new IterativeBST<>();

        // Casos de prueba para insert
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(18);
        bst.insert(19);
        bst.insert(20);

        System.out.println(bst);
        System.out.println("---------------------------------");



        // Casos de prueba para search
        System.out.println("Búsqueda de elementos:");
        System.out.println("Buscar 5: " + bst.search(5)); 
        System.out.println("Buscar 8: " + bst.search(8)); 

        System.out.println("---------------------------------");


        // Casos de prueba para delete
        System.out.println("Delete...");
        //bst.delete(15); 

        bst.delete(19); 
        bst.delete(20); 

        bst.delete(10); 

        System.out.println("---------------------------------");



        // Casos de prueba para recorridos
        System.out.println("\nRecorridos:");

        System.out.println("In-Order: ");
        bst.inOrder(); 
        System.out.println();

        System.out.println("Pre-Order: ");
        bst.preOrder(); 
        System.out.println();

        System.out.println("Post-Order: ");
        bst.postOrder();
        System.out.println();

        System.out.println("---------------------------------");



        // Casos de prueba para height y size
        System.out.println("\n\nAltura del árbol: " + bst.height()); 
        System.out.println("Tamaño del árbol: " + bst.size()); 

        System.out.println("---------------------------------");




        // Casos de prueba para minValue y maxValue
        System.out.println("Valor mínimo: " + bst.minValue()); // Debería ser 3
        System.out.println("Valor máximo: " + bst.maxValue()); // Debería ser 12

        System.out.println("---------------------------------");




        // Caso de prueba para isBalanced
        System.out.println("¿El árbol es equilibrado? " + bst.isBalanced()); // Debería ser true

        System.out.println("---------------------------------");
        System.out.println(bst);

    }
}
