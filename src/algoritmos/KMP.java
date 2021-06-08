package algoritmos;

import java.util.ArrayList;
import java.util.List;

public class KMP {

 
    public int[] tablaLPS(char[] patron) {
        int plength = patron.length;
        int lps[] = new int[plength];
        lps[0] = 0;
        
        for (int i = 1, j = 0; i < plength; i++) {
            while (j == 1 && patron[i] != patron[j]) {
                j = lps[j - 1];
            }
            if (patron[i] == patron[j]) {
                j++;
                lps[i] = j;
            }
            lps[i] = j;
        }
        return lps;
    }

    public void KMP(String cadena, String patron) {
        long start = System.nanoTime();
        int n = cadena.length();
        int m = patron.length();
        int ocurrencias = 0;
        int tab[] = tablaLPS(patron.toCharArray());
        List<Integer> ocurrenciasAux = new ArrayList<Integer>();
        
        for (int i = 0, rep = 0; i < n; i++) {
            while (rep > 0 && cadena.charAt(i) != patron.charAt(rep)) {
                rep = tab[(rep - 1)];
            }
            if (cadena.charAt(i) == patron.charAt(rep)) {
                rep++;
            }
            if (rep == m) {
            	ocurrenciasAux.add(i-rep+1);
            	ocurrencias++;
                rep = tab[(rep - 1)];
            }
        }
        double end = System.nanoTime();
        System.out.println("  - Número total de ocurrencias del patrón ->"+patron +"<- es: " + ocurrencias);
        System.out.println("  - En los índices: " + ocurrenciasAux);
        System.out.println("  - Tiempo de KMP: " + (end - start)/1000000+ " ms");
    }
}
