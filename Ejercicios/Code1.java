import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Code1 {
    public static void main( String[] args ) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // Longitud de la serie
        int[] list = new int[n];
        
        String[] numerosStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(numerosStr[i]);
        }


        int[] resultado = new int[n];
        Stack<Integer> stack = new Stack<>();

        for( int i = 0; i < n; i++ ){

            if( !stack.empty() ){
                while( !stack.empty() && list[i] <= list[stack.peek()] ){ stack.pop(); }
            }

            resultado[i] = stack.isEmpty() ? 0 : stack.peek() + 1;

            stack.push(i);
        }

        StringBuilder s = new StringBuilder("");
        for (int i = 0; i < n; i++) {
            s.append(resultado[i]); s.append(" ");
        }
        System.out.println( s.toString() );
    }
}
