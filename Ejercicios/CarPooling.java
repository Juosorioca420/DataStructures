import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CarPooling {
    static public boolean carPooling( int[][] trips, int capacidad ){
        
        // [ [passangers, start, end] ]
        Arrays.sort( trips, Comparator.comparingInt(t -> t[1]) );
        PriorityQueue< int[] > pq = new PriorityQueue<>( Comparator.comparingInt(t -> t[2]) );

        int ocupacion = 0;
        for( int[] t : trips ){
            int n = t[0], start = t[1]; // end = t[2];

            while( !pq.isEmpty() && pq.peek()[2] <= start ){
                ocupacion -= pq.poll()[0];
            }

            ocupacion += n;
            if( ocupacion > capacidad ){ return false; }

            pq.add(t);
        }

        return true;

    }

    public static void main(String[] args) {
        int capacity1 = 4;
        int[][] trips1 = {{2, 1, 5}, {3, 3, 7}}; 
        System.out.println(carPooling(trips1, capacity1)); // false

        int capacity2 = 4;
        int[][] trips2 = {{2, 1, 3}, {3, 3, 7}};
        System.out.println(carPooling(trips2, capacity2)); // true
        
    }
}
