package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class FuerzaBruta {

    public void fuerzaBruta(String texto, String patron) {
        long start = System.nanoTime();
        int m = patron.length();
        int n = texto.length();
        int j = 0, ocurrencias = 0;
        List<Integer> ocurrenciasAux = new ArrayList<Integer>();
       
        for (int i = 0; i <= n - m; i++) {
            while (j < m && texto.charAt(i + j) == patron.charAt(j)) {
                j++;
            }
            if (j == m) {
            	ocurrenciasAux.add(i);
                ocurrencias++;
            }
            j = 0;
        }
        double end = System.nanoTime();

        System.out.println("  - Número total de ocurrencias del patrón ->"+patron +"<- es: " + ocurrencias);
        System.out.println("  - En los índices: " + ocurrenciasAux);
        System.out.println("  - Tiempo de Fuerza Bruta: " + (end - start)/1000000+ " ms");
    }
}
