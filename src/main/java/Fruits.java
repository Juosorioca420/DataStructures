import Arrays.*;

public class Fruits {
    public static void main(String[] args) throws Exception {
        // Create DataStructure

        //ArrayList<String> list = new ArrayList<>();
        DoubleLinkedList<String> list = new DoubleLinkedList<>();


        // add elements
        list.add("Manzana");
        list.add("Banano");
        list.add(0, "Cereza");
        list.add(1, "Damasco");
        list.add("Pera");   
        list.add("Manzana");
        list.add("Banano");
        list.add(0, "Cereza");
        list.add(1, "Damasco");
        list.add("Pera");   



        // display
        System.out.println( "Original: " + list.toString() );
        System.out.println();


        // verify contents
        String target1 = "Banano", target2 = "Fresa";
        System.out.println( target1 + "?  " + list.contains(target1) + " | index: " + list.indexOf(target1));
        System.out.println( target2 + "?  " + list.contains(target2) + " | index: " + list.indexOf(target2));

        System.out.println();


        // obtain elements
        try {
            String element = list.get(3);
            System.out.println("Index 3: " + element);

            String element1 = list.get(list.size() / 2);
            System.out.println("Mid Index: " + element1);

            //String element2 = list.get(list.size() + 1);
            
        } catch(Exception e){ System.out.println("\nError: " + e.getMessage()); }

        System.out.println();


        // remove elements
        Boolean r1 = list.remove("Banano");
        String r2 = list.remove(0);
        String r3 = list.remove( list.size() - 1 );

        System.out.println("Removed Banano: " + r1);
        System.out.println("Removed Index 0: " + r2);
        System.out.println("Removed Index final: " + r3);

        System.out.println( "New List: " + list.toString() );

        System.out.println();


        // for each
        System.out.println("for each:");
        for(String item : list){ System.out.println(" - " + item); }

    }
}
