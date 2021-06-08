package algoritmos;

import java.util.LinkedList;
import java.util.List;

public class BMH {

    public BMH() {   	
    }
    
     public static void preparacion(char patron[], int ascii[], int longitudPatron) {
        int i = 0;
        while (i < ascii.length) {
            ascii[i] = longitudPatron;
            i++;
        }
        i = 0;
        while (i < longitudPatron - 1) {
            ascii[patron[i]] = longitudPatron - i - 1;
            i++;
        }
    }

    public static List<Integer> BMH(char texto[], char patron[], int ascii[], int longitudPatron, int longitudTexto) {
        List<Integer> ocurrencias = new LinkedList<>();
        int i = 0;
        int j = 0;

        while (j <= longitudTexto - longitudPatron) {
            i = longitudPatron - 1;
            while (i >= 0 && patron[i] == texto[i + j]) {
                i--;
            }
            if (i < 0) {
                ocurrencias.add(j);
                j = j + 1;
            } else {
                j = j + ascii[texto[j + longitudPatron - 1]];
            }
        }
        return ocurrencias;
    }

    public static void imprimir(String t, String p) {
        char texto[] = t.toCharArray();
        char patron[] = p.toCharArray();
        int charM = 99999;
        int ascii[] = new int[charM];
        //int ascii[] = new int[256];
        
        double inicio = System.nanoTime();
        
        preparacion(patron, ascii, patron.length);
        List<Integer> ocurrencias = BMH(texto, patron, ascii, patron.length, texto.length);
        
        double fin = System.nanoTime();      
        double tiempo = (fin - inicio)/1000000;
        
        System.out.println("  - Número total de ocurrencias del patrón ->"+p+"<- es: " + ocurrencias.size());
        System.out.println("  - En los índices: " + ocurrencias);
        System.out.println("  - Tiempo de BMH "+ tiempo+ " ms");
    }
}
