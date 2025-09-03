package ar.edu.utnfrc.backend;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        punto1();
    }

    public static void punto1() {
        char asterisco = '*';
        char espacio = ' ';
        //FIGURA 3
        for (int filas = 1; filas <= 5; filas++) {
            for (int columnas = 1; columnas <= 5; columnas++) {
                if (columnas <= filas) {
                    System.out.print(asterisco);
                } else {
                    System.out.print(espacio);
                }
            }
            System.out.println();
        }
        
        System.out.println();
        //FIGURA 1
        for (int filas = 1; filas <= 6; filas++) {
            for (int columnas = 1; columnas <= 6; columnas++) {
                if (columnas <= 6) {
                    System.out.print(asterisco);
                } else {
                    System.out.print(espacio);
                }
            }
            System.out.println();
        }
        
        System.out.println();
        //FIGURA 2
        boolean primeravez = true;
        for (int filas = 1; filas <= 6; filas++) {
            for (int columnas = 1; columnas <= 6; columnas++) {
                if(primeravez && filas % 2 == 0){
                    System.out.print(espacio);
                    primeravez = false;
                }
                if (columnas <= 6) {
                    System.out.print(asterisco);
                } else {
                    System.out.print(espacio);
                }
            }
            System.out.println();
            if(filas % 2 == 0){
                primeravez = true;
            }
        }
        System.out.println();
        //FIGURA 4
        for (int filas = 1; filas <= 5; filas++) {
            for (int columnas = 1; columnas <= filas; columnas++) {
                if (columnas <= filas) {
                    System.out.print(asterisco);
                } else {
                    System.out.print(espacio);
                }
            }
            System.out.println();
        }
        for (int filas = 4; filas >= 1; filas--) {
            for (int columnas = 1; columnas <= filas; columnas++) {
                if (columnas <= filas) {
                    System.out.print(asterisco);
                } else {
                    System.out.print(espacio);
                }
            }
            System.out.println();
        }
    }
}
