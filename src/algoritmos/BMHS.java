package algoritmos;

import java.util.LinkedList;
import java.util.List;

public class BMHS {

    public BMHS() {
    }

    public int[] tablaBMHS(String patron) {
        int m = patron.length();
        int charM = 99999;

        int[] bmhsTable = new int[charM];

        for (int i = 0; i < charM; i++) {
            bmhsTable[i] = m + 1;
        }

        for (int j = 0; j < m; j++) {
            bmhsTable[patron.charAt(j)] = m - j;

        }
        return bmhsTable;
    }

    public void BMHS(String texto, String patron) {
        long inicio = System.nanoTime();

        int p = patron.length();
        int t = texto.length();
        int[] tab = tablaBMHS(patron);
        int i = p - 1;
        int cont = 0;
        List<Integer> ocurrenciasAux = new LinkedList<>();
        
        while (i < t) {
            int k = i;
            int j = p - 1;

            while (j >= 0 && (texto.charAt(k) == patron.charAt(j))) {
                j--;
                k--;
            }

            if (j < 0) {
                cont++;
                ocurrenciasAux.add( i - (p-1));
                i++;
            }
            i = i + tab[texto.charAt(i + 1)];
        }
        long fin = System.nanoTime();
        double tiempo2 = (fin - inicio) / 1000000;

        System.out.println("  - Número total de ocurrencias del patrón ->" + patron + "<- es: " + cont);
        System.out.println("  - En los índices: " + ocurrenciasAux);
        System.out.println("  - Tiempo de BMHS " + tiempo2 + " ms");
    }
}
