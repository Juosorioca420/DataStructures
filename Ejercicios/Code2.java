import java.util.*;

public class Code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scenario = 1;

        while (true) {
            int t = sc.nextInt();
            if (t == 0){ break; }


            System.out.println("Scenario #" + scenario++);

            // Lista de colas; donde indx -> equipo id
            int r = -1; // puntero de lectura
            Queue<Integer>[] equipos_cola = new LinkedList[t];
            

            // asignar numero de equipo a cada dato
            int[] equipo_id = new int[ 1000000 ];

            for (int i = 0; i < t; i++) {
                equipos_cola[i] = new LinkedList<Integer>(); //inicializar colas
                int n = sc.nextInt(); // cantidad integrantes

                for (int j = 0; j < n; j++) {
                    int element = sc.nextInt();

                    equipo_id[element] = i; // Asocia el elemento con su equipo:id; 
                }
            }


            // programar comandos
            Queue<Integer> historial = new LinkedList<>(); 
            // orden de adicion de los equipos 
            // -> si la primera cola se agota, se sigue con la siguiente segun haya sido agregada

            while( true ){
                String comando = sc.next();

                if( comando.equals("STOP") ){ 
                    System.out.println();
                    break; 
                }


                if( comando.equals("ENQUEUE") ){
                    int element = sc.nextInt();
                    int id = equipo_id[element];

                    equipos_cola[id].add(element); 

                    if( !historial.contains(id) ){ historial.add(id); } 
                    if( r == -1 ){ r = historial.peek(); } // inicializar puntero lectura
                }


                if( comando.equals("DEQUEUE") ){
                    System.out.println( equipos_cola[r].poll() );

                    if( equipos_cola[r].isEmpty() ){ // si se ha vaciado la primera cola 
                        historial.poll(); // retirar del historial y pasar a la siguiente

                        if( historial.isEmpty() ) { r = -1; } // todos los equipos se vaciaron; esperar al proximo ENQUEUE
                        else{ r = historial.peek(); }
                    } 
                }
                
            }
        }
        sc.close();

    }
}
