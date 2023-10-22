import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Dulzura{

    static public int movDulzura(PriorityQueue<Integer> galletas, int k){

        int movimientos = 0;
        while( galletas.size() >= 2 ){
            int min1 = galletas.poll(), min2 = galletas.poll();
            if( min1 >= k ){ return movimientos; }

            galletas.add(min1 + 2*min2);
            movimientos++;
        }
        if( galletas.peek() >= k ){ return movimientos; } //caso en que quede una unica galleta.

        return -1;
    }

    public static void main( String[] args ) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int k = Integer.parseInt(line[1]);

        String[] data = bf.readLine().split(" ");
        PriorityQueue<Integer> galletas = new PriorityQueue<>();
        for( String galleta : data ){ 
            galletas.add(Integer.parseInt(galleta)); 
        }

        bf.close();

        int movimientos = movDulzura(galletas, k);
        System.out.print(movimientos);
    }
}