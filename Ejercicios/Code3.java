import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Code3 {
    public static void main( String[] args ) throws IOException{

        int[][] tablero = new int[8][8];
        for ( int i = 0; i < 8; i++){

            for( int j = 0; j< 8; j++){ // j -> letras 0:a, b:1, c:2 ...
                int[] fila = tablero[i];
                fila[j] = j;
                //System.out.print(fila[j]);
            }
            //System.out.println();
        }


        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in) );
        String line = "";
        
        while( (line = bf.readLine()) != null ){

            String[] input_pos = line.split(" ");
            String ini = input_pos[0], fini = input_pos[1];

            int ini_j = (int) ini.charAt(0) - 97;
            int ini_i = Character.getNumericValue( ini.charAt(1) ) - 1;

            int fini_j = (int) fini.charAt(0) - 97;
            int fini_i = Character.getNumericValue( fini.charAt(1) ) - 1;

            int movs = 0;
            Queue< int[] > posiciones = new LinkedList<>();


            if( ini_i == fini_i && ini_j == fini_j ){
                System.out.printf( "To get from %s to %s takes %d knight moves.%n", ini, fini, movs );
                continue;
            }

            while(true){

                int[] posibles_i1 = {ini_i+1, ini_i-1};
                int[] posibles_i2 = {ini_i+2, ini_i-2};
                int[] posibles_j1 = {ini_j+1, ini_j-1};
                int[] posibles_j2 = {ini_j+2, ini_j-2};

                List<Integer> validos_i1 = new ArrayList<>(), validos_i2 = new ArrayList<>();
                List<Integer> validos_j1 = new ArrayList<>(), validos_j2 = new ArrayList<>();

                for( int k = 0; k < 2; k++ ){ 
                    int indx_i1 = posibles_i1[k], indx_j1 = posibles_j1[k];
                    int indx_i2 = posibles_i2[k], indx_j2 = posibles_j2[k];

                    if( indx_i1 >= 0 && indx_i1 < 8 ){ validos_i1.add(indx_i1); }
                    if( indx_j1 >= 0 && indx_j1 < 8 ){ validos_j1.add(indx_j1); }
                    if( indx_i2 >= 0 && indx_i2 < 8 ){ validos_i2.add(indx_i2); }
                    if( indx_j2 >= 0 && indx_j2 < 8 ){ validos_j2.add(indx_j2); }
                }

                // i: y; j: x
                ArrayList<int[]> visitados = new ArrayList<>();
                for( int i : validos_i1 ){
                    for( int j : validos_j2 ){ 
                        int[] pos = {i, j, movs+1};

                        if( !visitados.contains(pos) ){ 
                            visitados.add(pos);
                            posiciones.add(pos); 
                        }
                    }
                }

                for( int i : validos_i2 ){
                    for( int j : validos_j1 ){ 
                        int[] pos = {i, j, movs+1};

                        if( !visitados.contains(pos) ){
                            visitados.add(pos);
                            posiciones.add(pos);
                        }
                    }
                }

                int[] current = posiciones.poll();
                ini_i = current[0]; ini_j = current[1]; movs = current[2];

                if( ini_i == fini_i && ini_j == fini_j ){break;}
            }

            System.out.printf( "To get from %s to %s takes %d knight moves.%n", ini, fini, movs );
        }

        bf.close();

    }
}
