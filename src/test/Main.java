package test;

import algoritmos.*;
import archivo.*;

import javax.swing.JOptionPane;

public class Main {

    public static String lecturaTxtLocal(String rutaLocal) {
        ArchivoTXT txt = new ArchivoTXT(rutaLocal, "\n");
        String str[][] = txt.leerTodo();
        String texto = "";
        for (String[] str1 : str) {
            for (String str2 : str1) {
                texto += str2;
            }
            texto += "\n";
        }
        return texto;
    }

    public static void elegirAlgortimo(int n, String texto, String patron) {
        BMH bmh = new BMH();
        BMHS bmhs = new BMHS();
        KMP kmp = new KMP();
        FuerzaBruta fuerza = new FuerzaBruta();
        if (n == 1) {
            fuerza.fuerzaBruta(texto, patron);
        } else if (n == 2) {
            kmp.KMP(texto, patron);
        } else if (n == 3) {
            bmh.imprimir(texto, patron);
        } else if (n == 4) {
            bmhs.BMHS(texto, patron);
        }
    }

    public static void main(String[] args) {

        System.out.println("*******************************************************************************\n*"
                + "                   BIENVENIDO AL ANÁLISIS DE TIEMPOS *\n"
                + "*******************************************************************************");

        String texto = lecturaTxtLocal("E:\\Usuario\\Desktop\\text.txt");

        int opcion = 0;
        String el;
        
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        " 1. FUERZA BRUTA \n"
                        + " 2. KMP \n"
                        + " 3. BMH \n"
                        + " 4. BMHS \n"
                        + " 5.Salir", "Algoritmos para realizar la búsqueda", 3));

                switch (opcion) {
                    case 1:
                        try {
                            el = JOptionPane.showInputDialog(null, "Digite el patrón a buscar en el texto:",
                                    "Patrón a buscar... ", 3);
                            System.out.println("\nEl costo del algoritmo para ->FUERZA BRUTA<-  es:");
                            elegirAlgortimo(opcion, texto, el);
                            System.out.println("\n-----------Finalizado-------------------");
                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            el = JOptionPane.showInputDialog(null, "Digite el patrón a buscar en el texto:",
                                    "Patrón a buscar... ", 3);
                            System.out.println("\nEl costo del algoritmo para ->KMP<-  es:");
                            elegirAlgortimo(opcion, texto, el);
                            System.out.println("\n-----------Finalizado-------------------");

                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 3:
                        try {
                            el = JOptionPane.showInputDialog(null, "Digite el patrón a buscar en el texto:",
                                    "Patrón a buscar... ", 3);
                            System.out.println("\nEl costo del algoritmo para ->BMH<-  es:");
                            elegirAlgortimo(opcion, texto, el);
                            System.out.println("\n-----------Finalizado-------------------");

                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 4:
                        try {
                            el = JOptionPane.showInputDialog(null, "Digite el patrón a buscar en el texto:",
                                    "Patrón a buscar... ", 3);
                            System.out.println("\nEl costo del algoritmo para ->BMHS<-  es:");
                            elegirAlgortimo(opcion, texto, el);
                            System.out.println("\n-----------Finalizado-------------------");

                        } catch (NumberFormatException n) {
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción incorrecta");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }

        } while (opcion != 5);
    }
}
