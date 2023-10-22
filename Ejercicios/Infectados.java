import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Infectados{
    static int[] students;
    static int[] relaciones;
    static int[] infectados;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] line1 = br.readLine().split(" ");

            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);
            if (n == 0 && m == 0) { break;}


            students = new int[n];
            relaciones = new int[n];
            infectados = new int[n];


            for (int i = 0; i < n; i++) { crear(i); }

            for (int i = 0; i < m; i++) {
                String[] line2 = br.readLine().split(" ");
                int k = Integer.parseInt(line2[0]);
                
                for (int j = 1; j < k; j++) {

                    int s1 = Integer.parseInt(line2[j]);
                    int s2 = Integer.parseInt(line2[j+1]);
                    unir(s1, s2);

                }
            }

            int inicial = find(0);
            System.out.println(infectados[inicial]);
        }

        br.close();
    }

    static void crear(int s1) {
        students[s1] = s1;
        relaciones[s1] = 0;
        infectados[s1] = 1;
    }

    static int find(int s1) {
        if (s1 != students[s1]) { students[s1] = find(students[s1]); }
        return students[s1];
    }

    static void unir(int s1, int s2) {
        s1 = find(s1);
        s2 = find(s2);

        if (s1 == s2){ return; }

        if (relaciones[s1] > relaciones[s2]) {
            students[s2] = s1;
            infectados[s1] += infectados[s2];
        } 
        else {
            students[s1] = s2;
            if (relaciones[s1] == relaciones[s2]) {
                relaciones[s2]++;
            }
            infectados[s2] += infectados[s1];
        }
    }
}
