import Arrays.*;

public class Fruits1{
    public static void main(String[] args) throws Exception {
        // Create DataStructure
        ArrayQueue<String> queue = new ArrayQueue<>(5);


        // add elements
        queue.add("Manzana");
        queue.add("Banano");
        queue.add("Cereza");
        queue.add("Damasco");
        queue.add("Pera");


        // display
        System.out.println( "Original: " + queue.toString() );
        System.out.println("-----------");
        System.out.println();


        // verify contents
        String target1 = "Cereza", target2 = "Fresa";
        System.out.println( target1 + " index:  " + queue.search(target1) );
        System.out.println( target2 + " index:  " + queue.search(target2) );

        System.out.println("-----------");
        System.out.println();


        // obtain elements
        System.out.println( "Head: " + queue.peek() );
        System.out.println("-----------");
        System.out.println();


        // remove elements
        for( int i = 0; i < 4; i++ ){ queue.poll(); }

        System.out.println( "Empty: " + queue.empty() );
        System.out.println( "New: " + queue.toString() );
        System.out.println("-----------");
        System.out.println();


        queue.add("Fresa");
        queue.add("Kiwi");   
        queue.add("Mango");   
        queue.add("Lulo"); 
        
        // for each
        System.out.println( "Lulo" + " index:  " + queue.search("Lulo") );
        System.out.println( queue.toString() );

        System.out.println("for each:");
        for(String item : queue){ System.out.println(" - " + item); }

    }
}
